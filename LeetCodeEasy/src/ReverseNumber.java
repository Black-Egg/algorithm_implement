/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321

 示例 2:

输入: -123
输出: -321

示例 3:

输入: 120
输出: 21

注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class Solution {

    // 方法一：将数字转换成char[]数组，再进行反转操作.
    // 然后转换成long型，进行判断后输出。
    // 时间复杂度O(lg(x)),空间复杂度O(lg(x))。

    public int reverse1(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int len = s.length;
        int left = 0;
        int right = len - 1;
        
        if(s[left] == '-')
            left++;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        long res = Long.parseLong(String.valueOf(s));
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        else
            return (int)res;
    }


    // 方法二：将数字转换成char[]数组，再进行反转操作。
    // 然后转换成int型，用try{..} catch{..}进行判断后。
    // 时间复杂度O(lg(x)),空间复杂度O(lg(x))。
    public int reverse2(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int len = s.length;
        int left = 0;
        int right = len - 1;
        
        if(s[left] == '-')
            left++;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        int res;
        try{ 
            res = Integer.parseInt(String.valueOf(s));
        }
        catch(Exception e){
            res = 0;
        }
        return res;
    }

    // 方法三： 弹出和推入数字 & 溢出前进行检查。
    // 本质上需要进行：重复弹出（pop）x的最后一位，并推入（push）到rev（保存反转后的结果）的首位。
    // 在没有辅助堆栈/数组的情况下，可使用数学方法
    //pop operation:
    // pop = x % 10;
    // x /= 10;

    // //push operation:
    // temp = rev * 10 + pop;
    // rev = temp;

    public int reverse3(int x) {
        long tmp = 0;

        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            tmp = tmp * 10 + pop;
            if(tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE)
                return 0;
        }
        return (int)tmp;
    }

}