import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

示例 2:

输入: s = "rat", t = "car"
输出: false

说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */


class Solution {

    // 方法一：哈希表。
    // 使用哈希表记录字母出现的次数。因为只包括a-z，哈希表的长度只需要26.
    // 先使用哈希表记录 s 中字母出现的频率，再用 t 减少字母出现的频率。
    // 遍历结束后,哈希表中的值全为0，则两个字母为 字母异位词。
    // 时间复杂度O(n),空间复杂度O(n)
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[] times = new int[26];
        
        for(int i=0; i<chs.length; i++){
            times[chs[i] - 'a'] ++;
            times[cht[i] - 'a'] --;
        }
        
        for(int i : times){
            if(i != 0)
                return false;
        }
        return true;
    }

    // 方法二 另外一种比较方式
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[] times = new int[26];
        
        for(int i=0; i<chs.length; i++){
            times[chs[i] - 'a'] ++;
        }
        
        for(char ch : cht){
            times[ch - 'a'] --;
            if(times[ch - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    // 方法三 不转换成char[]，使用String.charAt()进行比较
    // 时间复杂度O(n) 空间复杂度o(1)
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] times = new int[26];
        
        for(int i=0; i<s.length(); i++){
            times[s.charAt(i) - 'a'] ++;
        }
        
        for(int i=0; i<t.length(); i++){
            times[t.charAt(i) - 'a'] --;
            if(times[ch - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    // 方法四：使用哈希表替换数组。
    // 运行时间从2ms到29ms！！！
    public boolean isAnagram4(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Map<Character, Integer> map = new HashMap<> (26);
        
        for(int i=0; i<chs.length; i++){
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
            map.put(cht[i], map.getOrDefault(cht[i], 0) - 1);
        }
        
        for(Integer n : map.values()){
            if(n != 0)
                return false;
        }
        return true;
    }

    // 方法五 先将两个字符串转换为char[]，再排序后进行比较。
    public boolean isAnagram5(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        
        Arrays.sort(chs);
        Arrays.sort(cht);
        if(Arrays.equals(chs, cht))
            return true;
        else
            return false;
    }
}