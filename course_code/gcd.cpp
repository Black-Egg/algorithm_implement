/**
����
As we know, gcd(A, B) means the Greatest Common Divisor (GCD) of A and B.
But zy thinks it is so easy to just let you calculate it.
So now your task is to calculate gcd(A, B^B),it is easy right?
Notice: B ^ B means B multiply by himself B times.

����
Multiply test case, each case per line.
Each line 2 integers A, B, 1 <= A, B <= 1000

���
For each test case output one line( one number ), indicating the value of gcd (A, B^B)

��������1

100 1
100 2

�������1

1
4

������ע�⣡����
�����и���ӣ�����
��������a��b^b�η����������������뵱Ȼ�Ŀ϶��������b^b��ֵ������a��b^b�����������
���������ǣ�����
��bȡֵ�ܴ�ʱ��b^b��ֵ��ǳ�֮�󣬶���pow�����ķ��صĿɱ�ʾ���������ֵ����Ϊlong double��12�ֽڣ��������ݵ�������ʱ��pow�޷�������ȷ��������

��ˣ������ȡһ���Ƚ�����ķ�����
��a��b���������Ϊ(a,b),��֪a��b^b���������(a,b^b)�����У�
1.���(a,b)����ʹ��result = result * (a,b)�������˵Ľ����ת��2��
2.���(a,b) == 1,������(a,b^b) = result��
3.���(a,b) != 1,��a = a/(a,b)��ת��1��
**/


#include<iostream>
using namespace std;

//��a��b���������
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
