import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Test{
    public Map<Character, Integer> charNums(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }
}

