package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet75 {
    public void sortColors(int[] nums) {

        int[] count = new int[3];
        for(int i = 0; i < nums.length; i ++){
            count[nums[i]] ++;
        }
        int i = 0;
        for(int j = 0; j < 3; j ++){
            while(count[j] > 0) {
                nums[i ++] = j;
                count[j]--;
            }
        }
    }
    /*
    one pass:https://discuss.leetcode.com/topic/6968/four-different-solutions
     */
    public void sortColor(int[] nums){
        int left = 0, pos = 0, right = nums.length - 1;
        int tmp;
        while(left < right){
            if(nums[left] == 0){
                if(left != pos) {
                    tmp = nums[left];
                    nums[left] = nums[pos];
                    nums[pos++] = tmp;
                    continue;
                }
            }else if(nums[left] == 2){
                tmp = nums[right];
                nums[right --] = nums[left];
                nums[left] = tmp;
                continue;
            }
            left ++;
        }
    }
    public static void main(String[] args){
        int[] n = {0, 1, 2, 1, 2, 1, 2, 0};
        new Leet75().sortColor(n);
        for(Integer i : n){
            System.out.println(i);
        }
    }
}
