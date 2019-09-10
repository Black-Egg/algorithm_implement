//字符串转换


import java.util.Scanner;

class Solution{
    public int minOptNum(String sourceStr, String targetStr){
        int sourLen = sourceStr.length();
        int tarLen = targetStr.length();
        int [][] dp = new int[sourLen+1][tarLen+1];
        for(int i=0; i<=sourLen; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=tarLen; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=sourLen; i++){
            for(int j=1; j<=tarLen; j++){
                char sourChr = sourceStr.charAt(i-1);
                char tarChr = targetStr.charAt(j-1);
                int cross = (sourChr == tarChr ? 0 : 1);
                dp[i][j] = Math.min(dp[i-1][j-1] + cross, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
            }
        }
        return dp[sourLen][tarLen];
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sourceStr = sc.nextLine();
        String targetStr = sc.nextLine();
        Solution sol = new Solution();
        System.out.println(sol.minOptNum(sourceStr, targetStr));
    }
}