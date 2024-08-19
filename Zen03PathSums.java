import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

        System.out.println();
        List<Integer> sums3 = getPathSumsRecurFull(root);
        System.out.println(sums3);

        System.out.println();
        Map<Node, Integer> sums4 = getPathSumsMap(root);
        for(Map.Entry<Node, Integer> entry: sums4.entrySet()){
            System.out.println(entry.getKey().val + " : " + entry.getValue());
        }
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

    public static List<Integer> getPathSumsRecurFull(Node cur){
        List<Integer> sums = new ArrayList<>();
        if (cur == null) return sums;


        List<Integer> leftSum = getPathSumsRecurFull(cur.left);
        List<Integer> rightSum = getPathSumsRecurFull(cur.right);

        sums.addAll(leftSum);
        sums.addAll(rightSum);

        for (int i = 0; i < sums.size(); i++){
            sums.set(i, sums.get(i) + cur.val);
        }

        if (sums.isEmpty()) sums.add(cur.val);
        return sums;
    }

    public static List<Integer> getPathSumsLoop(Node root){

        List<Integer> ret = new ArrayList<>();
        Queue<Integer> sumQ = new LinkedList<>();
        Queue<Node> nodeQ = new LinkedList<>();

        nodeQ.offer(root);
        sumQ.offer(0);

        while (!nodeQ.isEmpty()) {
            Node cur = nodeQ.poll();

            int sum = sumQ.poll() + cur.val;

            if(cur.left == null && cur.right == null) ret.add(sum);

            if (cur.left !=null) {
                sumQ.offer(sum);
                nodeQ.offer(cur.left);
            }
            if (cur.right !=null) {
                sumQ.offer(sum);
                nodeQ.offer(cur.right);
            }
            
        }

        return ret;
    }

    // Different vs getPathSumsLoop,  in loop the cur value is not added to sum, need add to sum in the loop,
    // in this method, the sum with cur node is passed to the Queue, when cur node passed to the Queue
    // getPathSumsLoop sumQ is parent sum. This method is current sum (include current node value )
    public static Map<Node, Integer> getPathSumsMap(Node root){

        Map<Node, Integer> ret = new HashMap<>();
        Queue<Node> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        ret.put(root, root.val);

        while(!nodeQ.isEmpty()){
            Node curNode = nodeQ.poll();
            int curSum = ret.get(curNode);

            // If not leaf, remove curNode from ret map
            if (curNode.left != null || curNode.right != null) {
                ret.remove(curNode);
            }

            if (curNode.left != null) {
                nodeQ.offer(curNode.left);
                ret.put(curNode.left, curSum + curNode.left.val);
            }

            if (curNode.right != null) {
                nodeQ.offer(curNode.right);
                ret.put(curNode.right, curSum+ curNode.right.val);
            }

        }

        return ret;
    }



}
