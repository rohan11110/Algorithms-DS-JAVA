import java.util.ArrayList;

public class ArrayListt {

    public static void printReverseList(ArrayList<Integer> list){
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+ " ");
        }
    }

    public static int findMaximum(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
           if(max < list.get(i)){
              max = list.get(i);
           }
        }

        return max;
    }

    public static void swapTwoNum(ArrayList<Integer> list,int idx1 , int idx2){
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    public static int containerWithMostWater(ArrayList<Integer> list){
        
        int maxWater = Integer.MIN_VALUE;
        int i = 0;
        int j = list.size()-1;

        while(i < j){
            int minBound = Math.min(list.get(i),list.get(j));
            int currWater = minBound * (j-i);
            maxWater = Math.max(currWater, maxWater);

            if(list.get(i) < list.get(j)){
                i++;
            }else{
                j--;
            }
        }

        return maxWater;

    }

    public static boolean pair2Sum(ArrayList<Integer> list,int target){
         int n = list.size();
        int pivot = -1;

        for(int i=1;i<list.size();i++){
            if(list.get(i-1) > list.get(i)){
                pivot = i;
                break;
            }
        }

        int lp = pivot;
        int rp = pivot-1;

        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }

            if(list.get(lp) + list.get(rp) < target){
               lp = (lp+1) % n;
            }else{
              rp = (n + rp -1) % n;
            }
        }

        return false;

    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

System.out.println(pair2Sum(list,19));

        
    }
}
