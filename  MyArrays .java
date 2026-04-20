import java.util.*;

class MyArrays  {

    public static int liearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int largetInArray(int arr[]) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }

        return max;
    }

    public static int binarySearch(int arr[], int key) {
        // Pre - requisite sorted array
        int st = 0;
        int ed = arr.length - 1;

        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }

        return -1;
    }

    public static void reverseArray(int arr[]) {
        int st = 0;
        int ed = arr.length - 1;

        while (st <= ed) {
            int temp = arr[st];
            arr[st] = arr[ed];
            arr[ed] = temp;
            st++;
            ed--;
        }
    }

    public static void printPairs(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print(arr[i] + "," + arr[j] + " ");
            }
            System.out.println();
        }
    }

    public static void printSubArrays(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int maxSubArraySum1(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];

                }
                if (maxSum < currSum) {
                    maxSum = currSum;
                }

                System.out.println();
            }
            System.out.println();
        }

        return maxSum;
    }

    public static int maxSubArraySum2(int arr[]){
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            prefix[i] = arr[i] + prefix[i-1];
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }

    public static int maxSubArraySum3(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0;i<arr.length;i++){
            currSum += arr[i];
            if(currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static int TrappingRainWater(int arr[]){
        int n = arr.length;

        int lMax[] = new int[n];
        lMax[0] = arr[0];

        for(int i=1;i<n;i++){
            lMax[i] = Math.max(lMax[i-1],arr[i]);
        }

        int rMax[] = new int[n];
        rMax[n-1] = arr[n-1];

        for(int i=n-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+1], arr[i]);
        }

        int mostWater = 0;

        for(int i=0;i<n;i++){
            int minBound = Math.min(lMax[i], rMax[i]);
            mostWater += minBound - arr[i];
        }

        return mostWater;
    }


    public static int buyAndSellStocks(int arr[]){
        int buyStock = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > buyStock){
              int profit = arr[i] - buyStock;
              maxProfit = Math.max(maxProfit, profit);
            }else{
                buyStock = arr[i];
            }
        }

        return maxProfit;

    }

    public static void reverseArray(int arr[],int st , int ed){

        while(st < ed){
            int temp = arr[st];
            arr[st] = arr[ed];
            arr[ed] = temp;
            st++;
            ed--;
        }
    }

    public static void nextPermutation(int arr[]){
        //find Pivot point(1,2,3)=> 2 is pivot point
        int n = arr.length;
        int pivot=-1;

        for(int i=n-1;i>0;i--){
            if(arr[i-1] < arr[i]){
                pivot = i-1;
                break;
            }
        }

        if(pivot == -1){
           reverseArray(arr,0,n-1);
           return;
        }else{
            for(int i=n-1;i>pivot;i--){
                if(arr[pivot] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[pivot];
                    arr[pivot] = temp;
                    break;
                }
                reverseArray(arr,pivot+1,n-1);
            }
        }



    }

    public static void main(String[] args) {
        int arr[] = { 1,3,2,0};
        nextPermutation(arr);
        for(int i : arr){
            System.out.print(i + ",");
        }

    }
}