/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len < 1) return "";
        if(len == 1) return strs[0];
        int[] strLens = new int[len];
        for(int i=0; i<len; i++){
            strLens[i] = strs[i].length();
        }
        
        Arrays.sort(strLens);
        
        int minLen = strLens[0];
        
        if(minLen < 1) return "";
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<minLen; i++){
            boolean same = true;
            
            for(int j=0; j<len-1;j ++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    same = false;
                    break;
                }
            }
            if(same) sb.append(strs[0].charAt(i));
            else break;
        }
        
        return sb.toString();
         
    }
}