import java.util.LinkedList;
import java.util.Queue;

import utils.Node;
public class Chan02BuildBinaryTree {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5,6,7};

        Node root = buildTree(arr, 0, arr.length-1);
        
        bfsPrint(root);
    }

    public static Node buildTree(int[] arr, int left, int right){

        if (left > right) return null;

        int middle = left + (right - left)/2;
        Node root = new Node(arr[middle]);

        root.left = buildTree(arr, left, middle-1);
        root.right = buildTree(arr, middle+1, right);

        return root;
    }

    public static void preOrderPrint(Node root){
        if (root == null) return;

        System.out.println(root.val);
        preOrderPrint(root.left);        
        preOrderPrint(root.right);
        
    }
    public static void bfsPrint(Node root){
        if (root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.val);

            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }          
        }        
    }
    
}
