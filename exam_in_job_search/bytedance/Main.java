import java.util.Scanner;

class Solution{
    int maxHappy(int[] prize, int[] discount, int[] happy, int budget){
        int max = 0;
        int sum = 0;
        int disSum = 0; 
        int N = discount.length;
        double[] mul = new double[N];
        int[] index = new int[N];
        for(int i=0; i<N; i++){
            mul[i] = (double)happy[i]*discount[i];
            index[i] = i;
        }
        double maxVal = 0.0;
        int maxIdx = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(mul[j] > mul[i]){
                    maxVal = mul[i];
                    mul[i] = mul[j];
                    mul[j] = maxVal;
                    maxIdx = index[i];
                    index[i] = index[j];
                    index[j] = maxIdx;
                }
            }
        }

        // for(int i=0; i<N; i++){
        //     mul[i] = (double)happy[i]/prize[i];
        //     index[i] = i;
        // }
        // double maxVal = 0.0;
        // int maxIdx = 0;
        // for(int i=0; i<N; i++){
        //     for(int j=i+1; j<N; j++){
        //         if(mul[j] > mul[i]){
        //             maxVal = mul[i];
        //             mul[i] = mul[j];
        //             mul[j] = maxVal;
        //             maxIdx = index[i];
        //             index[i] = index[j];
        //             index[j] = maxIdx;
        //         }
        //     }
        // }

        for(int i=0; i<N; i++){
            if(disSum < budget && sum > budget)
               break;
            else{
                sum = sum + prize[index[i]];
                max = max + happy[index[i]];
                disSum = disSum + discount[index[i]];
            }
        }
        return max;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int n = sc.nextInt();
        int budget = sc.nextInt();

        int prize[] = new int[n];
        int prize_dis[] = new int[n];
        int happy[] = new int[n];
        int discount[] = new int[n];

        for(int i=0; i<n; i++){
            prize[i] = sc.nextInt();
            prize_dis[i] = sc.nextInt();
            happy[i] = sc.nextInt();
            discount[i] = prize[i] - prize_dis[i];
        }
        sc.close();
        System.out.println(sol.maxHappy(prize, discount, happy, budget));
    }
}