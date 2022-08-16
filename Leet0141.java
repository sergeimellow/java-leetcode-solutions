// https://leetcode.com/problems/linked-list-cycle/submissions/
public class Leet0141 {
    public static void main(String[] args) {
        ListNode a = new ListNode( 3);
        ListNode b = new ListNode( 2);
        ListNode c = new ListNode( 0);
        ListNode d = new ListNode( -4);
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = b;
        System.out.println(hasCycle(a));
    }
    
    public static boolean hasCycle(ListNode head)
    {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                return true;
            }
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}
