//新的区间列表

#include <iostream>
#include <vector>
#include <utility>
using namespace std;

int main(){
    vector <pair<int,int>> A;
    vector <pair<int,int>> C;
    pair <int,int> B;
    int n;
    int start_tmp,end_tmp;
    int insert_pos;

    while(cin >> n){
        insert_pos = 0;
        A.clear();
        C.clear();


        for(int i=0; i<n; i++){
            cin>>start_tmp>>end_tmp;
            A.push_back(make_pair(start_tmp,end_tmp));
            //cout<<start_tmp<<" "<<end_tmp<<endl;
        }
        cin>>B.first>>B.second;
        //cout<<B.first<<" "<<B.second<<endl;

        for(int i=0; i<n; i++){
            //cout<<A[i].first<<" "<<A[i].second<<endl;
            if(A[i].second < B.first){
                C.push_back(A[i]);
                insert_pos++;
            }
            else if(A[i].first > B.second){
                C.push_back(A[i]);
            }
            else{
                B.first = min(A[i].first,B.first);
                B.second = max(A[i].second,B.second);
            }
        }
        C.insert(C.begin()+insert_pos,B);

        for(int i=0; i<C.size(); i++){
            if(i) cout<<" ";
            cout << C[i].first <<" "<< C[i].second;
        }
        cout<<endl;
    }
    return 0;
}
