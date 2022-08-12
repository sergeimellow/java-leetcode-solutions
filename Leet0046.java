// https://leetcode.com/problems/permutations/
import java.util.ArrayList;
import java.util.List;

public class Leet0046 {
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        doPerms(nums, 0, res);
        return res;

    }

    private static void doPerms(int[] nums, int start, List<List<Integer>> res) {
        int temp;

        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            doPerms(nums, start + 1, res);

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }

}
