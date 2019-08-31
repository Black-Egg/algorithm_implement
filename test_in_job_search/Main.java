import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class Solution{
    public List<Integer> findClosedInt(List<Integer> arr, int k, int x){
        List<Integer> list = new ArrayList<>();
        for(int num:arr){
            list.add(num);
        }
        Collections.sort(list,(a,b)->a==b?a-b:Math.abs(a-x)-Math.abs(b-x));
        list = list.subList(0, k);
        Collections.sort(list);
        return list;
    }
}


public class Main{
    public static void main(String[] args){
        int k=0;
        int x=0;
        List<Integer> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String arrString = in.next();

        String[] intStrArr = arrString.split(",");
        for(int i=0; i<intStrArr.length; i++){
            arr.add(Integer.parseInt(intStrArr[i]));
        }
        for(int idx=0; idx<arr.size(); idx++){
            System.out.println(arr.get(idx));
        }

        k = in.nextInt();
        x = in.nextInt();
        Solution s = new Solution();
        List<Integer> list = s.findClosedInt(arr,k,x);
        for(int j=0; j<list.size();j++){
            System.out.print(list.get(j));
            if(j!=list.size()-1)
                System.out.print(",");
        }
    }
}
