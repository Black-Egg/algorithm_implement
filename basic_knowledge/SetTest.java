import java.util.Set;
import java.util.HashSet;
public class SetTest{
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        Integer a = Integer.valueOf(221);
        Integer b = Integer.valueOf(221);
        System.out.println(a == b);
    }

}