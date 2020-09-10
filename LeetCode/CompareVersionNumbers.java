public class CompareVersionNumbers {
    public static void main(String[] args) {
        String v1 = "1.01";
        String v2 = "1.001";
        System.out.println(compareVersion(v1, v2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length;
        int l2 = v2.length;
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            int currentlevel1 = Integer.parseInt(v1[i]);
            int currentlevel2 = Integer.parseInt(v2[j]);
            if (currentlevel1 > currentlevel2)
                return 1;
            else if (currentlevel1 < currentlevel2)
                return -1;
            else {
                i++;
                j++;
            }
        }
        if (i == l1) {
            // v1 finished
            while (j < l2) {
                int currentlevel2 = Integer.parseInt(v2[j]);
                if (currentlevel2 == 0) {
                    j++;
                    continue;
                } else
                    return -1;

            }
            return 0;
        } else {
            // v2 finished
            while (i < l1) {
                int currentlevel1 = Integer.parseInt(v1[i]);
                if (currentlevel1 == 0) {
                    i++;
                    continue;
                } else
                    return 1;
            }
            return 0;
        }

    }
}
