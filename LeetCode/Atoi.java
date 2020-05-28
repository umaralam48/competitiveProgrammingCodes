import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Atoi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        String nextLine = y.nextLine();

        System.out.println(myAtoi(nextLine));

    }

    public static int myAtoi(String str) {
        str = str.trim();
        int num = 0;
        int flag = -1;
        boolean sencountered = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            if ((charAt == '+' || charAt == '-') && !sencountered) {

                sencountered = true;
                flag = charAt == '-' ? 1 : -1;
            } else if (charAt > 57 || charAt < 48)
                break;
            else {
                sencountered = true;
                if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && -1 * flag * (charAt - 48) < -8))
                    return Integer.MIN_VALUE;
                else if (num > Integer.MAX_VALUE / 10
                        || (num == Integer.MAX_VALUE / 10 && -1 * flag * (charAt - 48) > 7))
                    return Integer.MAX_VALUE;
                else
                    num = num * 10 + -1 * flag * (charAt - 48);
            }

        }
        return num;
    }
}