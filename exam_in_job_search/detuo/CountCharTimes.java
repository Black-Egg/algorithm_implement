/**
 * 统计字符串中各个字符出现的次数
 */
import java.util.HashMap;
import java.util.Map;

class Solution{
    public Map<Character, Integer> charNums(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }
}