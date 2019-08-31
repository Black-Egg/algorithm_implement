/**
����

���죬ACM���������������һ����и⣬һ����n�ˡ�ǡ�ã�ACM��Ա��һ����n���ˣ�Ϊ�˱�֤��ƽ��ÿ�˳�һ���и⡣����֪��zy�м��˵ã����԰ѷ��и�����񽻸���������n���и��г�n��1�˵��и��zy��Ȼ�������⡣�������ڼ�����̫�ߣ�����Ҫ������ATP������������

�������飬����������n�˵��и��г�x�˺�(n-x)�˺���Ҫ����x*(n-x)��λ��ATP��������1<=x<=n����xΪ������

����֪�������������С��Ҫ���Ķ���ATP��ע�⣺zyÿ������ѡ��һ���и�����г����ݣ���������������ATP��ÿ���еĲ��������ATP�ĺ͡�

����

��һ����һ���޷�������t(1<=t<=50)����ʾ��t�����ݡ�ÿ�����ݰ���һ���޷���������n��n<=2013)������������������и�=��=��

���

����ÿ�����ݣ������Needs at least x ATP(s)!��������x��ʾzy��С��Ҫ���ĵ�ATP���統x=1ʱ�������Needs at least 1 ATP!������x=2ʱ�������Needs at least 2 ATPs!��

������Ҫ����ATP���������Mission Complete!����

��������1 ����

2
1
2

�������1

Mission Complete!
Needs at least 1 ATP!


���������
������һ���򵥵ĵݹ����⣡
**/


#include <iostream>
using namespace std;

int atp(int n){
    if(n==1)
        return 0;
    if(n>1)
        return n-1+atp(n-1);
}

int main(){
    int t,n;
    cin >> t;
    for(int i=0; i<t; i++){
        cin >> n;
        if(n<=0 || n>2013)
            exit(0);
        if(atp(n) == 0)
            cout << "Mission Complete!" << endl;
        else if(atp(n) == 1)
            cout << "Needs at least " << atp(n) <<  " ATP!" << endl;
        else
            cout << "Needs at least " << atp(n) <<  " ATPs!" << endl;
    }
    return 0;
}
