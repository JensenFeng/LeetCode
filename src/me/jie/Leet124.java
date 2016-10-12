package me.jie;

/**
 * Created by jie on 8/3/16.
 */
public class Leet124 {
    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
    class TreeNodePath{
        TreeNode node;
        int oneChildValue;
        int twochildValue;
        TreeNodePath(TreeNode node, int value1, int value2){
            this.node = node;
            oneChildValue = value1;
            twochildValue = value2;
        }
    }
    private int ans = Integer.MIN_VALUE+100;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        TreeNodePath proot = getMaxPath(new TreeNodePath(root, Integer.MIN_VALUE+100, Integer.MIN_VALUE+100));
        return Math.max(ans, Math.max(proot.oneChildValue, proot.twochildValue));
    }
    private TreeNodePath getMaxPath(TreeNodePath root){
        TreeNode node = root.node;
        if(node.left == null && node.right == null){
            root.oneChildValue = node.val;
            root.twochildValue = node.val;
            ans = Math.max(ans, node.val);
            return root;
        }
        TreeNodePath pnodel = null;
        TreeNodePath pnoder = null;
        if(node.left != null){
            pnodel = getMaxPath(new TreeNodePath(node.left, Integer.MIN_VALUE+100, Integer.MIN_VALUE+100));
            root.oneChildValue = Math.max(root.oneChildValue,
                    Math.max(node.val + pnodel.oneChildValue,
                            node.val));
            ans = Math.max(ans, root.oneChildValue);
        }
        if(node.right != null){
            pnoder = getMaxPath(new TreeNodePath(node.right, Integer.MIN_VALUE+100, Integer.MIN_VALUE+100));
            root.oneChildValue = Math.max(root.oneChildValue,
                    Math.max(node.val + pnoder.oneChildValue,
                            node.val));
            ans = Math.max(ans, root.oneChildValue);
        }
        if(pnodel != null && pnoder != null){
            root.twochildValue = Math.max(node.val + pnodel.oneChildValue + pnoder.oneChildValue, node.val);
                            //Math.max(node.val, Math.max(pnodel.twochildValue, pnoder.twochildValue)));
            ans = Math.max(ans, root.twochildValue);
        }
        return root;
    }

    //more better way
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root){
        if(root == null) return 0;

        maxSum = Math.max(maxSum, getMax(root));
        return maxSum;
    }
    private int getMax(TreeNode root){
        if(root == null) return 0;
        int left  = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    private int ansSum = Integer.MIN_VALUE;
    public int maxPathsum(TreeNode root){
        if(root == null) return 0;
        helper(root);
        return ansSum;
    }
    private int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int curSum = Math.max(left, right) + node.val;
        ansSum = Math.max(ansSum, node.val);
        if(left > 0 && right > 0) {
            ansSum = Math.max(ansSum, left + right + node.val);
        }
        ansSum = Math.max(ansSum, curSum);
        return Math.max(curSum, node.val);
    }
}
