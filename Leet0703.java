import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet0703 {



    private static PriorityQueue<Integer> minHeap;
    private static int queueSize;

    public static void main(String[] args) {
    //["KthLargest", "add", "add", "add", "add", "add"]
    //[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        int [] input = {};
        KthLargest(1, input);
        add(-3);
        add(-2);
        add(-4);
        add(0);
        add(4);
    }

    public static void KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        queueSize = 1;
        for (int num : nums)
        {
            minHeap.offer(num);
        }
        while (k < minHeap.size())
        {
            minHeap.remove();
        }

    }

    public static int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > queueSize)
        {
            minHeap.remove();
        }
        return minHeap.peek();
    }

// https://leetcode.com/submissions/detail/768551222/
//    class KthLargest {
//
//        private PriorityQueue<Integer> minHeap;
//        private int queueSize;
//        public KthLargest(int k, int[] nums) {
//            minHeap = new PriorityQueue<>();
//            queueSize = k;
//            for (int num : nums)
//            {
//                minHeap.offer(num);
//            }
//            while (queueSize < minHeap.size())
//            {
//                minHeap.remove();
//            }
//        }
//
//        public int add(int val) {
//            minHeap.offer(val);
//            if (minHeap.size() > queueSize)
//            {
//                minHeap.remove();
//            }
//            return minHeap.peek();
//        }
//    }
//
///**
// * Your KthLargest object will be instantiated and called as such:
// * KthLargest obj = new KthLargest(k, nums);
// * int param_1 = obj.add(val);
// */

}
