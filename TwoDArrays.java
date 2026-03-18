public class TwoDArrays {

    public static int findLargestNumber(int arr[][]){
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] > maxValue){
                    maxValue = arr[i][j];
                }
            }
        }

        return maxValue;
    }

    public static void spiralMatix(int arr[][]){
        int rowStart = 0;
        int rowEnd = arr.length-1;
        int colStart = 0;
        int colEnd = arr[0].length-1;
        for(int row=rowStart;row<rowEnd;row++){
           System.out.print(arr[rowStart][row]+",");
        }

        for(int col=colStart+1;col<colEnd;col++){
            System.out.print(arr[col][rowEnd]+",");
        }

        for(int row=rowEnd-1;row>=rowStart;row--){
           System.out.print(arr[rowEnd][row]);
        }

        for(int col=colStart-1;colStart+1>col;col--){
             System.out.print(arr[col][rowStart]);
        }
    }

    public static void spiralMatrix(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = m - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // print - top
            for (int col = colStart; col <= colEnd; col++) {
                System.out.print(arr[rowStart][col] + ",");
            }

            // right
            for (int row = rowStart + 1; row <= rowEnd; row++) {
                System.out.print(arr[row][colEnd] + ",");
            }

            // botttom
            for (int col = colEnd - 1; col >= colStart; col--) {
                System.out.print(arr[rowEnd][col] + ",");
            }

            // //left
            for (int row = rowEnd - 1; row > rowStart; row--) {
                System.out.print(arr[row][rowStart] + ",");
            }

            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
    }

    public static void DaignoalSum(int arr[][]) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) {
                    maxSum += arr[i][j];
                } else if (i + j == arr.length - 1) {
                    maxSum += arr[i][j];
                }
            }
        }
        System.out.println(maxSum);
    }

    public static void DaignoalSum2(int arr[][]) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSum += arr[i][i] + arr[i][arr.length - 1 - i];
        }
        System.out.println(maxSum);
    }

    public static boolean searchInSortedMatrix(int arr[][] , int key){
         int n  = arr.length;
        int m= arr[0].length;
        int rowStart = 0;
        int colStart = m -1;
        while(rowStart < n && colStart < m && rowStart >= 0 && colStart >= 0){
            if(arr[rowStart][colStart] == key){
                return true;
            }
            if(arr[rowStart][colStart] < key){
                rowStart++;
            }else{
                 colStart--;
            }
        }
        
        return false;
    }

    public static void transedMatrix(int arr[][]){
      int n = arr.length;
      int m = arr[0].length;

      int transedMatrix[][] = new int[m][n];

      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            transedMatrix[j][i] = arr[i][j];
        }
      }

      for(int[] i : transedMatrix){
         for(int j : i){
            System.out.print(j + " ,");
         }
         System.err.println();
      }
    }

    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }};

       transedMatrix(arr);
    }

}
