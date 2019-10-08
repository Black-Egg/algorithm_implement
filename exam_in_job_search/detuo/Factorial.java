import java.math.BigInteger;

/**
 * 
 * 精确计算1000的阶乘
 * 
 */

class Solution{
    public String Largefactorial(int n){
        BigInteger sum = new BigInteger("1");
        for(int i = 2; i <= n; i++){
            BigInteger tmp = new BigInteger(String.valueOf(i));
            sum = sum.multiply(tmp);
        }
        return String.valueOf(sum);
    }
}