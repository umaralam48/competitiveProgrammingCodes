import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ValidateIPAddress {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));
        String ip = y.nextLine();
        System.out.println(validIPAddress(ip));
    }

    public static String validIPAddress(String IP) {
        if (IP.matches("(([1-9]\\d{0,2})|0)\\.(([1-9]\\d{0,2})|0)\\.(([1-9]\\d{0,2})|0)\\.(([1-9]\\d{0,2})|0)")
                && checkRange4(IP))
            return "IPv4";
        else if (IP.matches("\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}")
                && checkRange6(IP))
            return "IPv6";
        else
            return "Neither";
    }

    private static boolean checkRange4(String iP) {
        String[] grps = iP.split("\\.");
        for (int i = 0; i < grps.length; i++) {
            try {
                if (Integer.parseInt(grps[i]) > 255)
                    return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRange6(String iP) {
        iP = iP.toLowerCase();
        String[] grps = iP.split(":");
        int maxR = (int) Math.pow(2, 16) - 1;

        for (int i = 0; i < grps.length; i++) {
            try {
                if (Integer.parseInt(grps[i], 16) > maxR) {
                    System.out.println(grps[i] + " " + Integer.parseInt(grps[i], 16));
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}