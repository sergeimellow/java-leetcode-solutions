// https://leetcode.com/problems/reverse-linked-list
public class Leet0206 {
    public static void main(String[] args) {;

        ListNode nodeOne = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;

        ListNode reversedLinkedList = reverseList(nodeOne);
        String a = "ANC";
        System.out.println(reversedLinkedList);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//    public static ListNode reverseList(ListNode head) {
//        return reverseList(null, head);
//    }

    public static ListNode reverseList(ListNode head)
    {
        if (head==null)
        {
            return null;
        }

        ListNode prev = null;
        ListNode curNode = head;
        ListNode next;

        while (curNode != null)
        {
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;

        }

        return prev;
    }

    private static ListNode reverseList(ListNode prev,ListNode curNode){
        if(curNode==null)
        {
            return prev;
        }
        ListNode next = curNode.next;
        curNode.next = prev;
        return reverseList(curNode,next);
    }
}
