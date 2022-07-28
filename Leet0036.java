// https://leetcode.com/problems/valid-sudoku/
// Runtime: 40 ms, faster than 5.21% of Java online submissions for Valid Sudoku.
// Memory Usage: 50.6 MB, less than 5.33% of Java online submissions for Valid Sudoku.

// Notes, revisit this when I don't feel like writing the ultimate meme solution
import java.util.*;

public class Leet0036 {

    public static void main(String[] args) {

        char[][] input ={{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(input));
    }

    public static boolean isValidSudoku(char[][] board) {

        // Each row must contain the digits 1-9 without repetition.
        List<Character> rowOne =   new ArrayList<>(List.of(board[0][0], board[0][1], board[0][2], board[0][3], board[0][4], board[0][5], board[0][6], board[0][7], board[0][8]));
        rowOne.removeIf( name -> name.equals('.'));
        List<Character> rowTwo =   new ArrayList<>(List.of(board[1][0], board[1][1], board[1][2], board[1][3], board[1][4], board[1][5], board[1][6], board[1][7], board[1][8]));
        rowTwo.removeIf( name -> name.equals('.'));
        List<Character> rowThree = new ArrayList<>(List.of(board[2][0], board[2][1], board[2][2], board[2][3], board[2][4], board[2][5], board[2][6], board[2][7], board[2][8]));
        rowThree.removeIf( name -> name.equals('.'));
        List<Character> rowFour =  new ArrayList<>(List.of(board[3][0], board[3][1], board[3][2], board[3][3], board[3][4], board[3][5], board[3][6], board[3][7], board[3][8]));
        rowFour.removeIf( name -> name.equals('.'));
        List<Character> rowFive =  new ArrayList<>(List.of(board[4][0], board[4][1], board[4][2], board[4][3], board[4][4], board[4][5], board[4][6], board[4][7], board[4][8]));
        rowFive.removeIf( name -> name.equals('.'));
        List<Character> rowSix =   new ArrayList<>(List.of(board[5][0], board[5][1], board[5][2], board[5][3], board[5][4], board[5][5], board[5][6], board[5][7], board[5][8]));
        rowSix.removeIf( name -> name.equals('.'));
        List<Character> rowSeven = new ArrayList<>(List.of(board[6][0], board[6][1], board[6][2], board[6][3], board[6][4], board[6][5], board[6][6], board[6][7], board[6][8]));
        rowSeven.removeIf( name -> name.equals('.'));
        List<Character> rowEight = new ArrayList<>(List.of(board[7][0], board[7][1], board[7][2], board[7][3], board[7][4], board[7][5], board[7][6], board[7][7], board[7][8]));
        rowEight.removeIf( name -> name.equals('.'));
        List<Character> rowNine =  new ArrayList<>(List.of(board[8][0], board[8][1], board[8][2], board[8][3], board[8][4], board[8][5], board[8][6], board[8][7], board[8][8]));
        rowNine.removeIf( name -> name.equals('.'));

        // Each column must contain the digits 1-9 without repetition.
        List<Character> colOne =   new ArrayList<>(List.of(board[0][0], board[1][0], board[2][0], board[3][0], board[4][0], board[5][0], board[6][0], board[7][0], board[8][0]));
        colOne.removeIf( name -> name.equals('.'));
        List<Character> colTwo =   new ArrayList<>(List.of(board[0][1], board[1][1], board[2][1], board[3][1], board[4][1], board[5][1], board[6][1], board[7][1], board[8][1]));
        colTwo.removeIf( name -> name.equals('.'));
        List<Character> colThree = new ArrayList<>(List.of(board[0][2], board[1][2], board[2][2], board[3][2], board[4][2], board[5][2], board[6][2], board[7][2], board[8][2]));
        colThree.removeIf( name -> name.equals('.'));
        List<Character> colFour =  new ArrayList<>(List.of(board[0][3], board[1][3], board[2][3], board[3][3], board[4][3], board[5][3], board[6][3], board[7][3], board[8][3]));
        colFour.removeIf( name -> name.equals('.'));
        List<Character> colFive =  new ArrayList<>(List.of(board[0][4], board[1][4], board[2][4], board[3][4], board[4][4], board[5][4], board[6][4], board[7][4], board[8][4]));
        colFive.removeIf( name -> name.equals('.'));
        List<Character> colSix =   new ArrayList<>(List.of(board[0][5], board[1][5], board[2][5], board[3][5], board[4][5], board[5][5], board[6][5], board[7][5], board[8][5]));
        colSix.removeIf( name -> name.equals('.'));
        List<Character> colSeven = new ArrayList<>(List.of(board[0][6], board[1][6], board[2][6], board[3][6], board[4][6], board[5][6], board[6][6], board[7][6], board[8][6]));
        colSeven.removeIf( name -> name.equals('.'));
        List<Character> colEight = new ArrayList<>(List.of(board[0][7], board[1][7], board[2][7], board[3][7], board[4][7], board[5][7], board[6][7], board[7][7], board[8][7]));
        colEight.removeIf( name -> name.equals('.'));
        List<Character> colNine =  new ArrayList<>(List.of(board[0][8], board[1][8], board[2][8], board[3][8], board[4][8], board[5][8], board[6][8], board[7][8], board[8][8]));
        colNine.removeIf( name -> name.equals('.'));

        // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        List<Character> squareOne =   new ArrayList<>(List.of(board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]));
        squareOne.removeIf( name -> name.equals('.'));
        List<Character> squareTwo =   new ArrayList<>(List.of(board[0][3], board[0][4], board[0][5], board[1][3], board[1][4], board[1][5], board[2][3], board[2][4], board[2][5]));
        squareTwo.removeIf( name -> name.equals('.'));
        List<Character> squareThree = new ArrayList<>(List.of(board[0][6], board[0][7], board[0][8], board[1][6], board[1][7], board[1][8], board[2][6], board[2][7], board[2][8]));
        squareThree.removeIf( name -> name.equals('.'));
        List<Character> squareFour =  new ArrayList<>(List.of(board[3][0], board[3][1], board[3][2], board[4][0], board[4][1], board[4][2], board[5][0], board[5][1], board[5][2]));
        squareFour.removeIf( name -> name.equals('.'));
        List<Character> squareFive =  new ArrayList<>(List.of(board[3][3], board[3][4], board[3][5], board[4][3], board[4][4], board[4][5], board[5][3], board[5][4], board[5][5]));
        squareFive.removeIf( name -> name.equals('.'));
        List<Character> squareSix =   new ArrayList<>(List.of(board[3][6], board[3][7], board[3][8], board[4][6], board[4][7], board[4][8], board[5][6], board[5][7], board[5][8]));
        squareSix.removeIf( name -> name.equals('.'));
        List<Character> squareSeven = new ArrayList<>(List.of(board[6][0], board[6][1], board[6][2], board[7][0], board[7][1], board[7][2], board[8][0], board[8][1], board[8][2]));
        squareSeven.removeIf( name -> name.equals('.'));
        List<Character> squareEight = new ArrayList<>(List.of(board[6][3], board[6][4], board[6][5], board[7][3], board[7][4], board[7][5], board[8][3], board[8][4], board[8][5]));
        squareEight.removeIf( name -> name.equals('.'));
        List<Character> squareNine =  new ArrayList<>(List.of(board[6][6], board[6][7], board[6][8], board[7][6], board[7][7], board[7][8], board[8][6], board[8][7], board[8][8]));
        squareNine.removeIf( name -> name.equals('.'));

        Set<Character> rowOneSet = new HashSet<>(rowOne);
        if(rowOneSet.size() < rowOne.size()) return false;
        Set<Character> rowTwoSet = new HashSet<>(rowTwo);
        if(rowTwoSet.size() < rowTwo.size()) return false;
        Set<Character> rowThreeSet = new HashSet<>(rowThree);
        if(rowThreeSet.size() < rowThree.size()) return false;
        Set<Character> rowFourSet = new HashSet<>(rowFour);
        if(rowFourSet.size() < rowFour.size()) return false;
        Set<Character> rowFiveSet = new HashSet<>(rowFive);
        if(rowFiveSet.size() < rowFive.size()) return false;
        Set<Character> rowSixSet = new HashSet<>(rowSix);
        if(rowSixSet.size() < rowSix.size()) return false;
        Set<Character> rowSevenSet = new HashSet<>(rowSeven);
        if(rowSevenSet.size() < rowSeven.size()) return false;
        Set<Character> rowEightSet = new HashSet<>(rowEight);
        if(rowEightSet.size() < rowEight.size()) return false;
        Set<Character> rowNineSet = new HashSet<>(rowNine);
        if(rowNineSet.size() < rowNine.size()) return false;

        Set<Character> colOneSet = new HashSet<>(colOne);
        if(colOneSet.size() < colOne.size()) return false;
        Set<Character> colTwoSet = new HashSet<>(colTwo);
        if(colTwoSet.size() < colTwo.size()) return false;
        Set<Character> colThreeSet = new HashSet<>(colThree);
        if(colThreeSet.size() < colThree.size()) return false;
        Set<Character> colFourSet = new HashSet<>(colFour);
        if(colFourSet.size() < colFour.size()) return false;
        Set<Character> colFiveSet = new HashSet<>(colFive);
        if(colFiveSet.size() < colFive.size()) return false;
        Set<Character> colSixSet = new HashSet<>(colSix);
        if(colSixSet.size() < colSix.size()) return false;
        Set<Character> colSevenSet = new HashSet<>(colSeven);
        if(colSevenSet.size() < colSeven.size()) return false;
        Set<Character> colEightSet = new HashSet<>(colEight);
        if(colEightSet.size() < colEight.size()) return false;
        Set<Character> colNineSet = new HashSet<>(colNine);
        if(colNineSet.size() < colNine.size()) return false;

        Set<Character> squareOneSet = new HashSet<>(squareOne);
        if(squareOneSet.size() < squareOne.size()) return false;
        Set<Character> squareTwoSet = new HashSet<>(squareTwo);
        if(squareTwoSet.size() < squareTwo.size()) return false;
        Set<Character> squareThreeSet = new HashSet<>(squareThree);
        if(squareThreeSet.size() < squareThree.size()) return false;
        Set<Character> squareFourSet = new HashSet<>(squareFour);
        if(squareFourSet.size() < squareFour.size()) return false;
        Set<Character> squareFiveSet = new HashSet<>(squareFive);
        if(squareFiveSet.size() < squareFive.size()) return false;
        Set<Character> squareSixSet = new HashSet<>(squareSix);
        if(squareSixSet.size() < squareSix.size()) return false;
        Set<Character> squareSevenSet = new HashSet<>(squareSeven);
        if(squareSevenSet.size() < squareSeven.size()) return false;
        Set<Character> squareEightSet = new HashSet<>(squareEight);
        if(squareEightSet.size() < squareEight.size()) return false;
        Set<Character> squareNineSet = new HashSet<>(squareNine);
        if(squareNineSet.size() < squareNine.size()) return false;

        return true;
    }
}
