class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
        return;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
        return;
    }

    public static void printLinkedList() {
        if (head == null) {
            System.out.print("Linked List is Empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void add(int data, int idx) {
        Node newNode = new Node(data);

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        int currIdx = 0;
        while (idx - 1 > currIdx++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return;
    }

    public static int removeFirst() {
        if (size == 0) {
            System.out.print("Linked List is Empty");
            return -1;
        }

        if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }

        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public static int removeLast() {
        if (size == 0) {
            System.out.print("Linked List is Empty");
            return -1;
        }

        if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }

        Node temp = head;

        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        int value = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return value;
    }

    public static int iterativeSearch(int key) {
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == key) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }

        return -1;
    }

    public static int recursiveSearch(int key) {
        return helperRecursive(head, key);
    }

    public static int helperRecursive(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }

        int val = helperRecursive(head.next, key);

        if (val == -1) {
            return -1;
        } else {
            return val + 1;
        }
    }

    public static void reverseLinkedList() {
        if (head == null) {
            System.out.print("Linked List is empty");
            return;
        }

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static int removeNthNodeFromEnd(int idx) {
        if (size == 0) {
            System.out.print("Linked List is empty");
            return -1;
        }

        if (size == 1) {
            int value = head.data;
            head = tail = null;
            return value;
        }

        if (idx == size) {
            int value = head.data;
            head = head.next;
            size--;
            return value;
        }

        int target = size - idx;
        Node prev = head;

        for (int i = 1; i < target; i++) {
            prev = prev.next;
        }

        int value = prev.next.data;
        prev.next = prev.next.next;

        if (idx == 1) {
            tail = prev;
        }

        size--;
        return value;

    }

    public static Node findMidNode(Node head) {

        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // find mid node
        Node midNode = findMidNode(head);

        //reverse second half of linkedlist

        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        Node right = prev;
        Node left = head;

        //check palindrome

        while(right != null){
            if(left.data != right.data){
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean isCycle(){
        
        if(head == null || head.next == null){
            return false;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                isCycle = true;
                break;
            }

        }

        if(!isCycle){
           return;
        }

        Node prev = null;
             slow = head;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    public static void main(String[] args) {
        addFirst(1);
        addLast(3);
        add(5, 1);
        add(4, 2);
        add(2, 4);
        // tail.next = head.next.next;
        // System.out.println(isCycle());
        removeCycle();
        printLinkedList();
    }
}
