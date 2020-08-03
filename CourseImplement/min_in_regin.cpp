#include <iostream>
using namespace std;

int search(int *A, int start, int end){
    int min = A[start];
    for(int i=start+1; i<=end; i++){
        if(min>A[i])
            min = A[i];
    }
    return min;
}


int main(){
    int n,q;
    while(cin>>n>>q){
        int* A = new int[n];
        int* B = new int[2*q];

        for(int i=0; i<n; i++)
            cin>>A[i];
        for(int i=0; i<2*q; i++)
            cin>>B[i];

        for(int i=0; i<q; i++){
            int start = B[2*i];
            int end = B[2*i+1];
            //cout << start << " " <<end <<endl;
            int result = search(A,start,end);
            if(i) cout<<" ";
            cout<<result;
        }
        cout<<endl;
        delete[] A;
        delete[] B;
    }
    return 0;
}
