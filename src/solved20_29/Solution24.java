package solved20_29;

import ds.ListNode;

public class Solution24 {//两两交换链表中的节点

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy, curr1 = head, curr2 = head.next, nextNode;
        while (curr1 != null && curr2 != null) {
            //tail -> curr1 -> curr2 -> nextNode -> ?
            nextNode = curr2.next;
            tail.next = curr2;
            curr1.next = curr2.next;
            curr2.next = curr1;
            //tail -> curr2 -> curr1 -> nextNode -> ?
            
            tail = curr1;
            curr1 = nextNode;

            if (nextNode != null) {
                curr2 = nextNode.next;
            } else {
                curr2 = null;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution24 solution = new Solution24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = solution.swapPairs(node1);
        while (node != null) {
            System.out.println(node.val + " ->");
            node = node.next;
        }
    }
}
