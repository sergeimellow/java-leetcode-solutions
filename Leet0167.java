// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
// Runtime: 1 ms, faster than 99.22% of Java online submissions for Two Sum II - Input Array Is Sorted.
// Memory Usage: 50.6 MB, less than 10.33% of Java online submissions for Two Sum II - Input Array Is Sorted.

class Leet0167 {
    public static void main(String[] args) {
        int[] input = {-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        // System.out.println(input.length);
        int[] result = twoSum(input, -2);
        System.out.println("result: " + result[0] + ", " + result[1]);
    }
            

    static public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int iNumber;
        int jNumber;

        while (i < j) {
            iNumber = numbers[i];
            jNumber = numbers[j];

            if (iNumber + jNumber < target){
                i++;
                continue;
            }

            if (iNumber + jNumber == target) {
                break;
            }

            j--;
        }

        return new int[]{i+1, j+1};
    }
}