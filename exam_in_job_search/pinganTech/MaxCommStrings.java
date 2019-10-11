/**
 * 获取字符串A和字符串B的所有最长公共子串，并按字典序输出
 * 分析：动态规划求解。
 * 将字符串划分为子串，以字符串的每个字符作为格子的坐标轴。
 * 格子中的数值表示以字符A[i]结尾的A的子串A’ 和 以B[j]结尾的B的子串B’ 的 最大公共长度。若字符A[i] == B[j]，则dp[i][j] = dp[i-1][j-1] + 1。
 * A和B最长公共子串的长度为格子中的最大值，即max(dp[i][j]) （0 <= i <= lenA, 0 <= i <= lenB）。
 * 可将 最长公共子串存入 String数组，之后直接调用Arrays.sort(String[])即可自动获取按照字典序排序后的String 数组。
 * 
 */



import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public String[] getCommString(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        int max = 0;
        int times = 0;
        String[] res;
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化以 A的第0个字符结尾的子串A' 与 B的第0个字符结尾的子串B' 的最大公共长度为0
        for(int i=0; i < len1 + 1; i++){
            for(int j=0; j < len2 + 1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        // 动态规划过程。从A的第一个字符 与 B的第一个字符开始。
        for(int i=1; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                    dp[i][j] = 0;
            }
        }

        for(int i=1; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        
        for(int i=1; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(dp[i][j] == max){
                    times ++;
                }
            }
        }

        res = new String[times];
        int idx = 0;
        for(int i=1; i < len1 + 1; i++){
            for(int j=1; j < len2 + 1; j++){
                if(dp[i][j] == max){
                    res[idx] = a.substring(i-max, i);
                    idx++;
                }
            }
        }

        Arrays.sort(res);
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