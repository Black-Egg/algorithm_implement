import java.util.List;
import java.util.ArrayList;
public class ListTest{
    public static void main(String[] args){
        // 设置初始容量为10

        
        List<Integer> list1 = new ArrayList<Integer> (10);
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        for(int i : array1){
            list1.add(i);
        }

        // 测试List初始容量与实际添加元素的关系
        // 实际使用容量仍为9
        System.out.println(list1.size());       // 输出 9
        System.out.println(list1);              // 输出 [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(list1.toString());   // 输出 [1, 2, 3, 4, 5, 6, 7, 8, 9]

    }
}