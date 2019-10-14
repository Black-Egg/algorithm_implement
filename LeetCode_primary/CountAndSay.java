import java.util.Scanner;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

 

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-and-say
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    // 方法一 递归。时间复杂度O(n)，空间复杂度O(n)
    public String countAndSay1(int n) {
        if(n == 1) return "1";
        String str = countAndSay(n - 1);
        System.out.println(str);
        StringBuffer sb = new StringBuffer();
        int count = 1;
        int i = 0;
        while(i < str.length()){
            while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
                i ++;
                count++;
            }
            
            sb.append(count);
            sb.append(str.charAt(i));
            count = 1;
            i++;
        }
        return sb.toString();
    }

    public String countAndSay2(int n) {
        if(n == 1) return "1";
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        for(int i = 2; i <= n; i++){
            String curStr = sb.toString();
            sb.delete(0, sb.length());
            int j = 0;
            int count = 1;
            while(j < curStr.length()){
                char curChar = curStr.charAt(j);
                while(j < curStr.length() - 1 && curChar == curStr.charAt(j + 1)){
                    j ++;
                    count++;
                }
                
                sb.append(count);
                sb.append(curChar);
                count = 1;
                j++;
            }
        }
        return sb.toString();
    }
}

public class CountAndSay{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.countAndSay(n));
    }
}