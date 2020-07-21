public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder output = new StringBuilder();
        int al = a.length() - 1;
        int bl = b.length() - 1;

        int carry = 0;
        while (al >= 0 && bl >= 0) {
            int sum = (a.charAt(al) - 48) ^ (b.charAt(bl) - 48) ^ carry;
            carry = (a.charAt(al) - 48) & (b.charAt(bl) - 48) | (b.charAt(bl) - 48) & carry
                    | (a.charAt(al) - 48) & carry;
            output.insert(0, sum);
            al--;
            bl--;
        }

        while (al >= 0) {
            int sum = (a.charAt(al) - 48) ^ carry;
            carry = (a.charAt(al) - 48) & carry;
            output.insert(0, sum);
            al--;
        }

        while (bl >= 0) {
            int sum = (b.charAt(bl) - 48) ^ carry;
            carry = (b.charAt(bl) - 48) & carry;
            output.insert(0, sum);
            bl--;
        }
        if (carry > 0)
            output.insert(0, carry);
        return output.toString();

    }
}