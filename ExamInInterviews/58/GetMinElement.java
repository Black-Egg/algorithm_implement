/**
 * 
 * 有一组数，每轮选择出最小的数A以及次小的数B,将最小的数从数组中删除，并将次小的数B变成B+A。相同的数不互相叠加。
 * 求，经过m轮后，数组中的最小值。
 * 如：输出经过4轮后的最小值。
 * [0]     1 1 2 3 4 6 8
 * [1]       1 3 3 4 6 8
 * [2]         4 3 4 6 8
 * [3]           7 4 6 8
 * [4]            11 6 8
 * 输出 6
 * 
 * 分析：
 *      1. 使用最小堆。
 *      2. 反复排序？
 * 
 */


import java.util.Scanner;
import java.util.Arrays;


class Solution{
    public int getMinElements(int m, int[] nums){
        int minIdx = 0;
        for(int i = 0; i < m; i++){
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            if(nums[i+1] != nums[i]){
                nums[i+1] = nums[i+1] + nums[i];
            }
            ++minIdx;
        }

        return nums[minIdx];
    }
}
public class GetMinElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String F = sc.nextLine();
        String[] stringNums = F.split(" ");

        int n = Integer.parseInt(stringNums[0]);
        int m = Integer.parseInt(stringNums[1]);
        int[] nums = new int[n];
        
        for(int i = 2; i < stringNums.length; i++){
            nums[i] = Integer.parseInt(stringNums[i]);
        }
 
        Solution sol = new Solution();
        System.out.println(sol.getMinElements(m, nums));
        sc.close();
    }
}