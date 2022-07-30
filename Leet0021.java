//https://leetcode.com/problems/merge-two-sorted-lists/
//Runtime: 1 ms, faster than 80.27% of Java online submissions for Merge Two Sorted Lists.
//Memory Usage: 43.4 MB, less than 27.97% of Java online submissions for Merge Two Sorted Lists.

public class Leet0021 {

    public static void main(String[] args) {

        ListNode nodeOneListOne = new ListNode(1);
        ListNode nodeTwoListOne = new ListNode(2);
        ListNode nodeThreeListOne = new ListNode(3);
        ListNode nodeFourListOne = new ListNode(4);
        ListNode nodeFiveListOne = new ListNode(5);
        nodeOneListOne.next = nodeTwoListOne;
        nodeTwoListOne.next = nodeThreeListOne;
        nodeThreeListOne.next = nodeFourListOne;
        nodeFourListOne.next = nodeFiveListOne;


        ListNode nodeOneListTwo = new ListNode(2);
        ListNode nodeTwoListTwo = new ListNode(4);
        ListNode nodeThreeListThree = new ListNode(4);
        nodeOneListTwo.next = nodeTwoListTwo;
        nodeTwoListTwo.next = nodeThreeListThree;

       ListNode reversedLinkedList = mergeTwoLists(nodeOneListOne,  nodeOneListTwo);
        String a = "ANC";
        System.out.println(reversedLinkedList);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy keeps track of the head (dummy.next)
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null)
        {
            if (list1.val > list2.val){
                tail.next = list2;
                list2 = list2.next;
            }
            else
            {
                tail.next = list1;
                list1 = list1.next;
            }

            tail = tail.next;
        }

        if (list1 == null)
        {
            tail.next = list2;
        }
        else
        {
            tail.next = list1;
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    }
}
