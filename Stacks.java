import java.util.*;

public class Stacks {

    // ------Using ArrayList--------
    // public class Stack {
    // ------Using ArrayList--------

    // static ArrayList<Integer> list = new ArrayList<>();

    // public static boolean isEmpty(){
    // return list.size() == 0;
    // }

    // public static void add(int val){
    // list.add(val);
    // }

    // public static int pop(){
    // if(isEmpty()) return -1;
    // int val = list.get(list.size() - 1);
    // list.remove(list.size() - 1);
    // return val;
    // }

    // public static int peek(){
    // if(isEmpty()) return -1;
    // return list.get(list.size() - 1);
    // }

    // }

    // ------Using LinkedList--------

    // static class Node {
    // int data;
    // Node next;

    // Node(int data) {
    // this.data = data;
    // this.next = null;
    // }
    // }

    // static class Stack {
    // static Node head = null;

    // public static boolean isEmpty() {
    // return head == null;
    // }

    // public static void push(int data) {
    // Node newNode = new Node(data);

    // if (head == null) {
    // head = newNode;
    // return;
    // }

    // newNode.next = head;
    // head = newNode;
    // }

    // public static int pop() {
    // if (isEmpty()) {
    // return -1;
    // }
    // int top = head.data;
    // head = head.next;
    // return top;
    // }

    // public static int peek() {
    // if (isEmpty()) {
    // return -1;
    // }
    // return head.data;
    // }
    // }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int val = s.pop();
        pushAtBottom(s, data);
        s.push(val);

    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        String newStr = "";
        while (!s.isEmpty()) {
            Character ch = s.pop();
            newStr += ch;
        }

        return newStr;
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpanProblem(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {

            while (!s.isEmpty() && stocks[s.peek()] < stocks[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();

            }
            s.push(i);

        }
    }

    public static void nextGreaterElement(int arr[], int greater[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                greater[i] = -1;
            } else {
                greater[i] = arr[s.peek()];
            }

            s.push(i);
        }
    }

    public static boolean validParanthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }

                if (s.peek() == '{' && ch == '}' || s.peek() == '[' && ch == ']' || s.peek() == '(' && ch == ')') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean dublicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while('(' != s.peek()) {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true;
                }else{
                    s.pop();
                }

                
            } else {
                s.push(ch);
            }
        }

        return false;

    }

    public static int maximumHistogram(int arr[]){
        Stack<Integer> s = new Stack<>();
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
  
        for(int i=0;i<arr.length;i++){

            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        s = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){

            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }

            s.push(i);
        }

     int max =0;
        for(int i=0;i<arr.length;i++){
           int area = arr[i] * (nsr[i] - nsl[i] - 1);
           max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();

        // s.add(1);
        // s.add(2);
        // s.add(3);
        // reverseStack(s);

        // while(!s.isEmpty()){
        // System.out.println(s.pop());
        // }

       int arr[]= {2,1,5,6,2,3};

        System.out.println(maximumHistogram(arr));
    }
}
