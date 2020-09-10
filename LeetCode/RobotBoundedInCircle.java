public class RobotBoundedInCircle {
    public static void main(String[] args) {
        String instructions = "GGLLGG";
        System.out.println(isRobotBounded(instructions));
    }

    public static boolean isRobotBounded(String instructions) {
        char ins[] = instructions.toCharArray();
        // north,right,south,left
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int currdir = 0;
        Integer[] currPos = { 0, 0 };

        for (char c : ins) {

            if (c == 'G') {
                currPos[0] += dir[currdir][0];
                currPos[1] += dir[currdir][1];
            } else if (c == 'R') {
                currdir = ++currdir % 4;
            } else {
                currdir = (--currdir + 4) % 4;
            }
        }
        if ((currPos[0] == 0 && currPos[1] == 0) || currdir != 0)
            return true;
        return false;
    }
}