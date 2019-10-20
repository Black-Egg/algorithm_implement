import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution{
    public int[] twoSum(int arr[], int target){
        int[] res = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!map.keySet().contains(target - arr[i])){
                map.put(arr[i], i);
            }
            else{
                res[0] = map.get(target - arr[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }
}

public class twoSum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        int i = 0;
        while(i < len){
            nums[i] = sc.nextInt();
            i++;
        }
        int target = sc.nextInt();
        Solution sol = new Solution();
        int[] res = sol.twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}