package me.jie;

/**
 * Created by jie on 9/23/16.
 * https://leetcode.com/problems/minimum-height-trees/
 */
import java.util.*;

public class Leet310 {
    private List<Integer>[] mt;
    /*
    https://github.com/lydxlx1/LeetCode/blob/master/src/_310.java
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        mt = new List[n];
        for(int i = 0; i < n; i ++){
            mt[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i ++){
            int t1 = edges[i][0];
            int t2 = edges[i][1];
            mt[t1].add(t2);
            mt[t2].add(t1);
        }
        int start = 0;
        int[] dist = new int[n];
        int[] pre = new int[n];
        bfs(start, n, dist, pre);

        int u = 0;
        for(int i = 0; i < n; i ++){
            if(dist[i] > dist[u]) u = i;
        }
        dist = new int[n];
        bfs(u, n, dist, pre);
        u = 0;
        for(int i = 0; i < n; i ++){
            if(dist[i] > dist[u]) u = i;
        }
        List<Integer> rst = new ArrayList<>();
        while(u != -1){
            rst.add(u);
            u = pre[u];
        }
        if(rst.size() % 2 == 1) return Arrays.asList(rst.get(rst.size() / 2));
        return Arrays.asList(rst.get(rst.size()/2-1), rst.get(rst.size()/2));
    }
    private void bfs(int p, int n, int[] dist, int[] pre) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(p);
        boolean[] mark = new boolean[n];
        mark[p] = true;
        dist[p] = 0;
        pre[p] = -1;
        while(!queue.isEmpty()){
            int pp = queue.poll();
            for(int i : mt[pp]){
                if(!mark[i]){
                    queue.offer(i);
                    dist[i] = dist[pp] + 1;
                    mark[i] = true;
                    pre[i] = pp;
                }
            }
        }
    }

    /*
    https://discuss.leetcode.com/topic/30572/share-some-thoughts
     */
    public List<Integer> findMinHeightTreebfs(int n, int[][] edges){
        if(n <= 1) return Arrays.asList(0);
        List<Integer>[] mt = new List[n];
        for(int i = 0; i < n; i ++){
            mt[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for(int i = 0; i < edges.length; i ++){
            int t1 = edges[i][0];
            int t2 = edges[i][1];
            mt[t1].add(t2);
            mt[t2].add(t1);
            indegree[t1] ++;
            indegree[t2] ++;
        }
        List<Integer> leaf = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            if(indegree[i] == 1){
                leaf.add(i);
                indegree[i] = 0;
            }
        }
        while(n > 2){
            n -= leaf.size();
            List<Integer> leafs = new ArrayList<>();
            for(Integer i : leaf){
                int j = mt[i].iterator().next();
                mt[j].remove(i);
                if(--indegree[j] == 1) leafs.add(j);
            }
            leaf = leafs;
        }
        return leaf;
    }
    public static void main(String[] args){
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};int n = 6;
//        int[][] edges = {{0, 1}, {0, 2}};int n = 3;
        System.out.println(new Leet310().findMinHeightTreebfs(n, edges));
    }
}
