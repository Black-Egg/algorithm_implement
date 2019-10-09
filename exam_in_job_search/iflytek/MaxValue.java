import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;

class Solution{
    public BigInteger maxValue(String n){
        BigInteger bi = new BigInteger(n);
        if(bi.equals(BigInteger.ONE))
            return bi;
        if(bi.mod(BigInteger.TWO) == BigInteger.ZERO){
            BigInteger tmp = bi.divide(BigInteger.TWO);
            return tmp.multiply(tmp);
        }
        else{
            BigInteger tmp = bi.divide(BigInteger.TWO);
            return tmp.multiply(tmp.add(BigInteger.ONE));
        }
    }
}

public class MaxValue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String n = sc.nextLine();
        System.out.println(sol.maxValue(n));
        sc.close();
    }
}