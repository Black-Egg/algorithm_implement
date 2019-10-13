/**
 * 爬楼梯问题。
 * 
 * 有n阶楼梯，每次可以上一阶或两阶，求有多少种爬楼梯的方法。
 * 思路：第n阶楼梯，可以由n-1或n-2步一步到达。
 * 若使用dp(n)表示爬到第n阶楼梯的方法，则dp(n) = dp(n-1) + dp(n-2)
 * 
 */


import java.util.Scanner;


class Solution{
    public int pathways(int N){
        if(N <= 2) return N;
        
        int pre = 1;
        int cur = 2;

        for(int i=2; i<N; i++){
            int next = cur + pre;
            pre = cur;
            cur = next;
        }

        return cur;
    }
}
public class Pathways {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
 
        Solution sol = new Solution();
        System.out.println(sol.pathways(m));
        sc.close();
    }
}