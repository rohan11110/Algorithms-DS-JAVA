import java.lang.reflect.Array;
import java.util.*;

public class GreedyAlgo {

    public static int maxActivitySelection(int start[], int end[], ArrayList<Integer> list) {
        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparing(o -> o[2]));

        int maxAttend = 1;
        list.add(activities[0][0]);
        int lastAttend = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (lastAttend < activities[i][1]) {
                maxAttend++;
                list.add(activities[i][0]);
                lastAttend = activities[i][2];
            }
        }

        return maxAttend;
    }

    public static int fractionalNapSack(int weights[], int value[], int totalWeight) {
        double ratio[][] = new double[weights.length][2];

        for (int i = 0; i < weights.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) value[i] / weights[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int remWeight = totalWeight;
        int totalValue = 0;

        for (int i = weights.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (remWeight >= weights[idx]) {
                remWeight -= weights[idx];
                totalValue += value[idx];
            } else {
                totalValue += remWeight * ratio[i][1];
                break;
            }

        }

        return totalValue;
    }

    public static int minAbsSum(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minAbs = 0;

        for (int i = 0; i < A.length; i++) {
            minAbs += Math.abs(A[i] - B[i]);
        }

        return minAbs;
    }

    public static int maxLengthOfChain(int arr[][]) {
        Arrays.sort(arr, Comparator.comparing(o -> o[1]));

        int chainLength = 1;
        int lastPickItem = arr[0][1];

        for (int i = 1; i < arr.length; i++) {

            if (lastPickItem < arr[i][0]) {
                lastPickItem = arr[i][1];
                chainLength++;
            }
        }

        return chainLength;

    }

    public static int indianCoinProblem(int value,int curr[]){

        int coinChange = 0;

        for(int i=curr.length-1;i>=0;i--){
            while(value >= curr[i]){
                value -= curr[i];
                coinChange++;
            }
        }

        return coinChange;

    }

    public static class Job {
        int idx;
        int profit;
        int time;

        public Job(int i,int p,int t){
            this.idx = i;
            this.profit = p;
            this.time = t;
        }
    }

    public static int jobSequence(int arr[][]){

        ArrayList<Job> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            list.add(new Job(i,arr[i][1],arr[i][0]));
        }

        Collections.sort(list, (a,b) -> b.profit - a.profit);

        int time = 0;

        for(int i=0;i<list.size();i++){
            Job curr = list.get(i);

            if(curr.time > time){
               time++;
            }
        }

        return time;

    }

    public static void main(String[] args) {
        int arr[][] = {{4,20},{1,10},{1,40},{1,30}};

        System.out.println(jobSequence(arr));

    }
}
