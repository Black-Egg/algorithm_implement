import java.util.Scanner;

class Solution{
    int planNum(int[] arr, int target){
        int left = 0;
        int right = 2;
        int len = arr.length;
        int count = 0;
        while(left < len-2){

            if(right - left < 2) right++;
            if(right == len){
                left++;
                right = left + 2;
            }
            else{
                for(int mid=left+1; mid<right; mid++){

                    int sum = arr[left] + arr[mid] + arr[right];

                    if(sum < target){
                        count++;
                    }
                }
                right++;
            }
        }
        return count;
    }
}

public class Window{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        sc.close();
        System.out.println(sol.planNum(arr, K));
    }
}