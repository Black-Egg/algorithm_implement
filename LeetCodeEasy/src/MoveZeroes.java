import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// 方法一，使用额外数组，然后进行拷贝，时间复杂度O(n),空间复杂度O(n)
class Solution {
    public void moveZeroes1(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len];
        int idx = 0;
        for(int i=0; i<len; i++){
            if(nums[i] != 0){
                newNums[idx] = nums[i];
                idx++;
            }
        }
        System.arraycopy(newNums, 0, nums, 0, newNums.length);
    }

    // 方法二，使用冒泡法。时间复杂度O(n^2)，空间复杂度O(1)
    public void moveZeroes2(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len-1; i++){
            int zeroIdx = i;
            for(int j=i+1; j<len; j++){
                if(nums[i] != 0) break;
                if(nums[j] == 0) continue;
                nums[zeroIdx] = nums[j];
                nums[j] = 0;
                zeroIdx = j;
            }
        }
    }

    //方法三，双指针法。时间复杂度O(n)，空间复杂度O(1)
    public void moveZeroes3(int[] nums) {
        int len = nums.length;
        int slow = 0;
        int fast = 1;
        while(fast < len){
            if (nums[slow] != 0){
                slow++;
                fast++;
            }
            else{
                if (nums[fast] == 0)
                    fast++;
                else{
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                    slow++;
                    fast++;
                }
            }
        }
    }
}






public class MoveZeroes{
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,3,12};
        Solution sol = new Solution();
        sol.moveZeroes(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}