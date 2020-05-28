import java.io.FileNotFoundException;

public class AddTwoNumbers {
    public static void main(String[] args) throws FileNotFoundException {

        ListNode l1 = createList(new int[] { 1 });
        ListNode l2 = createList(new int[] { 9, 9 });
        printListNode(addTwoNumbers(l1, l2));
        // printListNode(l1);

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode end = head;
        // ListNode curr=head;

        // ArrayList<Integer> ar = new ArrayList<>();
        while (l1 != null || l2 != null || carry > 0) {
            int a = l1 == null ? 0 : l1.val;
            l1 = l1 == null ? l1 : l1.next;
            int b = l2 == null ? 0 : l2.val;
            l2 = l2 == null ? l2 : l2.next;
            int sum = (carry + a + b) % 10;
            carry = (carry + a + b) / 10;
            if (head == null) {
                head = new ListNode(sum);
                end = head;
            } else {
                ListNode temp = new ListNode(sum);
                end.next = temp;
                end = temp;
            }
            // ar.add(sum);

        }
        return head;
        // return createList(ar.stream().mapToInt(Integer::intValue).toArray());
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
