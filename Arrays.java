import java.util.*;

class Arrays {

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

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 6, 8, 9 };
        System.out.println(maxSubArraySum3(arr));

    }
}