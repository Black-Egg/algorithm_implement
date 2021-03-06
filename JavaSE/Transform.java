import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
 
public class Transform {
    public static void main(String[] args) {
        int[] data = {4, 5, 3, 6, 2, 5, 1};
 
        // int[] 转 List<Integer>
        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());
        // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
        // 1.使用Arrays.stream将int[]转换成IntStream。
        // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
        // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
 
        // int[] 转 Integer[]
        Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);
        // 前两步同上，此时是Stream<Integer>。
        // 然后使用Stream的toArray，传入IntFunction<A[]> generator。
        // 这样就可以返回Integer数组。
        // 不然默认是Object[]。
 
        // List<Integer> 转 Integer[]
        Integer[] integers2 = list1.toArray(new Integer[0]);
        //  调用toArray。传入参数T[] a。这种用法是目前推荐的。
        // List<String>转String[]也同理。
 
        // List<Integer> 转 int[]
        int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();
        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。
 
        // Integer[] 转 int[]
        int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();
        // 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。
 
        // Integer[] 转 List<Integer>
        List<Integer> list2 = Arrays.asList(integers1);
        // 最简单的方式。String[]转List<String>也同理。


        // int[] 转 Map<Integer>
        Set<Integer> set1 = Arrays.stream(data).boxed().collect(Collectors.toSet());
        // Set<Integer> set1 = IntStream.of(data).boxed().collect(Collectors.toSet());
        // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
        // 1.使用Arrays.stream将int[]转换成IntStream。
        // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
        // 3.使用Stream的collect()，将Stream<T>转换成Set<T>，因此正是Set<Integer>。

        // Map<Integer> 转 int[]
        int[] arr3 = set1.stream().mapToInt(Integer::valueOf).toArray();
        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。


        // 同理
        String[] strings1 = {"a", "b", "c"};
        // String[] 转 List<String>
        List<String> list3 = Arrays.asList(strings1);
        // List<String> 转 String[]
        String[] strings2 = list3.toArray(new String[0]);
        
        // String[] 转 Map<String>
        Set<String> set2 = new HashSet<String>(Arrays.asList(strings1));
        // Map<String> 转 String[]
        String[] strings3 = new String[set2.size()];     
        set2.toArray(strings3);

        // String转char[]
        String s1 = "-12345";
        char[] chrs1 = s1.toCharArray();

        // char[] 转 String
        String s2 = String.valueOf(chrs1);
        String s3 = new String(chrs1);
        System.out.println(s2);
        System.out.println(s3);

        // int 转 String
        int i = 123;
        String s4 = String.valueOf(i);
        System.out.println(s4);
        
    }
}