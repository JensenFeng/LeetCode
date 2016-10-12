package me.jie;

/**
 * Created by jie on 9/22/16.
 * https://leetcode.com/problems/sliding-window-maximum/
 */
import java.util.*;
public class Leet239 {
    /*
    https://discuss.leetcode.com/topic/19055/java-o-n-solution-using-deque-with-explanation
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) {
            return new int[]{};
        }
        int[] ans = new int[nums.length - k + 1];
        int len = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i ++){
            while(!queue.isEmpty() && queue.peek() < i - k + 1){
                queue.poll();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1){
                ans[len++] = nums[queue.peek()];
            }
        }
        return ans;
    }
}
