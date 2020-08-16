import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    说明：

    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

    示例 1:

    输入: [2,2,1]
    输出: 1

    示例 2:

    输入: [4,1,2,1,2]
    输出: 4

 * 
 */

class Solution {
    // 方法一 使用异或操作
    public int singleNumber1(int[] nums) {
        int num = 0;
        for(int i=0; i<nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }

    // 方法二 先排序后比较
    public int singleNumber2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<len-1; i+=2){
            if(nums[i] != nums[i+1])
                return nums[i];
        }
        return nums[len-1];
    }

    // 方法三 利用HashSet去重
    public int singleNumber3(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int len = nums.length;
        for(int i=0; i<len; i++){
            int num = nums[i];
            if(!numSet.add(num)){
                numSet.remove(num);
            }
        }
        return numSet.iterator().next();
    }

}
