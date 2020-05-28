public class LongestSubstring {
    public static void main(String[] args) {
        String s = "aabcde";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        String sub = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = sub.indexOf(ch);
            if (index != -1) {
                sub = sub.substring(++index);
            }
            sub += ch;
            max = Math.max(max, sub.length());
        }
        return max;
    }
    // using hashmap
    // public static int lengthOfLongestSubstring(String s) {
    // HashMap<Character, Integer> map = new HashMap<>();
    // int max = 0;
    // int i = 0, j = 0;
    // int l = s.length();
    // while (j < l) {
    // char ch = s.charAt(j++);
    // if (map.containsKey(ch)) {
    // i = Math.max(i, map.get(ch));
    // }
    // map.put(ch, j);
    // max = Math.max(max, j - i);
    // }
    // return max;
    // }
}