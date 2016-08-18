package me.jie;

/**
 * Created by jie on 8/18/16.
 */
public class Leet27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int pre = 0;
        for(int i = 0; i < len; i ++){
            if(nums[i] != val){
                nums[pre] = nums[i];
                pre ++;
            }
        }
        return pre;
    }
    public static void main(String[] args) {
        int[] n = {3, 3, 3, 4, 4, 5};
        int len = new Leet27().removeElement(n, 3);
        for(int i = 0; i < len; i ++){
            System.out.println(n[i]);
        }
    }
}
