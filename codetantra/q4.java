
public class q4 {
    static String o = "";

    public static void main(String[] args) {
        z: o = o + 2;
        for (int x = 3; x < 8; x++) {
            if (x == 4)
                break;
            if (x == 6)
                // break z;
                o = o + x;
        }
        System.out.println(o);
    }
}