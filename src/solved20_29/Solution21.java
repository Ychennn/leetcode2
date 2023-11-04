package solved20_29;

import ds.ListNode;

public class Solution21 {//合并两个有序链表

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }

        if (list1 == null) {
            list1 = list2;
        }

        curr.next = list1;
        return dummy.next;
    }
}
