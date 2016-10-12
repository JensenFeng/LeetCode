package me.jie;

/**
 * Created by jie on 10/1/16.
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
import java.util.*;
public class Leet347 {
    public static void main(String[] args){
        int[] n = {1, 1, 1, 2, 2, 2, 3};
        List<Integer> lt = new Leet347().topKFrequent(n, 1);
        lt.forEach(i -> System.out.println(i));
    }
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i], 1);
            }else{
                mp.put(nums[i], mp.get(nums[i]) + 1);
            }
        }
        PriorityQueue<entry> pq = new PriorityQueue<>(
                new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        entry e1 = (entry)o1;
                        entry e2 = (entry)o2;
                        return e1.value < e2.value ? 1 : -1;
                    }
                }
        );
        for(Map.Entry e : mp.entrySet()){
            pq.add(new entry((int)e.getKey(), (int)e.getValue()));
        }
        List<Integer> lt = new ArrayList<>();
        for(int i = 0; i < k; i ++){
            lt.add(pq.poll().key);
        }
        return lt;
    }
    private class entry{
        int key;
        int value;
        entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /*
    https://discuss.leetcode.com/topic/44237/java-o-n-solution-bucket-sort
     */
    public List<Integer> topKFrequent(int[] nums, int k){
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        for(int i : mp.keySet()){
            int frequency = mp.get(i);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(i);
        }
        List<Integer> rst = new ArrayList<>();
        for(int i = nums.length; i >= 0; i --){
            if(bucket[i] != null){
                for(int b : bucket[i]){
                    if(k > 0) {
                        rst.add(b);
                        k --;
                    }
                }
            }
        }
        return rst;
    }
}
