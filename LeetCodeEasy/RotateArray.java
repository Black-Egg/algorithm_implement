/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

说明:

    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    要求使用空间复杂度为 O(1) 的 原地 算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */


class Solution {
    // 方法1 暴力解法，旋转k次，每次旋转1个元素. 时间复杂度 O(n∗k), 空间复杂度 O(1) 
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int temp, previous;
        for (int i=0; i<k; i++){
            previous = nums[len - 1];
            for (int j=0; j<len; j++){
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // 方法2 使用额外的数组，时间复杂度 O(n), 空间复杂度 O(n)
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] copy = new int[len];
        for (int i=0; i<len; i++){
            copy[(i+k) % len] = nums[i];
        }

        for (int j=0; j<len; j++){
            nums[j] = copy[j];
        }
    }

    // 方法3 使用反转。旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。 
    // 可通过三次反转实现: 先反转所有元素，然后反转前k%n个元素，再反转n-(k%n)个元素。时间复杂度：O(n)，空间复杂度：O(1) 

    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            end--;
            start++;
        }
    }
}