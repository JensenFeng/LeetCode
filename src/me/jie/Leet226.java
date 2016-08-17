package me.jie;

/**
 * Created by jie on 8/17/16.
 */
import java.util.*;
public class Leet226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode left = root.left, right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
    /*
    iterative
     */
    public TreeNode invertTreeIterative(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return root;
//        Stack<TreeNode> sk = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
        }
        return root;
    }
    public static void main(String[] args){
        int[] n = {1,2,3,4,5,6,7};
        TreeNode root = new TreeNode().create(n);
        root = new Leet226().invertTreeIterative(root);
        root.preOrder(root);
    }

}
