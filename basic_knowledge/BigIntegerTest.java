import java.math.BigInteger;

// 测试BigInteger的用法

public class BigIntegerTest{
    public static void main(String[] args){
        int a = 100000000;

        // BigInteger的构造方法接受String、大端二进制补码数组（big-endian two's-complement binary）
        BigInteger bi1 = new BigInteger(String.valueOf(a));
        BigInteger bi2 = new BigInteger("456789655");
       
		System.out.println("加法操作：" + bi2.add(bi1)) ;	// 加法操作
		System.out.println("减法操作：" + bi2.subtract(bi1)) ;	// 减法操作
		System.out.println("乘法操作：" + bi2.multiply(bi1)) ;	// 乘法操作
		System.out.println("除法操作：" + bi2.divide(bi1)) ;	// 除法操作
		System.out.println("最大数：" + bi2.max(bi1)) ;	 // 求出最大数
		System.out.println("最小数：" + bi2.min(bi1)) ;	 // 求出最小数
		BigInteger result[] = bi2.divideAndRemainder(bi1) ;	// 求出余数的除法操作
		System.out.println("商是：" + result[0] + 
			"；余数是：" + result[1]) ;
	}
}