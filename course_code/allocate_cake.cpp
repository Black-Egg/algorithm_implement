/**
描述

这天，ACM教练给大家买来了一大块切糕，一共是n克。恰好，ACM队员里一共有n个人，为了保证公平，每人吃一克切糕。教练知道zy切技了得，所以把分切糕的任务交给了他。把n克切糕切成n块1克的切糕对zy自然不是问题。但是由于技术性太高，他需要大量的ATP来完成这个任务。

经过调查，他发现他把n克的切糕切成x克和(n-x)克后，需要消耗x*(n-x)单位的ATP。（其中1<=x<=n，且x为整数）

他想知道他完成任务最小需要消耗多少ATP。注意：zy每次总是选择一块切糕把它切成两份，完成任务所需的总ATP即每次切的操作所需的ATP的和。

输入

第一行有一个无符号整数t(1<=t<=50)，表示有t组数据。每组数据包含一个无符号整数，n（n<=2013)。（教练买不起大量的切糕=。=）

输出

对于每组数据，输出“Needs at least x ATP(s)!”，其中x表示zy最小需要消耗的ATP。如当x=1时，输出“Needs at least 1 ATP!”；当x=2时，输出“Needs at least 2 ATPs!”

若不需要消耗ATP，则输出“Mission Complete!”。

样例输入1 复制

2
1
2

样例输出1

Mission Complete!
Needs at least 1 ATP!


问题分析：
此题是一个简单的递归问题！
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
