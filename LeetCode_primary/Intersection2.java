import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    // 方法一：使用哈希表。使用哈希表存储较大数组中出现的数与数出现的频次。
    // 之后遍历较小的数组，若当前索引的存在于哈希表的键中且频次大于0，则将其存入数组中，并将哈希表中的频次减一。
    // 时间复杂度O(m+n)，空间复杂度O(m+n)。
    public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return mixIntersect(nums1, nums2);
        else
            return mixIntersect(nums2, nums1);
    }

    public int[] mixIntersect(int[] longArr, int[] shortArr){
        int[] res = new int[shortArr.length];
        Map<Integer, Integer> map = new HashMap<Integer,Integer> (longArr.length);
        for(int n : longArr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int idx = 0;
        for(int n : shortArr){
            if(map.get(n) != null){
                int times = map.get(n);
                if(times > 0){
                    map.put(n, --times);
                    res[idx++] = n;
                }
            }
        }
        return Arrays.copyOf(res, idx);
    }


    // 方法二： 排序后使用双指针。时间复杂度O(nlogn)，空间复杂度O(1)
    
}