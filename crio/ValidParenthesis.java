import java.io.*;
import java.util.*;

public class ValidParenthesis {
    // Implement your solution by completing the below function
    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;

        HashMap<Character, Character> push = new HashMap<>();

        push.put('}', '{');
        push.put(')', '(');
        push.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (push.containsValue(c)) {
                stack.push(c);
            } else {
                if (push.containsKey(c)) {
                    if (stack.peek() == push.get(c))
                        stack.pop();
                    else
                        return false;
                }
            }

        }
        return stack.size() == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String parenthesis = in.readLine();
        boolean result = new ValidParenthesis().isValid(parenthesis);
        System.out.print(String.valueOf(result));
    }
}
