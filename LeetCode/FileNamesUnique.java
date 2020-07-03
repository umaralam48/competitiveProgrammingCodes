import java.util.HashSet;
import java.util.Set;

public class FileNamesUnique {
    public static void main(String[] args) {
        String ar[] = { "kaido", "kaido(1)", "kaido", "kaido(1)" };
        ar = getFolderNames(ar);
        for (String string : ar) {
            System.out.println(string);
        }
        System.out.println();
    }

    public static String[] getFolderNames(String[] names) {
        Set<String> set = new HashSet<>();
        int k = 1;
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            while (set.contains(name)) {
                if (name.charAt(name.length() - 1) == ')')
                    name = name.substring(0, name.length() - 3);
                name = name + '(' + k + ')';
                k++;
                continue;
            }
            set.add(name);
            names[i] = name;
            k = 1;
        }
        return names;
    }
}