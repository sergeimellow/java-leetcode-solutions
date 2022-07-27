// https://leetcode.com/problems/trapping-rain-water
// Runtime: 1 ms, faster than 99.56% of Java online submissions for Trapping Rain Water.
// Memory Usage: 48.4 MB, less than 64.28% of Java online submissions for Trapping Rain Water.

class Leet0042 {

	public static void main(String[] args) {
		int[] input = {9,6,8,8,5,6,3};
		System.out.println(trap(input));
	}

	static public int trap(int[] height) {
		int leftIndex = 0;
		int leftMax = height[leftIndex];
		int rightIndex = height.length - 1;
		int rightMax = height[rightIndex];
		int totalWater = 0;
		int currentWater;

		while (leftIndex != rightIndex)
		{
			if (rightMax > leftMax)
			{
				leftIndex++;
				currentWater = leftMax - height[leftIndex];
				if (leftMax < height[leftIndex])
				{
					leftMax = height[leftIndex];
				}
			}
			else 
			{
				rightIndex--;
				// System.out.println(rightMax);
				currentWater = rightMax - height[rightIndex];
				if (rightMax < height[rightIndex])
				{
					rightMax = height[rightIndex];
				}

			}
			if (currentWater > 0)
			{
				totalWater += currentWater;
			}
		}

		return totalWater;
	}
}