
public class q8 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("123456789");
        s.delete(0, 3).replace(1, 3, "24").delete(4, 6);
        System.out.println(s);
    }
}