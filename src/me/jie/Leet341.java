package me.jie;

/**
 * Created by jie on 8/8/16.
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
import java.util.*;
public class Leet341 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     */
    public interface NestedInteger {

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> list;
        int len;
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            getList(list, nestedList);
            len = 0;
        }

        private void getList(List<Integer> lst, List<NestedInteger> nestList){
            if(nestList == null) return;
            for(NestedInteger nestedInteger : nestList){
                if(nestedInteger.isInteger()){
                    lst.add(nestedInteger.getInteger());
                }else{
                    getList(lst, nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(len);
        }

        @Override
        public boolean hasNext() {
            return len < list.size();
        }
    }


    /**
     *  better idea:
     *  https://discuss.leetcode.com/topic/42042/simple-java-solution-using-a-stack-with-explanation
     */
    public class NestedIterator2 implements Iterator<Integer>{

        private Stack<NestedInteger> stack;
        public NestedIterator2(List<NestedInteger> nestedList){
            stack = new Stack<>();
            for(int i = nestedList.size() - 1; i >= 0; i --){
                stack.push(nestedList.get(i));
            }
        }
        @Override
        public Integer next(){
            return stack.pop().getInteger();
        }
        @Override
        public boolean hasNext(){
            while(!stack.empty()){
                NestedInteger ni = stack.peek();
                if(ni.getInteger() != null){
                    return true;
                }
                stack.pop();
                for(int i = ni.getList().size()-1; i >= 0; i --){
                    stack.push(ni.getList().get(i));
                }
            }
            return false;
        }
    }
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
