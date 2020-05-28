
public class Q5 {
    public static void main(String[] args) {
        int x = 5;
        boolean b1 = true;
        boolean b2 = false;
        if ((x == 4) && !b1)
            System.out.println("1 ");
        System.out.println("2 ");
        if ((b2 = true) && b1) {
            System.out.println(b2 = false);
        }
    }
}