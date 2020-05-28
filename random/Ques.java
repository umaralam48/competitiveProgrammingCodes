import java.util.*;

class Ques {
    static String s = "";

    public static void main(String args[]) {
        Scanner y = new Scanner(System.in);
        System.out.println("Enter a sentence");
        s = y.nextLine();
        s = s.toUpperCase();
        int l = s.length();
        int count = 0;
        for (int i = 0; i < l - 1; i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            else {
                char d = s.charAt(i + 1);
                if (c == d)
                    count++;
            }
        }
        System.out.println("Number of double letters in sentence=" + count);
    }
}