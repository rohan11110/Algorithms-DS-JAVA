public class BitManipulation {

    public static void checkOddOrEven(int n) {
        int bitMask = 1;

        if ((n & bitMask) == 0) {
            System.out.print("Even number");
        } else {
            System.out.print("Odd number");
        }
    }

    public static int getIthBit(int n, int i){
        int bitMask = i<<i;

        if((n & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setIthBit(int n , int i){
        int bitMask = 1<<i;

        return n | bitMask;
    }

    public static int clearIthBit(int n , int i){
        int bitMask = ~(1<<i);

        return n & bitMask;
    }

    public static int updateIthBit(int n , int i , int bitMask){
       
        //Approch-1
        //  if(bitMask == 0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }

        //Approch-2
        n = clearIthBit(n, i);
        int BitMask = bitMask<<i;

        return n | BitMask;
    }

    public static void main(String[] args) {
        System.out.print(updateIthBit(10,2,2));
    }
}
