public class InsertionSortList {
    public static void main(String[] args) {
        int ar[] = { -1, 5, 3, 4, 0 };
        ListNode head = ListNode.createList(ar);
        ListNode.printListNode(head);
        System.out.println();
        ListNode.printListNode(insertionSortList(head));
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ListNode sorted = null;
        ListNode sc = null;
        ListNode prev = null;
        while (curr != null) {

            if (sc != null && curr.val < sc.val) {
                sc = sorted;
                prev = null;
            }
            while (sc != null && sc.val < curr.val) {
                prev = sc;
                sc = sc.next;
            }
            if (prev == null)// insert at head
            {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = sorted;
                sorted = temp;
                if (sc == null)
                    sc = sorted;
            } else {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = sc;
                if (sc == null)
                    sc = temp;
                prev.next = temp;
            }
        }
        return sorted;
    }

}
