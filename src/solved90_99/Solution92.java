package solved90_99;

import ds.ListNode;

public class Solution92 {//反转链表 II

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 0;
        ListNode node = new ListNode(-1);
        node.next = head;

        //思路：leftPreNode找到left的前一个节点,rightNode找到对应的right节点,
        //截断后再连接起来,用node节点主要是方便操作,排除left=1的情况,因为此时
        //left的前一个为空指针
        ListNode curr = node, leftPreNode = node, rightNode = node;
        while (curr != null) {
            if (index == left - 1) leftPreNode = curr;
            if (index == right) {
                rightNode = curr;
                break;
            }
            curr = curr.next;
            index++;
        }

        ListNode tmp = leftPreNode.next;
        leftPreNode.next = null;
        ListNode tmp2 = rightNode.next;
        rightNode.next = null;
        ListNode reverse = reverse(tmp);
        leftPreNode.next = reverse;
        tmp.next = tmp2;
        return node.next;
    }

    public ListNode reverse(ListNode l) {
        ListNode curr = l, next = null, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void print(ListNode l) {
        while (l != null) {
            System.out.printf(l.val + "->");
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution92.print(head);
        ListNode reverse = solution92.reverseBetween(head, 2, 4);
        solution92.print(reverse);
    }
}
