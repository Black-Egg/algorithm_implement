#include <math.h>
#include <iostream>
using namespace std;

int get_min_dis(int *A, int *B, int n){
    int min = A[0] - B[0];
    int low,high,middle,target;

    for(int i=0; i<n; i++){
        low = 0;
        high = n-1;
        middle = 0;
        target = A[i];
        while(low<=high){
            middle = low+(high-low)/2;
            if(B[middle] == target){
               min = 0;
               break;
            }
            else if(B[middle] < target)
                low = middle + 1;
            else
                high = middle - 1;
        }
        if(min == 0)
            break;
        if(fabs(A[i] - B[middle]) < min)
            min = fabs(A[i] - B[middle]);
        if(middle > 0){
            if(fabs(A[i] - B[middle-1]) < min)
                min = fabs(A[i] - B[middle-1]);
        }
        if(middle < n-1){
            if(fabs(A[i] - B[middle+1]) < min)
                min = fabs(A[i] - B[middle+1]);
        }
    }
    return min;
}

int main(){
    int n,min_dis;
    while(cin>>n){
        int *A = new int[n];
        int *B = new int[n];
        for(int i=0; i<n; i++)
            cin>>A[i];
        for(int i=0; i<n; i++)
            cin>>B[i];
        min_dis = get_min_dis(A,B,n);
        delete[] A;
        delete[] B;
        cout<<min_dis;
    }
    return 0;
}
