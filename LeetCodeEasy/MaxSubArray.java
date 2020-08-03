/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:

输入: [1, 2, 2, 3, 1]
输出: 2
解释: 
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.

示例 2:

输入: [1,2,2,3,1,4,2]
输出: 6

注意:

    nums.length 在1到50,000区间范围内。
    nums[i] 是一个在0到49,999范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class Solution {
    // 方法一：暴力解法。n个数的子集之和有n(n+1)/2种情况，若有n个元素，则有n+(n-1)+ … + 1种，
    // 可使用两层for循环进行遍历。内存for循环求得localMax，外层循环比较localMax求得globalMax。时间复杂度O(n)，空间复杂度O(1)。
    
    public int maxSubArray1 (int[] nums) {
        if (nums.length < 1)
            return 0;

        int globalMax = nums[0];
        for(int i=0; i<nums.length; i++){
            int tmp = nums[i];
            int localMax = tmp;
            for(int j=i+1; j<nums.length; j++){
                tmp += nums[j];
                if(localMax < tmp)
                    localMax = tmp;
            }
            if(globalMax < localMax)
                globalMax = localMax;
        }
        return globalMax;
    }

    /**
     * 方法二：动态规划。时间复杂度O(N)，空间复杂度O(N)
    定义状态：
     * dp[i] ： 表示以 nums[i] 结尾的连续子数组的最大和
     * <p>
     * 状态转移方程：
     * dp[i] = max{num[i],dp[i-1] + num[i]}

     */

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if(len < 1) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i=1; i<len; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 方法三：动态规划。
        动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
        如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
        如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
        每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
        时间复杂度：O(n)，空间复杂度O(1)

     */
    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        if(len < 1) return 0;
        
        int sum = 0;
        int res = nums[0];
        for(int n : nums){
            if(sum > 0) sum = sum + n;
            else sum = n;
            res = Math.max(res, sum);
        }
        return res;
    }

    // 方法四：动态规划。和方法三思想一致，但实现更易理解。时间复杂度：O(n)，空间复杂度O(1)
    public int maxSubArray4(int[] nums) {
        int len = nums.length;
        if(len < 1) return 0;
        
        int segmentSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            segmentSum = Math.max(nums[i], segmentSum + nums[i]);
            res = Math.max(res, segmentSum);
        }
        return res;

    }



}