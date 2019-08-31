#include <iostream>
#include <vector>
#include <utility>
using namespace std;

void cal(vector< pair<int,int> > triangle, pair<int,int> point){
    pair<int,int>ab,ap,bc,bp,cd,cp,da,dp;
    int a,b,c,d;
    string inside;
    //AB
    ab.first = triangle[1].first - triangle[0].first;
    ab.second = triangle[1].second - triangle[0].second;
    //AP
    ap.first = point.first - triangle[0].first;
    ap.second = point.second - triangle[0].second;

    //BC
    bc.first = triangle[2].first - triangle[1].first;
    bc.second = triangle[2].second - triangle[1].second;
    //BP
    bp.first = point.first - triangle[1].first;
    bp.second = point.second - triangle[1].second;

    //CD
    cd.first = triangle[3].first - triangle[2].first;
    cd.second = triangle[3].second - triangle[2].second;
    //CP
    cp.first = point.first - triangle[2].first;
    cp.second = point.second - triangle[2].second;

    //DA
    da.first = triangle[0].first - triangle[3].first;
    da.second = triangle[0].second - triangle[3].second;
    //DP
    dp.first = point.first - triangle[3].first;
    dp.second = point.second - triangle[3].second;

    a = (ab.first*ap.second - ab.second*ap.first);
    b = (bc.first*bp.second - bc.second*bp.first);
    c = (cd.first*cp.second - cd.second*cp.first);
    d = (da.first*dp.second - da.second*dp.first);

    if((a >= 0 && b >= 0 && c >= 0 && d >= 0) || (a <= 0 && b <= 0 && c <= 0 && d <= 0))
        cout<< "In" << endl;
    else
        cout<< "Out" << endl;
}

int main(){
    int n,ver_x,ver_y,point_x,point_y;
    int i = 1;
    vector< pair<int,int> > rectangle;
    pair<int,int> point;
    cin >> n;
    while(i<=n){
        rectangle.clear();
        for(int i=0; i<4; i++){
            cin >> ver_x >> ver_y;
            rectangle.push_back(make_pair(ver_x,ver_y));
        }
        cin>>point.first>>point.second;
        cout<<"Case " << i << ":" <<endl;
        cal(rectangle,point);
        i++;
        rectangle.clear();
    }
    return 0;
}


