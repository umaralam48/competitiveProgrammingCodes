
public class Q6 {
    // the line below is to remove error
    private static int f;

    public static void main(String[] args) {
        parse("invalid");
    }

    private static void parse(String str) {
        try {
            float f = Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
            f = 0;
        } finally {
            System.out.println(f);
        }
    }
}