import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
    public int[] findNonZero(int[] numbers){
        int len = numbers.length;
        if(len < 2)
            return numbers;
        for(int i=0; i<len; i++){
            int idx = i;
            for(int j=i; j<len; j++){
                if(numbers[j] < numbers[idx]){
                    idx = j;
                }
            }
            int tmp = numbers[idx];
            numbers[i] = numbers[idx];
            numbers[idx] = tmp;
        }
        return numbers;
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
            int n = Integer.pstrs[0];
            if(sol.kingNumber(n, strs[1]))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
    }
}