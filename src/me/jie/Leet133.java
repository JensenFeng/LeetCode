package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/clone-graph/
 */
import java.util.*;
public class Leet133 {

    /**
     * Definition for undirected graph.
     */
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public class Solution {

        private Map<Integer, UndirectedGraphNode> mp = new HashMap<>();

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;

            if (mp.containsKey(node.label)) {
                return mp.get(node.label);
            } else {
                UndirectedGraphNode root = new UndirectedGraphNode(node.label);
                List<UndirectedGraphNode> neighbors = root.neighbors;

                mp.put(root.label, root);
                List<UndirectedGraphNode> lt = node.neighbors;
                for (UndirectedGraphNode nd : lt) {

                    neighbors.add(cloneGraph(nd));
                }

                return root;
            }
        }
    }
}