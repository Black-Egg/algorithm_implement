#include <iostream>
using namespace std;
const int H = 1000;
int A[H][H];

int main(){
    int h;
    while(cin>>h){
        for(int i=1; i<=h; i++){
            for(int j=1; j<=2*i-1; j++){
                cin>>A[i][j];
            }
        }

        //动态规划问题
        for(int i=h-1; i>=1; i--){
            for(int j=1; j<=2*i-1; j++){
                A[i][j] += max(A[i+1][j],max(A[i+1][j+1],A[i+1][j+2]));
                //cout<<A[i][j]<<endl;
            }
        }
        cout<<A[1][1]<<endl;
    }
    return 0;
}
