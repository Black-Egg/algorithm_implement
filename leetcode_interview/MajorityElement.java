import java.util.Map;
import java.util.HashMap;

class Solution {
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            int idx = i;
            for(int j=i; j<len; j++){
                if(nums[j] < nums[idx])
                    idx = j;
            }
            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
        }
        return nums[len/2];
    }

    public int majorityElement2(int[] nums) {
        int len = nums.length;
        Map numsMap = new HashMap();
        int target;
        for(int i=0; i<len; i++){

        }
    }

    public int majorityElement3(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            int idx = i;
            for(int j=i; j<len; j++){
                if(nums[j] < nums[idx])
                    idx = j;
            }
            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
        }
        return nums[len/2];
    }

    public int majorityElement4(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]){
                count++;
            }
            else {
                count--;
                
                if (count == 0){
                    res = nums[++i];
                    count++;
                }
            }
        }
        return res;
    }
}
