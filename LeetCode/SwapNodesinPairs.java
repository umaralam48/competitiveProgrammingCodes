import java.io.FileNotFoundException;

public class SwapNodesinPairs {
    public static void main(String[] args) throws FileNotFoundException {

        ListNode l1 = createList(new int[] { 1, 2, 3, 4, 5 });
        printListNode(swapPairs(l1));

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode temp = head;
        head = head.next;
        temp.next = swapPairs(head.next);
        head.next = temp;
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