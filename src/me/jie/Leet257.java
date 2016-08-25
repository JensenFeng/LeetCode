package me.jie;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/binary-tree-paths/
 */
import java.util.*;

public class Leet257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) {
            List<String> rst = new ArrayList<>();
            rst.add(root.val+"");
            return rst;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> rst = new ArrayList<>();
        for(String s: left){
            rst.add(root.val + "->" + s);
        }
        for(String s: right){
            rst.add(root.val + "->" + s);
        }
        return rst;
    }

}
