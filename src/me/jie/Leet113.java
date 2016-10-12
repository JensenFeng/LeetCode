package me.jie;

/**
 * Created by jie on 8/8/16.
 * https://leetcode.com/problems/path-sum-ii/
 */
import java.util.*;
public class Leet113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        pathLeaf(root, sum, rst, new ArrayList<>());
        return rst;
    }
    private void pathLeaf(TreeNode root, int sum, List<List<Integer>> rst, List<Integer> lt){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == sum) {
                List<Integer> tmp = new ArrayList<>(lt);
                tmp.add(root.val);
                rst.add(tmp);
            }
            return;
        }
        lt.add(root.val);
        pathLeaf(root.left, sum - root.val, rst, lt);
        pathLeaf(root.right, sum - root.val, rst, lt);
        lt.remove(lt.size()-1);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        dfs(rst, cur, root, sum - root.val);
        return rst;
    }
    private void dfs(List<List<Integer>> rst, List<Integer> cur, TreeNode root, int sum){
        if(root.left == null && root.right == null && sum == 0){
            rst.add(new ArrayList<>(cur));
            return;
        }
        if(root.left != null) {
            cur.add(root.left.val);
            dfs(rst, cur, root.left, sum - root.left.val);
            cur.remove(cur.size() - 1);
        }
        if(root.right != null) {
            cur.add(root.right.val);
            dfs(rst, cur, root.right, sum - root.right.val);
            cur.remove(cur.size() - 1);
        }
    }
}
