#include <iostream>
#include <iomanip>
#include <vector>
#include <utility>
#include <math.h>
using namespace std;

void cal(vector<pair<int,int>> triangle, pair<int,int> point){
    pair<int,int>a,b,c,p;//向量AB、AC、BC、AP
    float u,v,area,al,bl,cl,l;
    string inside;
    a.first = triangle[1].first - triangle[0].first;
    a.second = triangle[1].second - triangle[0].second;
    b.first = triangle[2].first - triangle[0].first;
    b.second = triangle[2].second - triangle[0].second;
    c.first = triangle[2].first - triangle[1].first;
    c.second = triangle[2].second - triangle[1].second;
    p.first = point.first - triangle[0].first;
    p.second = point.second - triangle[0].second;

    //海伦公式求面积
    al = sqrt(a.first*a.first + a.second*a.second);
    bl = sqrt(b.first*b.first + b.second*b.second);
    cl = sqrt(c.first*c.first + c.second*c.second);
    l = (al+bl+cl)/2;
    area = sqrt(l*(l-al)*(l-bl)*(l-cl));

    //盘点点与三角形的位置关系
    u = (p.first*a.second - a.first*p.second)/(float)(b.first*a.second - a.first*b.second);
    v = (p.first*b.second - b.first*p.second)/(float)(a.first*b.second - b.first*a.second);

    if(u>0 && v>0 && u+v<1)
        inside = "Yes";
    else
        inside = "No";
    cout<< setiosflags(ios::fixed) <<setprecision(1) << area << " " << inside << endl;
}

int main(){
    int n,ver_x,ver_y,point_x,point_y;
    int i = 1;
    vector<pair<int,int>> triangle;
    pair<int,int> point;
    cin >> n;
    while(i<=n){
        for(int i=0; i<3; i++){
            cin >> ver_x >> ver_y;
            triangle.push_back(make_pair(ver_x,ver_y));
        }
        cin>>point.first>>point.second;
        cout<<"Case " << i << ":" <<endl;
        cal(triangle,point);
        i++;
    }
    return 0;
}
