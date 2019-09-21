class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len-1;
        char tmp;
        if (s == null || len < 2)
            return;
        
        // 在循环外声明变量，比在循环内声明变量也可降低内存消耗
        while(left < right){
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            // 使用三次异或操作进行交换可降低内存消耗
            // s[left] ^= s[right];
            // s[right] ^= s[left];
            // s[left] ^= s[right];
            right--;
            left++;
        }
    }
}