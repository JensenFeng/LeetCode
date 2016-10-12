package me.jie;

/**
 * Created by jie on 9/21/16.
 */
import java.util.*;
public class Leet173 {
    private class BSTIterator {
        private Stack<TreeNode> stk;
        public BSTIterator(TreeNode root) {
            stk = new Stack<>();
            pushAll(root);
        }
        private void pushAll(TreeNode node){
            while(node != null){
                stk.push(node);
                node = node.left;
            }
        }
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stk.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur = stk.pop();
            pushAll(cur.right);
            return cur.val;
        }
    }
    public void test() {
        /**
         * Your BSTIterator will be called like this:
         * */
        int[] n = {2, 1, 3};
        TreeNode root = new TreeNode().create(n);
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public static void main(String[] args){
        new Leet173().test();
    }
}
