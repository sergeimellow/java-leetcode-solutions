// https://leetcode.com/problems/combination-sum/submissions/
import java.util.ArrayList;
import java.util.List;

public class Leet0039 {
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        combinationSum(nums, 8);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> uniqueSets = new ArrayList<>();
        dfs(0, new ArrayList<>(),0, candidates, uniqueSets, target);

        return uniqueSets.stream().toList();
    }

    public static void dfs(int index, List<Integer> currentSubSet, int total, int[] candidates, List<List<Integer>> uniqueSets, int target)
    {
        if (total == target) {
            uniqueSets.add(new ArrayList<>(currentSubSet));
            return;
        }
        if (index >= candidates.length || total > target )
        {
            return;
        }

        currentSubSet.add(candidates[index]);
        dfs(index, currentSubSet, total + candidates[index], candidates, uniqueSets, target);
        currentSubSet.remove(currentSubSet.size() - 1);
        dfs(index  + 1, currentSubSet, total, candidates, uniqueSets, target);
    }
}
