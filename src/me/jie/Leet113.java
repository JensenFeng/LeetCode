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
}
