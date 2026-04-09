public class DivideAndConquer {

    public static void merge(int arr[], int si, int mid, int ed) {
        int temp[] = new int[ed - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ed) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ed) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void mergeSort(int arr[], int si, int ed) {
        if (si >= ed) {
            return;
        }

        int mid = si + (ed - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ed);
        merge(arr, si, mid, ed);
    }

    public static void quickSort(int arr[], int si, int ed) {
        if (si >= ed) {
            return;
        }

        int pIdx = partition(arr, si, ed);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ed);
    }

    public static int partition(int arr[], int si, int ed) {
        int pivot = arr[ed];
        int i = si - 1;

        for (int j = si; j <= ed; j++) {
            if (arr[j] < pivot) {
                i++;
 
                arr[j] = arr[i] + arr[j] - (arr[i] = arr[j]);
                // int temp = arr[j];
                // arr[j] = arr[i];
                // arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ed] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static int searchInRotatedArray(int arr[],int si,int ed,int target){
        if(si > ed){
            return -1;
        }
        int mid = si + (ed - si)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[si] <= arr[mid]){
            if(arr[si] <= target && target <= arr[mid]){
               return searchInRotatedArray(arr,si,mid-1,target);
            }else{
               return searchInRotatedArray(arr,mid+1,ed,target);
            }
        }else{

             if(arr[mid] <= target && target <= arr[ed]){
               return searchInRotatedArray(arr,mid+1,ed,target);
            }else{
               return searchInRotatedArray(arr,si,mid-1,target);
            }

        }
    }
    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 0, 10 };

       System.out.println( searchInRotatedArray(arr, 0, arr.length - 1,0));

       
    }

}
