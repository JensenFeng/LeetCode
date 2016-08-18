package me.jie;

/**
 * Created by jie on 8/18/16.
 */
public class Leet167 {
    public int[] twoSum(int[] numbers, int target) {
        int ans1 = 0, ans2 = 0;
        for(int i = 0, j = numbers.length - 1; i < j;) {
            if (numbers[i] + numbers[j] == target) {
                ans1 = i + 1;
                ans2 = j + 1;
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{ans1, ans2};
    }
}
