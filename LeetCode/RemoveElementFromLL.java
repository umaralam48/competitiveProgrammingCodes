public class RemoveElementFromLL {
    public static void main(String[] args) {
        int[] ar = { 6, 6 };
        ListNode.printListNode(removeElements(ListNode.createList(ar), 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}