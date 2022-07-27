// https://leetcode.com/problems/3sum
// Runtime: 30 ms, faster than 69.70% of Java online submissions for 3Sum.
// Memory Usage: 61.1 MB, less than 27.26% of Java online submissions for 3Sum.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Leet0015 {
	public static void main(String[] args) {
		int [] input = {-1,0,1,2,-1,-4};
		List<List<Integer>> result = threeSum(input);
		System.out.println(result);
    }

	static public List<List<Integer>> threeSum(int[] nums) {
		int midIndex;
		int rightIndex;
		List<List<Integer>> results = new ArrayList<>();
		int numsLength = nums.length;
		Arrays.sort(nums);

		for(int leftIndex = 0; leftIndex < numsLength; leftIndex++)
		{
			if (leftIndex > 0 && nums[leftIndex] == nums[leftIndex - 1]) {
				continue;
			}
			midIndex = leftIndex + 1;
			rightIndex = numsLength - 1;

			while (midIndex < rightIndex) {
				int sum = nums[leftIndex] + nums[midIndex] + nums[rightIndex];

				if (sum > 0) {
					rightIndex = rightIndex - 1;
				}
				else if (sum < 0) {
					midIndex = midIndex + 1;
				}
				else {
					results.add(new ArrayList<>(Arrays.asList(nums[leftIndex], nums[midIndex], nums[rightIndex])));
					midIndex = midIndex + 1;
					while (nums[midIndex] == nums[midIndex - 1] && midIndex < rightIndex) {
						midIndex = midIndex + 1;
					}
				}
			}

		}

		return results;
	}
}