public class ReorderList {
    public static void main(String[] args) {
        int[] a = { 1 };
        ListNode l = ListNode.createList(a);
        reorderList(l);
        ListNode.printListNode(l);
    }

    public static void reorderList(ListNode head) {
        if (head == null)
            return;
        recurse(head, head);
    }

    private static ListNode recurse(ListNode curr, ListNode fast) {
        if (fast.next == null) {
            ListNode ln = curr.next;
            curr.next = null;
            return ln;
        } else {
            fast = fast.next;
            boolean flag = true;// list is even length
            if (fast.next != null) {
                fast = fast.next;
                flag = false;
            }
            ListNode ln = recurse(curr.next, fast);
            if (flag) {
                return ln;
            }
            ListNode lnn = ln.next;
            ListNode next = curr.next;
            curr.next = ln;
            ln.next = next;
            return lnn;
        }
    }
}