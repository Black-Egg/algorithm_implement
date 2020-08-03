/**
 * 输入一个区间[A, B]与数字m。判断数字m（0 <= m <= 9）出现的次数。
 * 如：[29, 32] 3
 *  之间有29 30 31 32，3出现的次数为3。
 */

import java.util.Scanner;


class Solution{
    public int appearTimes(int m, int n, int x){
        int count = 0;
        char s = (char) (x + 48);
        StringBuffer sb = new StringBuffer();

        for(int i = m; i <= n; i++){
            sb.append(i);
        }
        String numString = sb.toString();
        
        for(int j = 0; j < numString.length(); j++){
            if(numString.charAt(j) == s){
                ++count;
            }
        }

        return count;
    }
}
public class AppearTimesInInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int X = sc.nextInt();
 
        Solution sol = new Solution();
        System.out.println(sol.appearTimes(M, N, X));
        sc.close();
    }
}