import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.Node;



public class Zen04PathsBackTracking {

        public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5,6,7};

        Node root = Zen02BuildBinaryTree.buildTree(arr, 0, arr.length-1);

        System.out.println();
        List<List<Node>> result1 = new ArrayList<>();
        List<Node> path1 = new ArrayList<>();
        findPathsBackTracking(root, path1, result1);
        for(List<Node> nodes : result1){
            List<Integer> values = nodes.stream().map(node ->node.val).toList();
            System.out.println(values);
        }

        System.out.println();
        List<List<Node>> result11 = new ArrayList<>();
        List<Node> path11 = new ArrayList<>();
        findPathsBackTracking(root, path11, result11);
        for(List<Node> nodes : result11){
            List<Integer> values = nodes.stream().map(node ->node.val).toList();
            System.out.println(values);
        }

        System.out.println();
        List<List<Integer>> result3 = new ArrayList<>();
        Stack<Integer> path3 = new Stack<>();
        pathSumBackTracking(root, 7, 0, path3, result3);
        System.out.println(result3);
    }

// Find Paths,  find all paths from root to leaf, return all paths as nodes.

    public static List<List<Node>> findPathsBackTracking(Node root, List<Node> path, List<List<Node>> result){

        path.add(root);
        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }

        if (root.left !=null) {
            findPathsBackTracking(root.left, path, result);
        }
        if (root.right !=null) {
            findPathsBackTracking(root.right, path, result);
        }

        path.remove(path.size()-1);
        return result;
    }

    // Non backTracking version, each time, need create a instance of path
    public static List<List<Node>> findPathsBackRec(Node root, List<Node> path, List<List<Node>> result){

        if(root.left == null && root.right == null){
            result.add(path);
        }

        if (root.left !=null) {
            findPathsBackTracking(root.left, new ArrayList<>(path), result);
        }
        if (root.right !=null) {
            findPathsBackTracking(root.right, new ArrayList<>(path), result);
        }

        return result;
    }

// Path Sum II,  find a path from root to leaf that sums to target, return all paths.
//    Each path should be returned as a list of the node values, not node references

    // If use ArrayList to simulate a Stack, be carefull, list.remove(list.size()-1);
    public static List<List<Integer>> pathSumBackTracking(Node root, int targetSum, int parentSum, Stack<Integer> path, List<List<Integer>> result){

        int sum = parentSum + root.val;

        path.push(root.val);
        // If node is a leaf
        if (root.left == null && root.right == null && sum == targetSum){
            result.add(new ArrayList<>(path));
        }

        // Handle children
        if(root.left != null){
            pathSumBackTracking(root.left, targetSum, sum, path, result);
        }

        if (root.right != null){
            pathSumBackTracking(root.right, targetSum, sum, path, result);
        }

        path.pop();

        return result;

    }

}
