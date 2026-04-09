public class Backtracking {

    public static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ,");
        }
        System.out.println();
    }

    public static void arrayBackTrack(int arr[], int i, int val) {
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        arr[i] = val;
        arrayBackTrack(arr, i + 1, val + 1);
        arr[i] = val - 2;

    }

    public static void allSubSets(String str, int i, String newStr) {
        if (str.length() == i) {
            System.out.print(newStr + " ");
            return;
        }

        allSubSets(str, i + 1, newStr + str.charAt(i));
        allSubSets(str, i + 1, newStr);

    }

    public static void permutation(String str, String newStr) {
        if (str.length() == 0) {
            System.out.println(newStr);
            return;
        }

        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            String newString = str.substring(0, j) + str.substring(j + 1);
            permutation(newString, newStr + ch);
        }

    }

    public static boolean isSafe(char board[][], int row, int col) {
        // daignol left up
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // up
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // daignol right up
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    public static void printBoard(char board[][]) {
        int n = board.length;
        System.out.println("--------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nQueens(char board[][], int row) {

        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'x';
            }
        }

    }

    public static int gridWays(int i, int j, int n, int m) {

        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == n) {
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);

        return w1 + w2;

    }

    public static boolean isSafeSudoku(int sudoku[][],int row,int col,int digit){

        for(int i=0;i<9;i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        for(int j=0;j<9;j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        int sRow = (row/3) * 3;
        int sCol = (col/3) * 3;

        for(int i=sRow;i<sRow+3;i++){
            for(int j=sCol;j<sCol+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int sudoku[][],int row,int col){

        if(row == 9){
            printSudoku(sudoku);
            return true;
        }




        int nextRow = row , nextCol = col+1;
        if(col == 8){
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){
          return sudokuSolver(sudoku,nextRow,nextCol);
        }

        for(int digit = 1;digit<=9;digit++){
            if(isSafeSudoku(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int[][] sudoku) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            System.out.print(sudoku[i][j] + " ");
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        int[][] sudoku = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },

                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },

                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };


       System.out.println( sudokuSolver(sudoku, 0, 0));


    }
}
