import java.util.*;
public class BST {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root,int val){


        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
           root.left =  insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;

    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);


    }

    public static boolean searchInBST(Node root,int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
      
        if(root.data < key){
          return  searchInBST(root.right,key);
        }else{
          return  searchInBST(root.left,key);
        }

    }

    public static Node deleteNode(Node root,int val){

        if(root.data > val){
            root.left = deleteNode(root.left, val);
        }else if(root.data < val){
            root.right = deleteNode(root.right, val);
        }else{
            //case -1 leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //case -2 single child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //case -3 both child

            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);

        }

        return root;
    }

    public static Node inorderSuccessor(Node root){

        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public static void printInRange(Node root,int k1 , int k2){
        if(root == null){
            return;
        }

        if(k1 <= root.data && root.data <= k2){
                    printInRange(root.left, k1, k2);
                    System.out.println(root.data + " ");
                    printInRange(root.right, k1, k2);
        }else if( root.data < k1){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }
    }

    public static void printListData(ArrayList<Integer> list){
        for(int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void rootToLeaf(Node root,ArrayList<Integer> list){

        if(root == null){
            return;
        }
        
        list.add(root.data);
        if(root.left == null && root.right == null){
            printListData(list);
            return;
        }
        rootToLeaf(root.left,list);
        rootToLeaf(root.right, list);
        list.remove(list.size()-1);
    }

    public static boolean validateBST(Node root ,Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        if(max != null && root.data >= max.data){
            return false;
        }

        return validateBST(root.left, null, root) && validateBST(root.right, root, null);
    }

    public static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static Node mirrorBST(Node root){

        if(root == null) return null;

       Node left = mirrorBST(root.left);
       Node right = mirrorBST(root.right);
       root.right = left;
       root.left = right;


       return root;

    }

    public static Node createBST(int arr[],int st,int ed){
        if(st > ed) return null;

        int mid = st + (ed-st)/2;

        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, ed);

        return root;

    }
    public static void main(String[] args) {
        int val[] = {8,5,3,6,10,11,14};

        // Node root = null;

        // for(int i : val){
        //     root = insert(root, i);
        // }
       
        // inorder(root);

        Node root = createBST(val,0,val.length-1);
System.out.println();
        preOrder(root);
    
    }
}
