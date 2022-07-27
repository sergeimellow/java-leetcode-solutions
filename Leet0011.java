// https://leetcode.com/problems/container-with-most-water
// Runtime: 7 ms, faster than 18.86% of Java online submissions for Container With Most Water.
// Memory Usage: 81.5 MB, less than 19.57% of Java online submissions for Container With Most Water.

class Leet0011 {

	public static void main(String[] args) {
		int[] input = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(input));
	}

	static public int maxArea(int[] height) {
		int startIndex = 0;
		int endIndex = height.length - 1;
		int currentMaxArea = 0;
		int currentArea;
		int currentHeightMin;

		while (startIndex != endIndex) {
			currentHeightMin = Math.min(height[startIndex], height[endIndex]);
			currentArea = currentHeightMin * (endIndex - startIndex);
			if (currentArea > currentMaxArea)
			{
				currentMaxArea = currentArea;
			}
			if (height[startIndex] > height[endIndex] )
			{
				endIndex--;
			}
			else
			{
				startIndex++;
			}
		}

		return currentMaxArea;
	}
}