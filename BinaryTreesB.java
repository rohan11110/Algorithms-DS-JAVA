import java.util.*;
import java.util.LinkedList;
public class BinaryTreesB {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {

            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");

            inOrder(root.right);

        }

        public static void postOrder(Node root) {

            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");

        }

        public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");

                    if(currNode.left != null){
                        q.add(currNode.left);
                    }

                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int heightOfTree(Node root){
            if(root == null){
                return 0;
            }
          
            int left = heightOfTree(root.left);
            int right = heightOfTree(root.right);

            return Math.max(left, right)+1;

        }

        public static int countOfNode(Node root){
            if(root == null){
                return 0;
            }

              int left = countOfNode(root.left);
            int right = countOfNode(root.right);
   
            return left + right + 1;
        }

        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum + rightSum + root.data;
        }

        public static int daiMeter2(Node root){
            if(root == null){
                return 0;
            }

            int leftD = daiMeter2(root.left);
            int leftHeight = heightOfTree(root.left);

            int rightD = daiMeter2(root.right);
            int rightheight = heightOfTree(root.right);

            int selfDaimeter = leftHeight + rightheight + 1;

            return Math.max(selfDaimeter, Math.max(leftD, rightD));
        }

        static class Info {
            int dai;
            int ht;

            public Info(int d,int h){
                this.dai = d;
                this.ht = h;
            }
        }

        public static Info daiMeter(Node root){

            if(root == null){
                return new Info(0,0);
            }

            Info leftInfo = daiMeter(root.left);
            Info rightInfo = daiMeter(root.right);

            int selftDaiMeter = Math.max(leftInfo.ht + rightInfo.ht + 1 , Math.max(leftInfo.dai, rightInfo.dai));
            int selfHt = Math.max(leftInfo.ht, rightInfo.ht)+1;

            return new Info(selftDaiMeter,selfHt);

        }
    }

    public static boolean isIdentical(Node root , Node subRoot){
        if(root == null && subRoot == null){
            return true;
        }else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }

        if(!isIdentical(root.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(root.right, subRoot.right)){
            return false;
        }

        return true;


    }

    public static boolean isSubTree(Node root,Node subRoot){

        if(root == null){
            return false;
        }
        
        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        return isSubTree(root.left,subRoot) || isSubTree(root.right, subRoot);
    }

    static class Info {
        Node node;
        int hd;

        public Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topViewOfTree(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        q.add(new Info(root,0));
        q.add(null);

        int min = 0 , max = 0;

        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else {
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                  if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
                
            }
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void kLevelRecur(Node root,int level,int k){
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.data + " ");
            return;
        }

        kLevelRecur(root.left, level+1, k);
        kLevelRecur(root.right, level+1, k);
    }

    static class NodeInfo {

        Node node;
        int level;

        public NodeInfo(Node node,int level){
            this.node = node;
            this.level = level;
        }
        
    }

    public static void kLevelTreverse(Node root,int k){
        if(root == null){
            return;
        }

        Queue<NodeInfo> q = new LinkedList<>();

        q.add(new NodeInfo(root, 1));
        q.add(null);

      while(!q.isEmpty()){
        NodeInfo curr = q.remove();

        if(curr == null){
            if(q.isEmpty()){
                break;
            }else{
                q.add(null);
            }
        }else{

            if(curr.level == k){
                System.out.print(curr.node.data + " ");
            }

            if(curr.node.left != null){
                q.add(new NodeInfo(root.left, curr.level+1));
            }

            if(curr.node.right != null){
                q.add(new NodeInfo(root.right, curr.level+1));
            }
        }
      }
    }

    public static boolean getPath(Node root , int n,ArrayList<Node> list){

        if(root == null){
            return false;
        }
        
        list.add(root);
        if(root.data == n){
           return true;
        }

        boolean leftFound = getPath(root.left, n, list);
        boolean rightFound = getPath(root.right, n, list);

        if(leftFound || rightFound){
            return true;
        }

        list.remove(list.size()-1);
        return false;
    }

    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i-1);

        return lca;
    }

    public static Node lca2(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(leftLca == null){
            return rightLca;
        }

        if(rightLca == null){
            return leftLca;
        }

        return root;
    }

    public static int minDistFind(Node root,int n){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftFound = minDistFind(root.left, n);
        int rightFound = minDistFind(root.right, n);

        if(leftFound == -1 && rightFound == -1){
            return -1;
        }else if(leftFound == -1){
            return rightFound+1;
        }else{
            return leftFound+1;
        }
    }

    public static int minDist(Node root,int n1,int n2){
        Node lca = lca2(root, n1, n2);

        int dist1 = minDistFind(lca,n1);
        int dist2 = minDistFind(lca,n2);

        return dist1 + dist2;
    }

    public static int kthAncestor(Node root,int n , int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if(max+1 == k){
            System.out.println(root.data);
        }

        return max+1;
    }

    public static int transFormSumTree(Node root){
        if(root == null){
            return 0;
        }

        int leftData =  transFormSumTree(root.left);
        int rightData =  transFormSumTree(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data ;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftData +newRight  + rightData;
    
        return data;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(10);

       transFormSumTree(root);
       preOrder(root);
    }
}
