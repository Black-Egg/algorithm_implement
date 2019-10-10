import java.util.Scanner;

class Solution{
    public boolean isSame(String a, String b, int maskNum){
       String[] ip1 = a.split("\\.");
       String[] ip2 = b.split("\\.");
       String maskStr = "";
       for(int i=0; i<16; i++){
           if(i<maskNum){
               maskStr = maskStr + "1";
           }
           else{
               maskStr = maskStr + "0";
           }
           
       }
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip1 = in.next();
        String ip2 = in.next();
        int maskNum = in.nextInt();
        Solution sol = new Solution();
        boolean p = sol.isSame(ip1, ip2, maskNum);
        System.out.println(p);
            
    }
}