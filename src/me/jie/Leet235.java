package me.jie;

/**
 * Created by jie on 8/23/16.
 */
import java.util.*;

public class Leet235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p ||
                (p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
            return root;
        if(p == q) return p;
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return null;
    }

    /*
    iterative
     */
    public TreeNode lowestCommonancestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == q) return q;
        TreeNode pos = root;
        TreeNode pp = p, qq = q;
        while(pp != pos && qq != pos && pos != null){
            if(p.val < pos.val && q.val < pos.val){
                pos = pos.left;
            }else if(p.val > pos.val && q.val > pos.val){
                pos = pos.right;
            }else{
                break;
            }
        }
        return pos;
    }
}

