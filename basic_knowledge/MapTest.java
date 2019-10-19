import java.util.Map;

public class Maptest{
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        //遍历Map的键
        for(Character s : map.keySet()){
            System.out.println(s);
        }

        //遍历Map的值
        for(Integer t : map.values()){
            System.out.println(t);
        }

        // 同时获取键 值
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 使用迭代器遍历
        // 对于上面的几种foreach都可以用Iterator代替，
        // foreach优势：更简洁，但在用foreach遍历map时，如果改变其大小，会报错
        // Iterator优势：使用Iterator的remove方法删除元素
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
            // it.remove(); 删除元素
        }

        // 使用Lambda表达式
        // java8提供了Lambda表达式支持，语法看起来更简洁，可以同时拿到key和value，
        // 不过，经测试，性能低于entrySet,所以更推荐用entrySet的方式
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

    }
}