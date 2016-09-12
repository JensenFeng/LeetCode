package me.jie;

/*
 * Created by jie on 7/26/16.
 */
import java.util.*;
public class Leet103 {
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
    public List<List<Integer>> zigzagLevelOrderTwo(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> level = new ArrayList<>();
        queue.add(root);
        TreeNode cur;
        int nowLevel = 1;
        int nextLevel = 0;
        while(!queue.isEmpty()){
            cur = queue.poll();
            nowLevel --;
            level.add(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
                nextLevel ++;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                nextLevel ++;
            }

            if(nowLevel == 0){
                rst.add(new ArrayList<>(level));
                level.clear();
                nowLevel = nextLevel;
                nextLevel = 0;
            }
        }
        for(int i = 1; i < rst.size(); i += 2){
            level = rst.get(i);
            for(int j = 0; j < level.size(); j ++){
                level.add(0, level.get(j));
                level.remove(j + 1);
            }
            rst.remove(i);
            rst.add(i, level);
        }
        return rst;
    }

    public List<List<Integer>> zigzagLevelOrderStack(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        Stack<TreeNode> cur  = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        List<Integer> level = new ArrayList<>();

        cur.push(root);
        level.add(root.val);
        rst.add(new ArrayList<>(level));level.clear();

        TreeNode node;
        boolean dire = false;

        while(!cur.isEmpty()){
            node = cur.pop();
            if(!dire) {
                if (node.right != null) {
                    next.push(node.right);
                    level.add(node.right.val);
                }
                if (node.left != null) {
                    next.push(node.left);
                    level.add(node.left.val);
                }
            }else{
                if (node.left != null) {
                    next.push(node.left);
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    next.push(node.right);
                    level.add(node.right.val);
                }
            }
            if(cur.isEmpty()){
                cur = next;
                next = new Stack<>();
                rst.add(new ArrayList<>(level));
                level.clear();
                dire = dire ? false : true;
            }
        }
        rst.remove(rst.size()-1);
        return rst;
    }

}
