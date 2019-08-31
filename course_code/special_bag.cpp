#include <iostream>
#include <vector>
#include <utility>
using namespace std;

vector<pair<int,int>> getLightest(vector<pair<int,int>> v){
    pair<int,int> c;
    for(int i=0; i<v.size()-1; i++ ){
        for(int j=0; j<v.size()-i-1; j++){
            if(v[j].first>v[j+1].first){
                c = v[j];
                v[j] = v[j+1];
                v[j+1] = c;
            }
        }
    }
    return v;
}


int main(){
    int n,c,wei,val,k;
    int j = 1;
    while(cin >> n >> c){
        wei = 0;
        val = 0;
        int *value = new int[n];
        int *weight = new int[n];
        vector<pair<int,int>> mat,order_mat;

        for(int i=0; i<n; i++)
            cin >> value[i];
        for(int i=0; i<n; i++)
            cin >> weight[i];

        for(int i=0; i<n; i++)
            mat.push_back(make_pair(weight[i],value[i]));
        order_mat = getLightest(mat);
        k = 0;
        while(wei < c){
            wei = wei + order_mat[k].first;
            if(wei > c) break;
            val = val + order_mat[k].second;
            k++;
        }
        cout << "Case " << j << ": " << val << endl;
        j++;
    }
    return 0;
}
