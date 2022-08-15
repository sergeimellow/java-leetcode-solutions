// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class Leet0019 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        removeNthFromEnd(one ,2);

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;

        ListNode leftNode = head;
        ListNode rightNode = head;

        for (int i = 0; i < n; i++)
        {
            rightNode = rightNode.next;
        }

        if (rightNode == null)
        {
            return leftNode.next;
        }

        while (rightNode.next != null)
        {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        
        leftNode.next = leftNode.next.next;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
