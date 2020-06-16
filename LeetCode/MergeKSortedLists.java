import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) throws FileNotFoundException {

        ListNode l1 = createList(new int[] { 1, 4, 5 });
        ListNode l2 = createList(new int[] { 1, 3, 4 });
        ListNode l3 = createList(new int[] { 2, 6 });
        printListNode(mergeKLists(new ListNode[] { l1, l2, l3 }));
        // printListNode(l1);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, end = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
        }
        while (!pq.isEmpty()) {
            ListNode min = pq.remove();
            if (min.next != null) {
                pq.add(min.next);
            }
            if (head == null) {
                head = new ListNode(min.val);
                end = head;
            } else {
                end.next = new ListNode(min.val);
                end = end.next;
            }

        }
        return head;
    }

    private static void printListNode(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
    }

    private static ListNode createList(int[] is) {
        ListNode head = null;
        ListNode end = head;
        // ListNode curr=head;
        for (int i = 0; i < is.length; i++) {
            if (head == null) {
                head = new ListNode(is[i]);
                end = head;
            } else {
                ListNode temp = new ListNode(is[i]);
                end.next = temp;
                end = temp;
            }
        }
        return head;
    }
}