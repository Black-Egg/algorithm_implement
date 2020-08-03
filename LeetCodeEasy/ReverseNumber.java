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