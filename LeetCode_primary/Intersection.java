
/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]

示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]

说明:

    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

class Solution {

    // 方法一：暴力解法。遍历两个数组，将相同的元素存入Set去除重复。时间复杂度O(m*n)，空间复杂度O(n)
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set <Integer> set = new HashSet<> ();
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j])
                    set.add(nums1[i]);
            }
        }
        int[] res = set.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

    // 方法二：两个Set法。先将两个数组存入Set中，然后迭代较小的集合是否存在较大集合中。则平均情况下时间复杂度为O(m+n)空间复杂度为O(m+n)
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set <Integer> set1 = new HashSet<> ();
        Set <Integer> set2 = new HashSet<> ();

        for(int i : nums1)
            set1.add(i);
        for(int j : nums2)
            set2.add(j);
        if(set1.size() > set2.size())
            return mixIntersection(set1, set2);
        else
            return mixIntersection(set2, set1);
    }

    public int[] mixIntersection(Set<Integer> maxSet, Set<Integer> minSet){
        int[] output = new int[minSet.size()];
        int idx = 0;
        for(Integer num : minSet){
            if(maxSet.contains(num)){
                output[idx] = num;
                ++idx;
            }
        }
        return Arrays.copyOf(output, idx);
    }

    // 方法三：利用Java自带的retainAll()函数。则平均情况下时间复杂度为O(m+n)空间复杂度为O(m+n)
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set <Integer> set1 = new HashSet<> ();
        Set <Integer> set2 = new HashSet<> ();

        for(int i : nums1)
            set1.add(i);
        for(int j : nums2)
            set2.add(j);
        set1.retainAll(set2);
        
        int[] res = new int[set1.size()];
        int idx = 0;
        for(Integer num : set1){
            res[idx++] = num;
        }
        return res;
    }
}