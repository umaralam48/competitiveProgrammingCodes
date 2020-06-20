import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        int opening = 1, closing = 0;
        List<String> sol = new ArrayList<>();
        StringBuilder curr = new StringBuilder("(");
        generateParenthesis(n, opening, closing, curr, sol);
        return sol;
    }

    private static void generateParenthesis(int n, int opening, int closing, StringBuilder curr, List<String> sol) {
        if (curr.length() == n * 2)
            sol.add(curr.toString());
        else {
            if (opening >= closing) {
                if (opening < n) {
                    curr.append("(");
                    generateParenthesis(n, opening + 1, closing, curr, sol);
                    curr.deleteCharAt(curr.length() - 1);
                }
                if (closing < n) {
                    curr.append(")");
                    generateParenthesis(n, opening, closing + 1, curr, sol);
                    curr.deleteCharAt(curr.length() - 1);
                }
            }
        }
        // && (opening + closing < n * 2)

    }

}