package me.jie;

/**
 * Created by jie on 8/29/16.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Leet108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if(left > right) return null;
        if(left == right) {
            TreeNode root = new TreeNode(nums[left]);
            root.left = null;
            root.right = null;
            return root;
        }
        int mid = left + (right-left) / 2;
        TreeNode leftNode = sortedArrayToBST(nums, left, mid - 1);
        TreeNode rightNode = sortedArrayToBST(nums, mid + 1, right);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
