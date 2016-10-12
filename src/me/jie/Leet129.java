package me.jie;

/**
 * Created by jie on 9/18/16.
 */
public class Leet129 {
    private int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    private void dfs(TreeNode root, int cur){
        if(root.left == null && root.right == null){
            cur = cur * 10 + root.val;
            sum += cur;
            return;
        }
        cur = cur * 10 + root.val;
        if(root.left != null){
            dfs(root.left, cur);
        }
        if(root.right != null){
            dfs(root.right, cur);
        }
    }
}
