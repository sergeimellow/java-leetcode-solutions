// https://leetcode.com/problems/search-a-2d-matrix/
// https://leetcode.com/submissions/detail/762863892/
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
// Memory Usage: 41.9 MB, less than 94.30% of Java online submissions for Search a 2D Matrix.

public class Leet0074 {

    public static void main(String[] args) {
//        int[][] a = {{1,3,5,7},
//                     {10,11,16,20},
//                     {23,30,34,60}};
//        int [][] a = {{1}, {1}};

//        int [][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int [][] a = {{1},{3}};
        int [][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};


        System.out.println(searchMatrix(a,5));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int leftPointer = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int currentMidRow;
        int currentMidCol;

        int rightPointer = (rows * cols) - 1;
        int midPointer;

        while (leftPointer <= rightPointer)
        {
            // line below can overflow 2^31, do midPointer = leftPointer + ((rightPointer - leftPointer) / 2) to avoid overflow
            midPointer = leftPointer + ((rightPointer - leftPointer) / 2);
            currentMidRow = (midPointer) / cols;
            currentMidCol = midPointer % cols;
            if (matrix[currentMidRow][currentMidCol] > target )
            {
                rightPointer = midPointer - 1;
            }
            else if (matrix[currentMidRow][currentMidCol] < target)
            {
                leftPointer = midPointer + 1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
