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