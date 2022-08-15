// https://leetcode.com/problems/reorder-list/
import java.util.ArrayList;


public class Leet0143 {

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

        reorderList(one);
    }

    public static void reorderList(ListNode head) {
        if (head.next == null) return;
        ArrayList<ListNode> listNodeArr = new ArrayList<>();
        ListNode prevNode = null;
        while (head != null)
        {
            listNodeArr.add(head);
            head = head.next;
        }

        int leftPointer = 0;
        int rightPointer = listNodeArr.size();
        ListNode left;
        ListNode right;

        while (leftPointer < rightPointer)
        {
            left = listNodeArr.get(leftPointer);
            right = listNodeArr.get(rightPointer - 1);

            if (prevNode != null)
            {
                prevNode.next = left;
            }

            left.next = right;
            right.next = null;
            prevNode = right;

            leftPointer++;
            rightPointer--;
        }
    }

    // fancy way of doing it in space complexity of O(1) instead of O(N)
//    public void reorderList(ListNode head) {
//        if(head==null||head.next==null) return;
//
//        //Find the middle of the list
//        ListNode p1=head;
//        ListNode p2=head;
//        while(p2.next!=null&&p2.next.next!=null){
//            p1=p1.next;
//            p2=p2.next.next;
//        }
//
//        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
//        ListNode preMiddle=p1;
//        ListNode preCurrent=p1.next;
//        while(preCurrent.next!=null){
//            ListNode current=preCurrent.next;
//            preCurrent.next=current.next;
//            current.next=preMiddle.next;
//            preMiddle.next=current;
//        }
//
//        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
//        p1=head;
//        p2=preMiddle.next;
//        while(p1!=preMiddle){
//            preMiddle.next=p2.next;
//            p2.next=p1.next;
//            p1.next=p2;
//            p1=p2.next;
//            p2=preMiddle.next;
//        }
//    }

     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
