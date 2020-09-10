public class Hoo {
    public static void main(String[] args) {
        System.out.println(encodeThreestrings("John", "Johny", "Janardhan"));
    }

    public static String encodeThreestrings(String input1, String input2, String input3) {
        String one[] = divide(input1);
        String two[] = divide(input2);
        String three[] = divide(input3);
        String o1 = one[0] + two[1] + three[2];
        String o2 = one[1] + two[2] + three[0];
        String o3 = one[2] + two[0] + three[1];

        return "";

    }

    public static String toggle(String s) {

        for (int i = 0; i < s.length(); i++) {

        }
        return s;
    }

    public static String[] divide(String s) {
        String[] ar = new String[3];
        int[] limits = new int[3];
        if (s.length() % 3 == 0) {
            int lp = s.length() / 3;
            limits[0] = lp;
            limits[1] = lp * 2;
            limits[2] = lp * 3;
        } else if (s.length() % 3 == 1) {
            int lp = s.length() / 3;
            limits[0] = lp;
            limits[1] = limits[0] + lp + 1;
            limits[2] = limits[1] + lp;
        } else {
            int lp = s.length() / 3;
            limits[0] = lp + 1;
            limits[1] = limits[0] + lp;
            limits[2] = limits[1] + lp + 1;
        }
        ar[0] = s.substring(0, limits[0]);
        ar[1] = s.substring(limits[0], limits[1]);
        ar[2] = s.substring(limits[1]);
        return ar;

    }
}