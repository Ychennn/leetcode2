package solved10_19;

import ds.ListNode;

public class Solution19 {//删除链表的倒数第 N 个结点

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;
        while (n > 1) {
            n--;
            curr = curr.next;
        }

        ListNode pre = dummy;
        while (curr.next != null) {
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
