package me.jie;

/*
 * Created by jie on 7/26/16.
 */
import java.util.*;
public class Leet103 {
    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        //true: left -> right or false: right -> left;
        boolean direction = false;
        //use as a queue
        List<TreeNode> queue = new ArrayList<>();
        List<TreeNode> backqueue = new ArrayList<>();
        //medium result
        List<Integer> mrst = new ArrayList<>();
        queue.add(root);
        mrst.add(root.val);
        rst.add(new ArrayList<>(mrst));
        TreeNode currentNode;
        while(queue.size() > 0){
            mrst.clear();
            for(int i = 0; i < queue.size(); i ++) {
                currentNode = queue.get(i);
                if (direction) {
                    if (currentNode.left != null) {
                        backqueue.add(currentNode.left);
                        mrst.add(currentNode.left.val);
                    }
                    if (currentNode.right != null) {
                        backqueue.add(currentNode.right);
                        mrst.add(currentNode.right.val);
                    }
                } else {
                    if (currentNode.right != null) {
                        backqueue.add(currentNode.right);
                        mrst.add(currentNode.right.val);
                    }
                    if (currentNode.left != null) {
                        backqueue.add(currentNode.left);
                        mrst.add(currentNode.left.val);
                    }
                }
            }
            //reverse
            queue.clear();
            for(int j = backqueue.size()-1; j >= 0; j --){
                queue.add(backqueue.get(j));
            }
            backqueue.clear();
            direction = direction == false ? true : false;
            if(mrst.size() > 0) rst.add(new ArrayList<>(mrst));
        }
        return rst;
    }

    //better solution
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        travel(root, rst, 0);
        return rst;
    }
    private void travel(TreeNode node, List<List<Integer>> rst, int level){
        if(node == null) return;

        if(rst.size() <= level){
            List<Integer> current = new LinkedList<>();
            rst.add(current);
        }
        List<Integer> collection = rst.get(level);
        if(level % 2 == 0){
            collection.add(node.val);
        }else{
            collection.add(0, node.val);
        }
        travel(node.left, rst, level + 1);
        travel(node.right, rst, level + 1);
    }
}
