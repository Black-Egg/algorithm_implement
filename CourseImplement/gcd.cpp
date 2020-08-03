/**
描述
As we know, gcd(A, B) means the Greatest Common Divisor (GCD) of A and B.
But zy thinks it is so easy to just let you calculate it.
So now your task is to calculate gcd(A, B^B),it is easy right?
Notice: B ^ B means B multiply by himself B times.

输入
Multiply test case, each case per line.
Each line 2 integers A, B, 1 <= A, B <= 1000

输出
For each test case output one line( one number ), indicating the value of gcd (A, B^B)

样例输入1

100 1
100 2

样例输出1

1
4

！！！注意！！！
这里有个大坑！！！
这里是求a与b^b次方的最大公因数，大家想当然的肯定是先求出b^b的值，再求a与b^b的最大公因数。
！！！但是！！！
当b取值很大时，b^b的值会非常之大，而且pow函数的返回的可表示最大数的数值类型为long double（12字节），当求幂的数过大时，pow无法给出正确计算结果。

因此，这里采取一个比教巧妙的方法：
记a与b的最大公因数为(a,b),可知a与b^b的最大公因数(a,b^b)，且有：
1.求出(a,b)，并使用result = result * (a,b)保存连乘的结果。转到2。
2.如果(a,b) == 1,结束。(a,b^b) = result。
3.如果(a,b) != 1,令a = a/(a,b)，转到1。
**/


#include<iostream>
using namespace std;

//求a和b的最大公因数
int gcd(int a, int b){
    int r;
    while(b!=0){
        r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int main(){
    int a,b,result,flag;
    while(cin >> a >> b){
        result = 1;
        if(a<1 || b>1000)
            exit(0);
        /**
        for(int i=0; i<b; i++){
            flag = gcd(a,b);
            result = result*flag;
            if(flag == 1)
                break;
            else
                a = a/flag;
        }
        **/
         for(; gcd(a,b)!=1; a=a/gcd(a,b)){
                result = result*gcd(a,b);
        }
        cout << result << endl;
    }
    return 0;
}
