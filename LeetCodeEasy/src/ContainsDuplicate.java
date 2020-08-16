import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true

示例 2:

输入: [1,2,3,4]
输出: false

示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

 */

class Solution {
    // 方法1 先排序后判断相邻的元素
    public boolean containsDuplicate1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 1; i++){
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    // 方法2 Hash表去重
    public boolean containsDuplicate2(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet <> (len);
    
        // for(int i=0; i<nums.length; i++)
        //     if(set.contains(nums[i])) return true;
        //     set.add(nums[i]);
        // 也可写成
        
        for (int x: nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}