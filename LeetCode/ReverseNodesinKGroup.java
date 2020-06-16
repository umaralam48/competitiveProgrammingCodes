import java.io.FileNotFoundException;

public class ReverseNodesinKGroup {
    public static void main(String[] args) throws FileNotFoundException {

        ListNode l1 = createList(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        printListNode(reverseKGroup(l1, 8));

    }

    public static ListNode reverseKGroup(ListNode a, int k) {
        if (a == null)
            return a;
        int n = 0;
        ListNode head = a;
        ListNode prev = null;
        ListNode curr = a;
        ListNode next = null;
        while (curr != null && n != k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n++;
        }

        if (n < k) {
            head = prev;
            curr = prev;
            prev = null;
            next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        head.next = reverseKGroup(next, k);
        return prev;
    }

    public static ListNode reverse(ListNode a) {
        ListNode prev = null;
        ListNode curr = a;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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