/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

 

注意事项：您可以假定该字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */


import java.util.Map;
import java.util.HashMap;
class Solution {

    // 方法一：利用HashMap. 时间复杂度O(N)，空间复杂度O(1)
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    // 方法二：利用数组替代HashMap，用0-25作为下标记录，字母出现的次数。
    // 时间复杂度O(N)，空间复杂度O(1).
    // 使用String.charAt()。时间在13ms左右
    public int firstUniqChar2(String s) {
        int[] times = new int[26];
        for(int i = 0; i < s.length(); i ++){
            times[s.charAt(i) - 'a'] ++;
        }
        
        for(int i = 0; i < s.length(); i ++){
            if(times[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
        
    }

    // 方法三：利用数组替代HashMap，用0-25作为下标记录，字母出现的次数。
    // 时间复杂度O(N)，空间复杂度O(N).
    // 先将String转换成char[]。时间在5ms左右
    public int firstUniqChar3(String s) {
        int[] times = new int[26];
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++){
            times[chars[i] - 'a'] ++;
        }
        
        for(int i = 0; i < chars.length; i ++){
            if(times[chars[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }

    // 方法四：利用数组替代HashMap，用0-25作为下标记录，字母出现的次数。
    // 时间复杂度O(N)，空间复杂度O(N).
    // 先将String转换成char[]。
    // 使用for(char t : chars) 替换 for(int i; i< chars.length; i++)，对运行时间无影响。时间在5ms左右
    public int firstUniqChar4(String s) {
        int idx = 0;
        int[] times = new int[26];
        char[] chars = s.toCharArray();
        for(char t : chars){
            times[t - 'a'] ++;
        }
        
        for(char t : chars){
            if(times[t - 'a'] == 1)
                return idx;
            idx++;
        }
        return -1; 
    }

    // 方法五：使用String自带的查找方法。时间复杂度O(n)，空间复杂度O(1)
    public int firstUniqChar5(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char t = chars[i];
            if(s.indexOf(t) == s.lastIndexOf(t)){
                return i;
            }
        }
        return -1;
    } 
}
