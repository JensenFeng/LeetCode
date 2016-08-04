package me.jie;

/**
 * Created by jie on 7/27/16.
 */
import java.util.*;
public class Leet134 {
    //tle
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(cost.length == 0) return 0;
        else if(gas.length == 0) return -1;
        List<Integer> lt = new ArrayList<>();
        for(int i = 0; i < gas.length; i ++){
            if(gas[i] >= cost[i]){
                lt.add(i);
            }
        }
        int leftTank;
        int len = gas.length;
        int num = 0;
        for(int i = 0; i < lt.size(); i ++){
            leftTank = 0;
            num = lt.get(i);
            int j = (num + 1) % len;
            leftTank += gas[num] - cost[num];
            while(j != num){
                leftTank += gas[j] - cost[j];
                if(leftTank < 0) break;
                j = (j + 1) % len;
            }
            if(leftTank >= 0){
                return num;
            }
        }
        return -1;
    }

    //pass
    public int canCompleteCircuit2(int[] gas, int[] cost){
        if(cost.length == 0) return 0;
        else if(gas.length == 0) return -1;
        int index = 0;
        int leftTank = 0;
        int len = gas.length;
        for(int i = 0; i < gas.length; i ++){
            if(gas[i] >= cost[i]){
                index = i;
                leftTank = gas[i] - cost[i];
                int next = (index + 1) % len;
                while(next != index){
                    leftTank += gas[next] - cost[next];
                    if(leftTank < 0) {
                        break;
                    }
                    next = (next + 1) % len;
                }
                if(leftTank >= 0) return index;
                if(next < index) index ++;
                else index = next + 1;
                i = index - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] gas = {1,2,3,5};
        int[] cost = {2,1,5,3};
        System.out.println(new Leet134().canCompleteCircuit2(gas, cost));
    }
}
