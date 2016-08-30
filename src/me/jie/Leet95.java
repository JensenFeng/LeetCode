package me.jie;

/**
 * Created by jie on 8/8/16.
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
import javafx.util.Pair;

import java.util.*;
public class Leet95 {
    /*
       求(1, n), 遍历每个数,分别为根
       然后转成求  1 -> (2, n),  (1) <- 2 -> (3, n), ...
       保存中间结果 Map (i, j, root)
     */
    class Solution {
        Map<Pair<Integer, Integer>, List<TreeNode>> mp;
        List<TreeNode> rst;
        public List<TreeNode> generateTrees(int n) {
            if(n == 0) return new ArrayList<>();
            mp = new HashMap<>();
            rst = gTrees(1, n);
            return rst;

        }

        private List<TreeNode> gTrees(int begin, int end){
            Pair<Integer, Integer> p = new Pair<>(begin, end);
            if(mp.containsKey(p)){
                return mp.get(p);
            }
            else {
                List<TreeNode> lt;
                if (begin >= end) {
                    TreeNode node;
                    lt = new ArrayList<>();
                    if (begin > end) {
                        node = null;
                    } else {
                        node = new TreeNode(begin);
                        node.left = null;
                        node.right = null;
                    }
                    lt.add(node);
                    mp.put(p, lt);
                    return lt;
                }

                List<TreeNode> left, right;
                TreeNode root;
                Pair<Integer, Integer> pair1, pair2;
                lt = new ArrayList<>();
                for (int i = begin; i <= end; i++) {

                    pair1 = new Pair<>(begin, i - 1);
                    if (!mp.containsKey(pair1)) {
                        left = gTrees(begin, i - 1);
                        mp.put(pair1, left);
                    } else {
                        left = mp.get(pair1);
                    }
                    pair2 = new Pair<>(i + 1, end);
                    if (!mp.containsKey(pair2)) {
                        right = gTrees(i + 1, end);
                        mp.put(pair2, right);
                    } else {
                        right = mp.get(pair2);
                    }
                    for (TreeNode l : left) {
                        for (TreeNode r : right) {
                            root = new TreeNode(i);
                            root.left = l;
                            root.right = r;
                            lt.add(root);
                        }
                    }

                }
                mp.put(p, lt);
                return lt;
            }
        }
    }

    /*
        不保存中间结果, 小数据量
     */
    public class Solution2{
        public List<TreeNode> generateTrees(int n) {
            if(n == 0) return new ArrayList<>();
            List<TreeNode> rst = gTrees(1, n);
            return rst;
        }
        private List<TreeNode> gTrees(int begin, int end){
            List<TreeNode> lt = new ArrayList<>();
            if(begin > end){
                lt.add(null);
                return lt;
            }
            if(begin == end){
                lt.add(new TreeNode(begin));
                return lt;
            }
            for(int i = begin; i <= end; i ++){
                List<TreeNode> left = gTrees(begin, i - 1);
                List<TreeNode> right = gTrees(i + 1, end);
                for(TreeNode l : left){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        lt.add(root);
                    }
                }
            }
            return lt;
        }
    }
    Solution s1 = new Solution();
    Solution2 s2 = new Solution2();
    SolutionTwo t = new SolutionTwo();
    private void test(){
        int  n = 10;
//        long t = System.currentTimeMillis();
//        s1.generateTrees(n);
//        System.out.println(System.currentTimeMillis() - t);

        long t1 = System.currentTimeMillis();
        s2.generateTrees(n);
        System.out.println(System.currentTimeMillis() - t1);

        long tt = System.currentTimeMillis();
        List<TreeNode> rst = t.generateTrees(n);
        System.out.println(System.currentTimeMillis() - tt);
    }

    public class SolutionTwo{
        private Map<Pair<Integer, Integer>, List<TreeNode>> mp;
        public List<TreeNode> generateTrees(int n) {
            if(n == 0) return new ArrayList<>();
            mp = new HashMap<>();
            return generateTree(1, n);
        }
        private List<TreeNode> generateTree(int lo, int hi){
            List<TreeNode> lst = new ArrayList<>();
            if(lo > hi) {
                lst.add(null);
                return lst;
            }
            Pair<Integer, Integer> pair = new Pair<>(lo, hi);
            if(mp.containsKey(pair)){
                return mp.get(pair);
            }
            TreeNode root;
            for(int i = lo; i <= hi; i ++){
                List<TreeNode> left = generateTree(lo, i-1);
                List<TreeNode> right = generateTree(i + 1, hi);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        lst.add(root);
                    }
                }
            }
            mp.put(pair, lst);
            return lst;
        }
    }
    public static void main(String[] args){
        new Leet95().test();
    }
}
