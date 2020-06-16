import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SubstringwithConcatenationofwords {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        String s = y.nextLine();
        int n = y.nextInt();
        String nums1[] = new String[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = y.next();
        }

        findSubstring(s, nums1).forEach((num) -> System.out.print(num + " "));
    }

    static HashMap<String, Integer> set;
    static HashMap<String, Integer> set2;

    /*
     * public static List<Integer> findSubstring(String s, String[] words) {
     * List<Integer> list = new ArrayList<>(); if (s.length() == 0 || words.length
     * == 0) return list;
     * 
     * int wl = words[0].length(); for (int i = 0; i < words.length; i++) {
     * 
     * } for (int i = 0; (i + wl - 1) < s.length(); i++) {
     * 
     * } List<Integer> indexes = new ArrayList<>();
     * 
     * return list; }
     */

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || s.length() < words[0].length() * words.length)
            return list;
        set = new HashMap<>();
        set2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (set.containsKey(words[i])) {
                set.put(words[i], set.get(words[i]) + 1);
            } else
                set.put(words[i], 1);
        }
        int l = s.length();
        int wl = words[0].length();
        int i = 0, index = 0, wc = 0;
        while ((i + wl - 1) < l) {
            String word = s.substring(i, i + wl);
            if (set.containsKey(word)) {
                wc++;
                int nw = set.get(word);

                if (set2.containsKey(word))
                    set2.put(word, set2.get(word) + 1);
                else
                    set2.put(word, 1);
                if (nw > 1) {
                    set.put(word, nw - 1);
                } else {
                    set.remove(word);
                }

                i += wl;
            } else {
                // if (!set2.containsKey(word)) {
                // i++;
                // } else {
                i = index + 1;
                // }
                if (!set2.isEmpty()) {
                    set.forEach((wrd, cnt) -> {
                        if (set2.containsKey(wrd))
                            set2.put(wrd, set2.get(wrd) + cnt);
                        else
                            set2.put(wrd, cnt);
                    }); // for (String si : set) // set2.add(si);
                    set.clear();
                    set = set2;
                    set2 = new HashMap<>();
                } // i++;
                wc = 0;
                index = i;
            }

            if (wc == words.length) {
                set.forEach((wrd, cnt) -> {
                    if (set2.containsKey(wrd))
                        set2.put(wrd, set2.get(wrd) + cnt);
                    else
                        set2.put(wrd, cnt);
                }); // for (String si : set) // set2.add(si);
                set.clear();
                set = set2;
                set2 = new HashMap<>();
                wc = 0;
                list.add(index);
                index++;
                i = index;
            }
        }
        return list;
    }

}