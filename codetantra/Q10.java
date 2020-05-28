
public class Q10 {
    public static void main(String[] args) {
        if (testIfB("TRUE"))
            System.out.println("True");
        else
            System.out.println("Not True");
    }

    private static boolean testIfB(String string) {
        return Boolean.valueOf(string);
    }
}