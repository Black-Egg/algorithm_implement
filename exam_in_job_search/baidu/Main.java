import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Soultion{
    public int getMin(int n, int m, int k){
        List<Integer> suitSum = new ArrayList<>();
        for(int a=1; a<=k; a++){
            for(int b=1; b<=k; b++){
                if((a*b - m*a -n*b) <= (k - m*n)){
                    suitSum.add(a+b);
                }
            }
        }
        return QuickSort(suitSum);
    }
    public int QuickSort(List<Integer> list){
        if(list.size() == 0)
            return -1;
        for(int i=0; i<list.size(); i++){
            int minIndx = i;
            for(int j=i; j<list.size(); j++){
                if(list.get(j) < list.get(minIndx)){
                    minIndx = j;
                }
            }
            int tmp = list.get(i);
            list.set(i, list.get(minIndx));
            list.set(minIndx, tmp);
        }
        return list.get(0);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Soultion sol = new Soultion();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(sol.getMin(n, m, k));
    }
}