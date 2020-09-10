import java.util.HashMap;
import java.util.Map;

public class Robot {
    public static void main(String[] args) {
        String s = "MrmlMmR";
        int xmax = 7, ymax = 7;
        int cx = 4, cy = 6;
        String dir = "SW";
        String fdir = dir;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("E", 0);
        map.put("W", 180);
        map.put("N", 90);
        map.put("S", 270);
        map.put("SE", 315);
        map.put("SW", 225);
        map.put("NE", 45);
        map.put("NW", 135);
        HashMap<Integer, Integer[]> angToDis = new HashMap<>();
        angToDis.put(0, new Integer[] { 1, 0 });
        angToDis.put(45, new Integer[] { 1, 1 });
        angToDis.put(90, new Integer[] { 0, 1 });
        angToDis.put(135, new Integer[] { -1, 1 });
        angToDis.put(180, new Integer[] { -1, 0 });
        angToDis.put(225, new Integer[] { -1, -1 });
        angToDis.put(270, new Integer[] { 0, -1 });
        angToDis.put(315, new Integer[] { 1, -1 });
        int currAng = map.get(dir) % 360;
        int px = cx, py = cy;
        boolean err = false;
        for (char c : s.toCharArray()) {
            currAng = (currAng + 360) % 360;
            if (cx > xmax || cy > ymax || cx < 0 || cy < 0) {
                cx = px;
                cy = py;
                err = true;
                break;
            }

            px = cx;
            py = cy;
            switch (c) {
                case 'M':
                    cx += angToDis.get(currAng)[0] * 2;
                    cy += angToDis.get(currAng)[1] * 2;
                    break;
                case 'm':
                    cx += angToDis.get(currAng)[0];
                    cy += angToDis.get(currAng)[1];
                    break;
                case 'L':
                    currAng += 90;
                    break;
                case 'l':
                    currAng += 45;
                    break;
                case 'R':
                    currAng += -90;
                    break;
                case 'r':
                    currAng += -45;
                    break;
                default:
                    break;
            }
        }

        System.out.println(cx);
        System.out.println(cy);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == currAng) {
                fdir = e.getKey();
                break;
            }
        }
        System.out.println(fdir);
        String answer = cx + "-" + cy + "-" + fdir + (err ? "-ER" : "");
        System.out.println(answer);
    }
}