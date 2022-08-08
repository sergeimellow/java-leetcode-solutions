// https://leetcode.com/problems/detect-squares/
// https://leetcode.com/submissions/detail/761120641/
public class Leet2013 {
//    private Map<String, Integer> pointCountByXYPosition;
    private int maxRow = 0;
    private int maxCol = 0;
    private Integer[][] matrix;

    private static final String COUNT_COMMAND = "count";
    private static final String ADD_COMMAND = "add";
    private static final String DETECT_SQUARES_COMMAND = "DetectSquares";

    public Leet2013(String[] commands, int[][] commandInputs)
    {
        for (int i = 0; i < commands.length; i++) {
           if(commands[i].equals(ADD_COMMAND)) {
               maxRow = Math.max(maxRow, commandInputs[i][0]);
               maxCol = Math.max(maxCol, commandInputs[i][1]);
            }
        }
        // "0, 0" -> null means 0 points at index 0 of the matrix
        // "1, 3' -> 2 means in the second row and the 4th columns there are 2 points
        matrix = new Integer[maxRow+1][maxCol+1];
        //matrix = new Integer[1001][1001];

        Integer[] output = new Integer[commands.length];

        for (int i = 0; i < commands.length; i++) {

            if (commands[i].equals(COUNT_COMMAND)) {
                output[i] = count(commandInputs[i]);
            }
            else if(commands[i].equals(ADD_COMMAND)) {
                add(commandInputs[i]);
                output[i] = null;
            }
            else if(commands[i].equals(DETECT_SQUARES_COMMAND)) {
                output[i] = null;
            }
        }
    }

    public void add(int[] point) {
        if (matrix[point[0]][point[1]] == null) {
            matrix[point[0]][point[1]] = 1;
        }
        else {
            matrix[point[0]][point[1]] = matrix[point[0]][point[1]] + 1;
        }
    }

    // starts the detected amount of squares  this point can form
    public int count(int[] point) {
        int currentSquareCount = 0;
        int currentPointCount = 1;
        int startRow = point[0];
        int startCol = point[1];
        int curRow = point[0];
        int curCol = point[1];



        while (curRow != 0 && curCol != 0 )
        {
            curRow--;
            curCol--;
            if (matrix[curRow][curCol] != null && matrix[startRow][curCol] != null && matrix[curRow][startCol] != null) {
                currentSquareCount = currentSquareCount + (currentPointCount * matrix[curRow][curCol] * matrix[startRow][curCol] * matrix[curRow][startCol]);
            }
        }

        curRow = point[0];
        curCol = point[1];
        while (curRow != 1000 && curCol != 1000 )
        {
            curRow++;
            curCol++;
            if (matrix[curRow][curCol] != null && matrix[startRow][curCol] != null && matrix[curRow][startCol] != null) {
                currentSquareCount = currentSquareCount + (currentPointCount * matrix[curRow][curCol] * matrix[startRow][curCol] * matrix[curRow][startCol]);
            }
        }

        curRow = point[0];
        curCol = point[1];
        while (curRow != 0 && curCol != 1000 )
        {
            curRow--;
            curCol++;
            if (matrix[curRow][curCol] != null && matrix[startRow][curCol] != null && matrix[curRow][startCol] != null) {
                currentSquareCount = currentSquareCount + (currentPointCount * matrix[curRow][curCol] * matrix[startRow][curCol] * matrix[curRow][startCol]);
            }
        }

        curRow = point[0];
        curCol = point[1];
        while (curRow != 1000 && curCol != 0 )
        {
            curRow++;
            curCol--;
            if (matrix[curRow][curCol] != null && matrix[startRow][curCol] != null && matrix[curRow][startCol] != null) {
                currentSquareCount = currentSquareCount + (currentPointCount * matrix[curRow][curCol] * matrix[startRow][curCol] * matrix[curRow][startCol]);
            }
        }

        return currentSquareCount;
    }
}
