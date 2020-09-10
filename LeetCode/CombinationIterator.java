import java.util.Iterator;
import java.util.LinkedList;

public class CombinationIterator {
    LinkedList<String> list;
    Iterator<String> iterator;

    public CombinationIterator(String characters, int combinationLength) {
        list = new LinkedList<>();
        char[] ar = characters.toCharArray();
        // Arrays.sort(ar); already sorted
        generatePerms(ar, combinationLength, list, "", 0);
        iterator = list.iterator();
    }

    private void generatePerms(char[] ar, int combinationLength, LinkedList<String> list2, String s, int j) {
        if (combinationLength == 0) {
            list2.add(s);
            return;
        }
        for (int i = j; i < ar.length; i++) {

            generatePerms(ar, combinationLength - 1, list2, s + ar[i], i + 1);

        }
    }

    public String next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public static void main(String[] args) {
        CombinationIterator obj = new CombinationIterator("abcde", 4);
        while (obj.hasNext()) {
            System.out.println(obj.next());
        }
    }
}