class Solution {
    static void getDistance(int m1, int m2, int d, double dis, double start, double[] disT) {
        // System.out.println(m1+"\t"+m2+"\t"+d+"\t"+dis+"\t"+start);
        if (dis <= 0.0)
            System.out.printf("Done %n Forward %.2f %n Backward %.2f %n Total %.2f", disT[0], disT[1], disT[2]);

        else {
            double tm1 = dis / (d - m1);
            double dd = tm1 * d;
            disT[0] = disT[0] + dd;
            System.out.printf("+ Dog met m1 at %.4f travelling %.4f +%n", (dd + start), dd);
            double dm2 = m2 * tm1;
            double tm2 = (dd - dm2) / (d + m2);
            double dd2 = d * tm2;
            disT[1] += dd2;
            dm2 = start + dd - dd2;
            System.out.printf("- Dog met m2 at %.4f travelling %.4f -%n%n", dm2, dd2);
            disT[2] += dd + dd2;
            double dm1 = start + dd + m1 * tm2;
            dis = dm1 - dm2;
            getDistance(m1, m2, d, dis, dm2, disT);

        }
    }

    public static void main(String[] args) {
        // command to run
        // java Solution 40 50 60 200 0
        int m1 = Integer.parseInt(args[0]);
        int m2 = Integer.parseInt(args[1]);
        int d = Integer.parseInt(args[2]);
        double dis = Double.parseDouble(args[3]);
        double start = Double.parseDouble(args[4]);
        double[] disT = { 0.0, 0.0, 0.0 };
        getDistance(m1, m2, d, dis, start, disT);
    }
}