import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
    public boolean kingNumber(int n, String str){
        boolean tag = true;
        int len = str.length();
        if(n < 11 || len < 11)
            tag = false;
        for(int i=0; i<len; i++){
            if(str.charAt(i) == '8'){
                int remainLen = len-i;
                if(remainLen < 11){
                    tag = false;
                    break;
                }
                else
                    break;
            }
        }
        return tag;
    }
}

public class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int t = sc.nextInt();
        List<String> list = new ArrayList<>(t);
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            String str = sc.next();
            list.add(n+","+str);
        }
        for(int j=0; j<list.size(); j++){
            String[] strs = list.get(j).split(",");
            int n = Integer.parseInt(strs[0]);
            if(sol.kingNumber(n, strs[1]))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        System.out.println(0^0);
    }
}