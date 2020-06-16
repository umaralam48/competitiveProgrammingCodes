import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveNthNodefromEnd {
    public static void main(String[] args) throws FileNotFoundException {

        ListNode l1 = createList(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        printListNode(removeNthFromEnd(l1, 1));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode curr = head;
        int c = 0;
        while (curr != null) {
            c++;
            queue.add(curr);
            curr = curr.next;
            if (queue.size() > n + 1)
                queue.remove();
        }
        if (c == n) {
            head = head.next;
        } else {
            ListNode a = queue.remove();
            a.next = a.next.next;
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