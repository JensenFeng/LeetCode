package me.jie;

/**
 * Created by jie on 8/23/16.
 */
public class Leet223 {
    /*
     写的太麻烦了
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        if(A > E || (A == E && B > F)) return computeArea(E, F, G, H, A, B, C, D);

        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if(B >= H || D <= F || C <= E ) return area;

        if(A < E && B < F && C > G && D > H) {
            area -= (G - E) * (H - F);
            return area;
        }
        int ar;
        if(C < G) {
            if(A < E) ar = C - E;
            else ar = C - A;
        }
        else {
            if(A < E) ar = G - E;
            else ar = G - A;
        }
        if(D > H){
            if(B > F) ar *= (H - B);
            else ar *= (H - F);
        }else{
            if(B < F) ar *= (D - F);
            else ar *= (D - B);
        }
        return area - ar;

    }
    /*
    https://discuss.leetcode.com/topic/15648/an-easy-to-understand-solution-in-java
     */
    public int computearea(int A, int B, int C, int D, int E, int F, int G, int H){
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if(A >= G || B >= H || D <= F || C <= E ) return area;
        int weight = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        return area - weight * height;
    }
    public static void main(String[] args){
        System.out.println(new Leet223().computeArea(-5,4,0,5,-3,-3,3,3));
    }
}
