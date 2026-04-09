import java.util.Stack;

public class Queues {
    // --------------------Implementation thru
    // Array---------------------------------
    // public static class Queue {
    // static int arr[];
    // static int size;
    // static int rear;

    // Queue(int n){
    // arr = new int[n];
    // size = n;
    // rear = -1;
    // }

    // public static boolean isEmpty(){
    // return rear == -1;
    // }

    // public static void add(int data){
    // if(rear == size-1){
    // System.out.println("Queue is full");
    // return;
    // }
    // rear = rear + 1;
    // arr[rear] = data;
    // }

    // public static int remove(){
    // if(isEmpty()){
    // System.out.println("Queue is Empty");
    // }

    // int front = arr[0];
    // for(int i=0;i<rear;i++){
    // arr[i] = arr[i+1];
    // }
    // rear = rear -1;
    // return front;
    // }

    // public static int peek(){
    // if(isEmpty()){
    // System.out.println("Queue is Empty");
    // }
    // return arr[0];
    // }

    // }

    // --------------------Implementation thru Array for circular
    // queue---------------------------------
    // public static class Queue {
    // static int arr[];
    // static int size;
    // static int rear;
    // static int front;

    // Queue(int n){
    // arr = new int[n];
    // size = n;
    // rear = -1;
    // front = -1;
    // }

    // public static boolean isEmpty(){
    // return rear == -1 && front == -1;
    // }

    // public static boolean isFull(){
    // return (rear+1) % size == front;
    // }

    // public static void add(int data){
    // if(isFull()){
    // System.out.println("Queue is full");
    // return;
    // }
    // if(front == -1){
    // front = 0;
    // }
    // rear = (rear + 1)%size;
    // arr[rear] = data;
    // }

    // public static int remove(){
    // if(isEmpty()){
    // System.out.println("Queue is Empty");
    // }

    // int result = arr[front];

    // if(rear == front){
    // rear = front = -1;
    // }else{
    // front = (front + 1) % size;
    // }
    // return result;
    // }

    // public static int peek(){
    // if(isEmpty()){
    // System.out.println("Queue is Empty");
    // }
    // return arr[front];
    // }

    // }

    // --------------------Implementation thru LinkedList---------------------------------
    // public static class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // public static class Queue {
    //     static Node head = null;
    //     static Node tail = null;

    //     public static boolean isEmpty() {
    //         return head == null && tail == null;
    //     }

    //     public static void add(int data) {
    //         Node newNode = new Node(data);

    //         if (isEmpty()) {
    //             head = tail = newNode;
    //             return;
    //         }

    //         tail.next = newNode;
    //         tail = newNode;

    //     }

    //     public static int remove() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is Empty");
    //             return -1;
    //         }

    //         int front = head.data;
    //         if (head == tail) {
    //             head = tail = null;
    //         } else {
    //             head = head.next;
    //         }

    //         return front;
    //     }

    //     public static int peek() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is Empty");
    //             return -1;
    //         }

           
    //         return head.data;
    //     }

    // }

    // --------------------Implementation thru 2 - Stacks---------------------------------
    public static class Queue {
       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            if(isEmpty()){
                s1.push(data);
                return;
            }

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

           
            return s1.peek();
        }

    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
