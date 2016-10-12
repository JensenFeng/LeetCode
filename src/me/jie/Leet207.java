package me.jie;

/**
 * Created by jie on 8/13/16.
 * https://leetcode.com/problems/course-schedule/
 */
import java.util.*;
public class Leet207 {
    class Edge{
        int[] next;
        int c1 , c2 ;
        Edge(int len){
            next = new int[len];
            c1 = 0;
            c2 = 0;
        }
        void setNext(int num){
            next[c2 ++] = num;
        }

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0) return true;
        /*
        1.先确定每个节点的入和出的num
        2.bfs遍历,如遇到入度不为0的点,说明存在环, return false;
         */
        List<Integer> visitedEdges = new ArrayList<>();
        int row = prerequisites.length;
        Edge[] edges = new Edge[numCourses];
        //init
        for(int i = 0; i < numCourses; i ++){
            edges[i] = new Edge(numCourses);
            visitedEdges.add(i);
        }
        //input
        for(int i = 0; i < row; i ++){
            int n1 = prerequisites[i][0];
            int n2 = prerequisites[i][1];
            edges[n1].c1 ++;
            edges[n2].setNext(n1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++){
            if(edges[i].c1 == 0) {
                if(edges[i].c2 != 0) {
                    queue.add(i);
                }
                visitedEdges.remove((Integer) i);
            }
        }
        while(!queue.isEmpty()){
            int n = queue.poll();
            int[] next = edges[n].next;
            for(int i = 0; i < edges[n].c2; i ++){
                edges[next[i]].c1 --;
            }
            int len = visitedEdges.size();
            List<Integer> tmp = new ArrayList<>(visitedEdges);
            for(int i = 0; i < len; i ++){
                int t = tmp.get(i);
                if(edges[t].c1 == 0){
                    visitedEdges.remove((Integer)t);
                    if(edges[t].c2 != 0){
                        queue.add(t);
                    }
                }

            }
        }
        return visitedEdges.size() == 0;
    }

    /*
      better solution
      https://discuss.leetcode.com/topic/13854/easy-bfs-topological-sort-java
     */
    public boolean canFinishbfs(int numCourses, int[][] prerequisites){
        if(numCourses == 0 || prerequisites.length == 0) return true;

        int[][] matrix = new int[numCourses][numCourses]; // pre -> next
        int[] indegree = new int[numCourses];
        //init
        for(int i = 0; i < prerequisites.length; i ++){
            int n1 = prerequisites[i][0];
            int n2 = prerequisites[i][1];
            if(matrix[n2][n1] == 0)
                indegree[n1] ++;
            matrix[n2][n1] = 1;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int n = queue.poll();
            count ++;
            for(int i = 0; i < numCourses; i ++){
                if(matrix[n][i] == 1){
                    if(-- indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public boolean bfs(int numCourses, int[][] prerequisites){
        int row = prerequisites.length;
        int[][] mark = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < row; i ++){
            int t1 = prerequisites[i][0];
            int t2 = prerequisites[i][1];
            if(mark[t2][t1] == 0){
                indegree[t1] ++;
            }
            mark[t2][t1] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int p = queue.poll();
            count ++;
            for(int i = 0; i < numCourses; i ++){
                if(mark[p][i] == 1){
                    if(--indegree[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
    public static void main(String[] args){
        int[][] pre = {{1,0},{2,0}};
        System.out.println(new Leet207().canFinishbfs(3, pre));
    }
}
