package me.jie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jie on 8/23/16.
 */
public class Leet236 {
    /*
    recursive
     */
    public TreeNode lowestCommonancestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left  = lowestCommonancestor(root.left, p, q);
        TreeNode right = lowestCommonancestor(root.right, p, q);
        return (left != null && right != null) ? root: ((left != null) ? left : right);
    }
    /*
    iterative
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == q) return p;
        Map<TreeNode, TreeNode> mp = new HashMap<>();
        nodeAndAncester(root, root, mp);
        List<TreeNode> fatherp = new ArrayList<>();
        List<TreeNode> fatherq = new ArrayList<>();
        //TreeNode pp = p, qq = q;
        while(p != root){
            fatherp.add(p);
            p = mp.get(p);
        }
        fatherp.add(root);
        while(q != root){
            fatherq.add(q);
            q = mp.get(q);
        }
        fatherq.add(root);
        int len1 = fatherp.size(), len2 = fatherq.size();
        int i , j;
        if(len1 > len2){
            i = len1 - len2;
            j = 0;
        }else{
            i = 0;
            j = len2 - len1;
        }
        while(i < len1 && j < len2){
            if(fatherp.get(i) == fatherq.get(j)) return fatherp.get(i);
            i ++; j ++;
        }
        return null;
    }
    private void nodeAndAncester(TreeNode father, TreeNode child,  Map<TreeNode, TreeNode> mp){
        mp.put(child, father);
        if(child.left != null){
            nodeAndAncester(child, child.left, mp);
        }
        if(child.right != null){
            nodeAndAncester(child, child.right, mp);
        }
    }
}
