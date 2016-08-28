package me.jie;

/**
 * Created by jie on 8/28/16.
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Leet11 {
    /*
    https://leetcode.com/articles/container-most-water/
     */
    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        int rst = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int t = right - left;
            if(height[left] < height[right]){
                rst = Math.max(rst, t * height[left]);
                while(left + 1 < right && height[left + 1] <= height[left]) left ++;
                left ++;
            }else {
                rst = Math.max(rst, t * height[right]);
                while(right - 1 > left && height[right-1] <= height[right]) right --;
                right --;
            }
        }
        return rst;
    }
    public static void main(String[] args){
        int[] n = {5, 3, 4, 2, 3};
        System.out.println(new Leet11().maxArea(n));
    }
}
