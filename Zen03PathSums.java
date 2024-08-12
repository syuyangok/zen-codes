import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.Node;

public class Zen03PathSums {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5,6,7};

        Node root = Zen02BuildBinaryTree.buildTree(arr, 0, arr.length-1);

        List<Integer> sums = new ArrayList<>();
        getPathSumsRecur(root, 0, sums);
        System.out.println(sums);

        System.out.println();
        List<Integer> sums2 = getPathSumsLoop(root);
        System.out.println(sums2);
    }

    public static void getPathSumsRecur(Node cur, int parentSum, List<Integer> sums){
        // Base case
        if (cur == null) return;   

        int currentSum = cur.val + parentSum;
        // If current node is a leaf, add result to sums
        if (cur.left == null && cur.right == null)  sums.add(currentSum);
        
        //If not, recursive call children
        getPathSumsRecur(cur.left, currentSum, sums);
        getPathSumsRecur(cur.right, currentSum, sums);
    }

    public static List<Integer> getPathSumsLoop(Node root){

        List<Integer> sums = new ArrayList<>();
        Queue<Integer> sumQ = new LinkedList<>();
        Queue<Node> nodeQ = new LinkedList<>();

        nodeQ.offer(root);
        sumQ.offer(0);

        while (!nodeQ.isEmpty()) {
            Node cur = nodeQ.poll();

            int sum = sumQ.poll() + cur.val;

            if(cur.left == null && cur.right == null) sums.add(sum);

            if (cur.left !=null) {
                sumQ.offer(sum);
                nodeQ.offer(cur.left);
            }
            if (cur.right !=null) {
                sumQ.offer(sum);
                nodeQ.offer(cur.right);
            }
            
        }


        return sums;
    }

}
