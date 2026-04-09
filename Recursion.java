public class Recursion {
    public static void decreasingOrder(int n){
        if(n == 0){
            System.out.println(n);
            return ;
        }

        System.out.println(n);
        decreasingOrder(n-1);
    }

    public static void increasingOrder(int n){
        if(n == 0){
            System.out.println(n);
            return ;
        }

        increasingOrder(n-1);
        System.out.println(n);
    }

    public static int factorialOfN(int n){
        if(n == 0){
        return 1;
        }

        return n * factorialOfN(n-1);
    }

    public static int sumOfNaturalNum(int n){
        if(n == 1){
            return 1;
        }

       return n + sumOfNaturalNum(n-1);
    }

    public static int fabbonaciNumber(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return fabbonaciNumber(n-1) + fabbonaciNumber(fabbonaciNumber( n -2));
    }

    public static boolean isSorted(int arr[],int i){
        if(arr.length - 1 == i){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }

       return isSorted(arr,i+1);

  
    }

    public static int firstOccurence(int arr[], int key ,int i){
        if(arr.length  == i){
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[],int key,int i){
        if(arr.length  == i){
            return -1;
        }

        int foundIdx =  lastOccurence(arr, key, i+1);

         if(foundIdx == -1 && key == arr[i]){
            return i;
         }

         return foundIdx;
        
    }

    public static int xPowerOfN(int x , int n){
        if(n == 0){
            return 1;
        }

        int num =  xPowerOfN(x , n/2);
        int square = num * num;

        if(n % 2 != 0){
            square = x * square;
        }

        return square;
    }

    public static int taillingProblem(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        return taillingProblem(n-1) + taillingProblem(n-2);
    }

    public static String removeDublicate(String str,String newStr,int i){
          if(str.length()-1 == i){
              return newStr + str.charAt(i);
          }

          if(str.charAt(i) == str.charAt(i+1)){
            return removeDublicate(str, newStr + str.charAt(i), i+2);
          }else {
            return removeDublicate(str, newStr + str.charAt(i), i+1);
          }
    }

    public static void main(String[] args) {
        int arr[] = {1,3,4,3,6,7};
      System.out.println(removeDublicate("rohhanviimmal","",0));
    }
}
