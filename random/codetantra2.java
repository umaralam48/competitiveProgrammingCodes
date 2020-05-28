
public class codetantra2 {
    public static void main(String[] args) {
        int check = 4;
        if (check == args[0].length()) {
            System.out.println(args[0].charAt(check -= 1) + ",");
        } else {
            System.out.print(args[0].charAt(0) + ",");
        }
    }
}