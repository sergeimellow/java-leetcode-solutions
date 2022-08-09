import java.util.PriorityQueue;
// https://leetcode.com/problems/kth-largest-element-in-an-array/
// https://leetcode.com/submissions/detail/768667269/
public class Leet0215 {
    public static void main(String[] args) {
        int[]  arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargest(arr, k);
    }

    public static int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
         for (int num : nums)
         {
             minHeap.offer(num);
             if (minHeap.size() == k+1) {
                 minHeap.remove();
             }
         }
         return minHeap.peek();
    }
}
