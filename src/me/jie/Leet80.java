package me.jie;

/**
 * Created by jie on 9/18/16.
 */
public class Leet80 {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        int i = 0 , j;
        while(i < nums.length){
            j = i + 1;
            while(j < nums.length && nums[j] == nums[i]) j ++;
            if(j - i >= 2) {
                nums[len++] = nums[i];
                nums[len++] = nums[i];
            } else {
                while(i < j){
                    nums[len++] = nums[i];
                    i ++;
                }
            }
            i = j;
        }
        return len;
    }
    public static void main(String[] args){
        int[] n = {1, 1, 1, 2, 2, 3, 3, 3};
        System.out.println(new Leet80().removeDuplicates(n));
    }
}
