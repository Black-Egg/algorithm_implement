import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution{
    public int[] findSite(int arr[], int target){
        int[] res = {-1, -1};
        int start = -1;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                if(start == -1){
                    start = i;
                }
                count++;
            }
        }
        res[0] = start;
        if(start != -1)
            res[1] = start + count - 1;
        return res;
    }
}

public class FindNumIdx{
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
        int[] res = sol.findSite(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}