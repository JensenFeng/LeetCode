package me.jie;

/**
 * Created by jie on 7/19/16.
 */
import java.util.*;
public class Leet241 {
    public List<Integer> diffWaysToCompute(String input) {
        if(input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> rst = new ArrayList<>();
        List<String> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        //input -> nums, ops
        for(int i = 0; i < input.length(); i ++){
            if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                int j = i+1;
                while(j < input.length() && input.charAt(j) >= '0' && input.charAt(j) <= '9') j ++;
                nums.add(input.substring(i, j));
                i = j-1;
            }else{
                ops.add(input.charAt(i));
            }
        }
        Set<String> set = new HashSet<>();
        storage(set, nums, ops);
        compute(rst, set);
        return rst;
    }
    private void storage(Set<String> set, List<String> nums, List<Character> ops){
        if(ops.size() == 0 && nums.size() == 1){
            set.add(nums.get(0));
            return;
        }
        for(int i = 0; i < ops.size(); i ++){
            String n1 = nums.get(i);
            String n2 = nums.get(i + 1);
            char op = ops.get(i);
            String sum = "(" + n1 + op + n2 + ")";
            nums.remove(i);nums.remove(i);ops.remove(i);
            nums.add(i,sum);
            storage(set, nums, ops);
            nums.remove(i);
            nums.add(i, n1);nums.add(i+1, n2);ops.add(i, op);

        }
    }
    public void compute(List<Integer> rst, Set<String> set){
        Stack<String> stk;
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String str = it.next();
            stk = new Stack<>();
            int sum = 0;
            int n1 = 0, n2 = 0;
            char op;
            for(int i = 0; i < str.length(); i ++){
                if(str.charAt(i) == ')'){
                    n1 = n2 = 0;
                    sum = 0;
                    if (stk.size() > 3){
                        n2 = Integer.parseInt(stk.pop());
                        op = stk.pop().charAt(0);
                        n1 = Integer.parseInt(stk.pop());
                        switch(op){
                            case '+' : sum = n1 + n2;break;
                            case '-' : sum = n1 - n2;break;
                            case '*' : sum = n1 * n2;break;
                        }
                        stk.pop();
                        stk.push(sum+"");
                    }

                }else if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                    stk.push(str.charAt(i)+"");
                }else{
                    int j = i + 1;
                    while(j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') j ++;
                    stk.push(str.substring(i, j));
                    i = j-1;
                }
            }
            if(stk.size() == 1){
                rst.add(Integer.parseInt(stk.pop()));
            }
        }
    }

    public static void main(String[] args){
        List<Integer> rst = new Leet241().diffWaysToCompute("12");
        System.out.println(rst);
    }
}
