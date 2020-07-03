import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinery {
    public static void main(String[] args)

    {
        // {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}
        // String[][] sr = { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, {
        // "JFK", "AXA" }, { "ANU", "JFK" },
        // { "ADL", "ANU" }, { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" }, {
        // "ADL", "EZE" },
        // { "EZE", "ADL" }, { "AXA", "EZE" }, { "AUA", "AXA" }, { "JFK", "AXA" }, {
        // "AXA", "AUA" },
        // { "AUA", "ADL" }, { "ANU", "EZE" }, { "TIA", "ADL" }, { "EZE", "ANU" }, {
        // "AUA", "ANU" } };
        String[][] sr = { { "AXA", "EZE" }, { "EZE", "AUA" }, { "ADL", "JFK" }, { "ADL", "TIA" }, { "AUA", "AXA" },
                { "EZE", "TIA" }, { "EZE", "TIA" }, { "AXA", "EZE" }, { "EZE", "ADL" }, { "ANU", "EZE" },
                { "TIA", "EZE" }, { "JFK", "ADL" }, { "AUA", "JFK" }, { "JFK", "EZE" }, { "EZE", "ANU" },
                { "ADL", "AUA" }, { "ANU", "AXA" }, { "AXA", "ADL" }, { "AUA", "JFK" }, { "EZE", "ADL" },
                { "ANU", "TIA" }, { "AUA", "JFK" }, { "TIA", "JFK" }, { "EZE", "AUA" }, { "AXA", "EZE" },
                { "AUA", "ANU" }, { "ADL", "AXA" }, { "EZE", "ADL" }, { "AUA", "ANU" }, { "AXA", "EZE" },
                { "TIA", "AUA" }, { "AXA", "EZE" }, { "AUA", "SYD" }, { "ADL", "JFK" }, { "EZE", "AUA" },
                { "ADL", "ANU" }, { "AUA", "TIA" }, { "ADL", "EZE" }, { "TIA", "JFK" }, { "AXA", "ANU" },
                { "JFK", "AXA" }, { "JFK", "ADL" }, { "ADL", "EZE" }, { "AXA", "TIA" }, { "JFK", "AUA" },
                { "ADL", "EZE" }, { "JFK", "ADL" }, { "ADL", "AXA" }, { "TIA", "AUA" }, { "AXA", "JFK" },
                { "ADL", "AUA" }, { "TIA", "JFK" }, { "JFK", "ADL" }, { "JFK", "ADL" }, { "ANU", "AXA" },
                { "TIA", "AXA" }, { "EZE", "JFK" }, { "EZE", "AXA" }, { "ADL", "TIA" }, { "JFK", "AUA" },
                { "TIA", "EZE" }, { "EZE", "ADL" }, { "JFK", "ANU" }, { "TIA", "AUA" }, { "EZE", "ADL" },
                { "ADL", "JFK" }, { "ANU", "AXA" }, { "AUA", "AXA" }, { "ANU", "EZE" }, { "ADL", "AXA" },
                { "ANU", "AXA" }, { "TIA", "ADL" }, { "JFK", "ADL" }, { "JFK", "TIA" }, { "AUA", "ADL" },
                { "AUA", "TIA" }, { "TIA", "JFK" }, { "EZE", "JFK" }, { "AUA", "ADL" }, { "ADL", "AUA" },
                { "EZE", "ANU" }, { "ADL", "ANU" }, { "AUA", "AXA" }, { "AXA", "TIA" }, { "AXA", "TIA" },
                { "ADL", "AXA" }, { "EZE", "AXA" }, { "AXA", "JFK" }, { "JFK", "AUA" }, { "ANU", "ADL" },
                { "AXA", "TIA" }, { "ANU", "AUA" }, { "JFK", "EZE" }, { "AXA", "ADL" }, { "TIA", "EZE" },
                { "JFK", "AXA" }, { "AXA", "ADL" }, { "EZE", "AUA" }, { "AXA", "ANU" }, { "ADL", "EZE" },
                { "AUA", "EZE" } };
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < sr.length; i++) {
            List<String> tic = new ArrayList<>();
            tic.add(sr[i][0]);
            tic.add(sr[i][1]);
            list.add(tic);
        }
        System.out.println(findItinerary(list));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> tic : tickets) {
            map.computeIfAbsent(tic.get(0), (k) -> new PriorityQueue<String>()).add(tic.get(1));
        }
        String curr = "JFK";
        List<String> solution = new ArrayList<>();
        solution.add("JFK");
        validIti(map, solution, curr);
        return solution;
    }

    private static boolean validIti(HashMap<String, PriorityQueue<String>> map, List<String> solution, String curr) {
        if (map.isEmpty())
            return true;
        PriorityQueue<String> destq = map.get(curr);
        if (destq == null)
            return false;
        String[] destarray = destq.toArray(new String[destq.size()]);
        Arrays.sort(destarray);
        for (String dest : destarray) {
            solution.add(dest);
            destq.remove(dest);
            if (destq.isEmpty()) {
                map.remove(curr);
            }
            if (validIti(map, solution, dest))
                return true;
            solution.remove(solution.size() - 1);
            destq.add(dest);
            map.computeIfAbsent(curr, (k) -> destq);
        }

        return false;
    }

}

// ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","TIA","AUA","AXA","TIA","ADL","EZE","HBA"]
// ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","HBA","TIA","ADL","EZE","HBA","AUA","AXA","TIA","ADL","EZE","HBA"]
// ["JFK","ADL","ANU","ADL","ANU","AUA","ADL","AUA","ADL","AUA","ANU","AXA","ADL","AUA","ANU","AXA","ADL","AXA","ADL","AXA","ANU","AXA","ANU","AXA","EZE","ADL","AXA","EZE","ADL","AXA","EZE","ADL","EZE","ADL","EZE","ADL","EZE","ANU","EZE","ANU","EZE","AUA","AXA","EZE","AUA","AXA","EZE","AUA","AXA","JFK","ADL","EZE","AUA","EZE","AXA","JFK","ADL","JFK","ADL","JFK","ADL","JFK","ADL","TIA","ADL","TIA","AUA","JFK","ANU","TIA","AUA","JFK","AUA","JFK","AUA","TIA","AUA","TIA","AXA","TIA","EZE","AXA","TIA","EZE","JFK","AXA","TIA","EZE","JFK"
// ,"EZE","TIA","JFK","AXA","TIA","JFK","EZE","TIA","JFK","TIA","JFK","AUA","SYD"]
// ["JFK","ADL","ANU","ADL","ANU","AUA","ADL","AUA","ADL","AUA","ANU","AXA","ADL","AUA","ANU","AXA","ADL","AXA","ADL","AXA","ANU","AXA","ANU","AXA","EZE","ADL","AXA","EZE","ADL","AXA","EZE","ADL","EZE","ADL","EZE","ADL","EZE","ANU","EZE","ANU","EZE","AUA","AXA","EZE","AUA","AXA","EZE","AUA","AXA","JFK","ADL","EZE","AUA","EZE","AXA","JFK","ADL","JFK","ADL","JFK","ADL","JFK","ADL","TIA","ADL","TIA","AUA","JFK","ANU","TIA","AUA","JFK","AUA","JFK","AUA","TIA","AUA","TIA","AXA","TIA","EZE","AXA","TIA","EZE","JFK","AXA","TIA","EZE","JFK"
// ,"AXA","TIA","JFK","EZE","TIA","JFK","EZE","TIA","JFK","TIA","JFK","AUA","SYD"]
// "TIA","JFK","EZE","TIA","JFK","TIA","JFK","AUA","SYD"]