/**
 * 获取字符串A和字符串B的所有最长公共子串，并按字典序输出
 * 
 * 
 */



import java.util.Scanner;

class Solution{
    public String[] getCommString(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        int max = 0;
        int times = 0;
        String[] res;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i=0; i < len1 + 1; i++){
            for(int j=0; j < len2 + 1; j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                    dp[i][j] = 0;
            }
        }

        for(int i=0; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        
        for(int i=0; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(dp[i][j] == max){
                    times ++;
                }
            }
        }

        res = new String[times];
        int idx = 0;
        for(int i=0; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(dp[i][j] == max){
                    res[idx] = a.substring(i-max, i);
                }
            }
        }
        return res;
    }
}



public class MaxCommStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        Solution sol = new Solution();
        String[] printStrngs = sol.getCommString(a, b);
        for(int i=0; i<printStrngs.length; i++){
            System.out.println(printStrngs[i]);
        }
            
    }
}