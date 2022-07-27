// https://leetcode.com/problems/top-k-frequent-elements/
// Runtime: 19 ms, faster than 52.74% of Java online submissions for Top K Frequent Elements.
// Memory Usage: 49.7 MB, less than 80.01% of Java online submissions for Top K Frequent Elements.
import java.util.*;
import java.util.stream.Collectors;


public class Leet0347 {

    public static void main(String[] args) {

        int[] input = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(input, k)));
    }

    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> integerCountByIntegerValue = new HashMap<>();

        for (int num : nums)
        {
            integerCountByIntegerValue.merge(num, 1, Integer::sum);
        }

        Set<Integer> topKIntegerCounts = integerCountByIntegerValue.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .collect(Collectors.toSet());

        // build the result using the topKIntegerCounts by searching for them in integerCountByIntegerValue map
        int i = 0;
        int[] result = new int[k];
        for(Integer key : integerCountByIntegerValue.keySet()) {
            if (i == k)
            {
                break;
            }
            if (topKIntegerCounts.contains(integerCountByIntegerValue.get(key))) {
                result[i] = key;
                i++;
            }
        }

        return result;
    }

}
