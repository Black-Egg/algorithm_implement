/**
 * 回文串：正读和反读都一致的字符串
 * 
 * 给定一个字符串，验证它是否是回文串(，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:

输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class Solution {

    // 方法一：先将String转换成小写再转换成char[]，之后利用双指针法
    // 前后指针均跳过非数字或字母的字符，
    // 比较前后指针指向的字符是否相等，若不等，则返回false
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chs = s.toCharArray();
        int low = 0;
        int high = chs.length - 1;
        while(low < high){
            if(isLetterOrNumber(chs[low]) && isLetterOrNumber(chs[high])){
                if(chs[low] != chs[high])
                    return false;
                ++low;
                --high;
            }
            if (!isLetterOrNumber(chs[low])){
                ++low;
            }
            if (!isLetterOrNumber(chs[high])){
                --high;
            }
        }
        return true;
    }
    public boolean isLetterOrNumber(char s){
        if ((s >= 'a' && s <= 'z') || (s >= '0' && s <= '9'))
            return true;
        else
            return false;
    }

    // 方法二：先将String转换成小写再转换成char[]，之后利用双指针法
    // 前后指针均跳过非数字或字母的字符，
    // 比较前后指针指向的字符是否相等，若不等，则返回false
    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        char[] chs = s.toCharArray();
        int low = 0;
        int high = chs.length - 1;
        while(low < high){
            while(low < high && !isLetterOrNumber(chs[low])){
                ++low;
            }
            while(low < high && !isLetterOrNumber(chs[high])){
                --high;
            }
            if(chs[low] != chs[high])
                return false;
            ++low;
            --high;
        }
        return true;
    }

    // 方法三 调用Character.isLetterOrDigit()判断是否为数字或字母
    // 使用String.charAt()进行判断
    // 时间复杂度O(n)，空间复杂度O(1)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
           
            int low = 0;
            int high = s.length() - 1;
            
            while(low < high){
                while(low < high && !Character.isLetterOrDigit(s.charAt(low))){
                    ++low;
                }
                while(low < high && !Character.isLetterOrDigit(s.charAt(high))){
                    --high;
                }
                if(s.charAt(low) != s.charAt(high))
                    return false;
                ++low;
                --high;
            }
            return true;
            
        }
    }
}