import java.util.ArrayList;
import java.util.List;

import utils.Node;

public class Zen03PathSums {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5,6,7};

        Node root = Zen02BuildBinaryTree.buildTree(arr, 0, arr.length-1);

        List<Integer> sums = new ArrayList<>();
        getPathSumsRecur(root, 0, sums);
        System.out.println(sums);
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

}
