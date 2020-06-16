import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofPhonenumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("22"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty())
            return list;
        generate(list, digits, "", 0);
        return list;
    }

    public static void generate(List<String> list, String digits, String ans, int i) {
        String map[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (i == digits.length()) {
            list.add(ans);
            return;
        }
        int n = digits.charAt(i) - 48;
        for (int j = 0; j < map[n].length(); j++) {
            generate(list, digits, ans + map[n].charAt(j), i + 1);
        }

    }
}