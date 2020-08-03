import java.util.Arrays;
import java.util.List;
public class PrintMethod{
    public static void main(String[] args){
        String[] array = new String[]{"1", "2"};
        System.out.println(array);                  // 输出 [Ljava.lang.String;@16b4a017
        System.out.println(array.toString());       // 输出 [Ljava.lang.String;@16b4a017
        System.out.println(Arrays.toString(array)); // 输出 [1, 2]
        List<String> list = Arrays.asList(array);
        System.out.println(list);                   // 输出 [1, 2]
        System.out.println(list.toString());        // 输出 [1, 2]
    }
}