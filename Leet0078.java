// https://leetcode.com/submissions/detail/764204470/
import java.util.*;

public class Leet0078 {
    public static void main(String[] args) {
        int[] n =  { 1,2,3};
        List<List<Integer>> res = subsets(n);
        System.out.println(res);
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> uniqueSets = new ArrayList<>();
        List<Integer> currentSubSet = new ArrayList<>();
        dfs(0, nums, uniqueSets, currentSubSet);

        return uniqueSets;
    }

    public static void dfs(int index, int[] nums, List<List<Integer>> uniqueSets, List<Integer> currentSubSet)
    {
        if (index >= nums.length)
        {
            uniqueSets.add(new ArrayList<>(currentSubSet));
            return;
        }

        // left branches, including the current value of nums[index]
        currentSubSet.add(nums[index]);
        dfs(index+1, nums, uniqueSets, currentSubSet);

        // not including num[index]
        currentSubSet.remove(currentSubSet.size()-1);
        dfs(index + 1, nums, uniqueSets, currentSubSet);
    }
}
