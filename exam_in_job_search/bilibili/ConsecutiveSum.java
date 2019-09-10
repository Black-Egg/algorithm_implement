// consecutive numbers sum
import java.util.Scanner;

class Solution{
    public int continueNum(int iptNum){
        int sum = 0;
        int count = 0;
        for(int i=1; i<=iptNum; i++){
           for(int j=1; j<=iptNum; j++){
               sum = (j-i+1) * (i+j)/2;
               if (sum == iptNum){
                   count++;
               }
           }
        }
        return count;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int iptNum = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.continueNum(iptNum));
    }
}