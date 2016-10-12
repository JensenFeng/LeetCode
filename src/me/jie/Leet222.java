package me.jie;

import java.util.*;

/**
 * Created by jie on 9/27/16.
 */
public class Leet222 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        TreeNode cur = root;
        int lh = 0, rh = 0;
        //left height
        lh = getHeight(cur.left);
        //right height
        rh = getHeight(cur.right);
        while(cur != null){
            if(lh == rh){
                ans += 1 << lh;
                cur = cur.right;
                lh = rh - 1; //reuse left height
            }else{
                ans += 1 << rh;
                cur =  cur.left;
                lh = lh - 1;
            }
            if(cur != null) rh = getHeight(cur.right);
            else rh = 0;
        }
        return ans;
    }
    private int getHeight(TreeNode cur){
        int height = 0;
        while(cur != null){
            cur = cur.left;
            height ++;
        }
        return height;
    }
}
