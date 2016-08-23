package me.jie;

/**
 * Created by jie on 8/21/16.
 */
import java.util.*;

public class Leet228 {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<String> rst = new ArrayList<>();
        int pre = 0, pos = 0;
        for(int i = 1; i < nums.length; i ++){
            pos ++;
            if(nums[pos] != nums[pos - 1] + 1){
                if(nums[pos-1] == nums[pre]){
                    rst.add(nums[pre] + "");
                }else{
                    rst.add(nums[pre] + "->" + nums[pos-1]);
                }
                pre = pos;
            }
        }
        if(pre != pos){
            rst.add(nums[pre] + "->" + nums[pos]);
        }else{
            rst.add(nums[pre] + "");
        }
        return rst;
    }
}
