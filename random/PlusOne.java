import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] digit = { 9, 9 };
        System.out.println(Arrays.toString(plusOne(digit)));
    }

    public static int[] plusOne(int[] digits) {

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            if (sum < 10)
                return digits;
            carry = 1;
        }
        int newnum[] = new int[digits.length + 1];
        newnum[0] = 1;
        // for (int i = 1; i < newnum.length; i++) {
        // newnum[i] = digits[i - 1];
        // }
        return newnum;
    }

}