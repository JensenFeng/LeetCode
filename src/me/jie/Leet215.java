package me.jie;

import java.util.*;

/**
 * Created by jie on 9/29/16.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * https://discuss.leetcode.com/topic/15256/4-c-solutions-using-partition-max-heap-priority_queue-and-multiset-respectively
 */
public class Leet215 {
    public static void main(String[] args){
        int[] n = {5,5,6,7,7,8};
        System.out.println(new Leet215().findKthLargest(n, 4));
    }


    //quicksort
    public int findKthLargest(int[] nums, int k){
        int left = 0, right = nums.length - 1;
        while(true){
            int pos = partition(nums, left, right);
            if(pos == k - 1) return nums[pos];
            if(pos > k - 1) right = pos - 1;
            else left = pos + 1;
        }
    }
    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left + 1, r = right;
        while(l <= r){
            if(nums[l] < pivot && nums[r] > pivot){
                swap(nums, l, r);
                l ++; r --;
            }
            if(nums[l] >= pivot) l ++;
            if(nums[r] <= pivot) r --;
        }
        swap(nums, left, r);
        return r;
    }
    private void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    /////////
    public int findKthLargest3(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i = 0; i < k; i ++){
            pq.add(nums[i]);
        }
        for(int i = k; i < nums.length; i ++){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }


    ////////klongn
    public int findKthLargest2(int[] nums, int k){
        if(nums.length == 0 || k <= 0) return 0;
        createHeap(nums, nums.length - 1);
        int size = nums.length - 1;
        for(int i = 0; i < k; i ++){
            int tmp = nums[size];
            nums[size] = nums[0];
            nums[0] = tmp;
            size --;
            adjustHeap(nums, 0, size);
        }
        return nums[size+1];
    }
    private void adjustHeap(int[] n, int start, int end){
        int tmp = n[start];
        for(int i = start * 2 + 1; i <= end; i = i * 2 + 1){
            if(i < end && n[i] < n[i + 1]){
                i ++;
            }
            if(tmp > n[i]) { break;}
            n[start] = n[i];
            start = i;
        }
        n[start] = tmp;
    }
    private void createHeap(int[] n, int len){
        for(int i = len / 2; i >= 0; i --){
            adjustHeap(n, i, len);
        }

    }

    ////////
    private int K;
    private int[] heap;
    private int pos = 0;
    public int findKthLargest1(int[] nums, int k){
        if(nums.length == 0 || k <= 0) return 0;
        this.K = k;
        heap = new int[K];
        for(int i = 0; i < k; i ++){
            createHeap(nums[i]);
        }
        for(int i = k; i < nums.length; i ++){
            insertHeap(nums[i]);
        }
        sortHeap();
        return heap[k-1];
    }

    /*
    minHeap: logk
     */
    private void createHeap(int n){
        int pos1 = pos;
        heap[pos] = n;
        while(pos1 > 0){
            int parent = (pos1 - 1) / 2;
            if(heap[pos1] < heap[parent]){
                int tmp = heap[pos1];
                heap[pos1] = heap[parent];
                heap[parent] = tmp;
            }
            pos1 = parent;
        }
        pos ++;
    }
    private void insertHeap(int n){
        if(n < heap[0]) return;
        heap[0] = n; // keep larger num
        adjustHeap(0, pos-1);
    }
    private void adjustHeap(int start, int end){
        int tmp = heap[start];
        for(int i = start * 2 + 1; i <= end; i *= 2){
            if(i < end && heap[i] > heap[i+1]){
                i ++;
            }
            if(tmp < heap[i]) {
                break;
            }
            heap[start] = heap[i];
            start = i;
        }
        heap[start] = tmp;
    }
    private void sortHeap(){
        for(int i = pos-1; i > 0; --i){
            int tmp = heap[i];
            heap[i] = heap[0];
            heap[0] = tmp;

            adjustHeap(0, i - 1);
        }
    }
}
