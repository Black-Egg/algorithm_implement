#include <iostream>
using namespace std;

//获取0-m,0-n内的最大值
//int getMax(vector<vector<int>> A, int n){
int getMax(int *A, int k){
    int mx = A[0];
    for(int i=0; i<k; i++){
        for(int j=0; j<k; j++){
            if(A[i*k+j]>mx)
                mx = A[i*k+j];
        }
    }
    return mx;
}

//获取k*k的数组
void getArray(int *A, int index_i, int index_j, int n, int k, int *B){
    for(int i=0; i<k; i++){
        for(int j=0; j<k; j++){
            B[i*k+j] = A[index_i*n+index_j+i*n+j];
        }
    }
}


int main(){
    int m,n,k;
    int mx;
    int i=1;

    while(cin >> m >> n >> k){
        int *A = new int[m*n];
        int *B = new int[k*k];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                cin>>A[i*n+j];
            }
        }
        cout<< "Case " << i << endl;
        for(int i=0; i<m-k+1; i++){
            for(int j=0; j<n-k+1; j++){
               getArray(A,i,j,n,k,B);
               mx = getMax(B,k);
               if(j!=0 && j!=n-k+1) cout<<" ";
               cout<< mx;
            }
            cout << endl;
        }
        i++;
    }
    return 0;
}


