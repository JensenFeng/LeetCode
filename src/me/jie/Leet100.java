package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args){
        int[] n1 = {1,2,3,4,5};
        int[] n2 = {5,3,2,1,4};
        TreeNode root1 = new TreeNode().create(n1);
        new TreeNode().inOrderPrint(root1);

    }
}
