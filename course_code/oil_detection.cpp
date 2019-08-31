/**
描述

The ZhouNiMa imperial family company is responsible for detecting underground oil deposits. ZhouNiMa works with one large rectangular region of land at a time, and creates a grid that divides the land into numerous square plots. It then analyzes each plot separately, using sensing equipment to determine whether or not the plot contains oil.

A plot containing oil is called a pocket. If two pockets are adjacent, then they are part of the same oil deposit. Oil deposits can be quite large and may contain numerous pockets. Your job is to determine how many different oil deposits are contained in a grid.
输入

The input file contains one or more grids. Each grid begins with a line containing m and n, the number of rows and columns in the grid, separated by a single space. If m = 0 it signals the end of the input; otherwise   and  . Following this are m lines of n characters each (not counting the end-of-line characters). Each character corresponds to one plot, and is either `*', representing the absence of oil, or `@', representing an oil pocket.

输出

For each grid,. Tw output the number of distinct oil depositso different pockets are part of the same oil deposit if they are adjacent horizontally, vertically, or diagonally. An oil deposit will not contain more than 100 pockets,means that if it contains more than 100 pockets , you should ....

样例输入1 复制

1 1
*
3 5
*@*@*
**@**
*@*@*
1 8
@@****@*
0 0

样例输出1

0
1
2

算法分析：
图搜索算法。深度优先搜索。此算法还不熟悉，需加强！

**/

#include <iostream>
using namespace std;
const int N = 1000;
// x和y的方向向量
int dx[8] = {0, 0, -2, 2};
int dy[8] = {2, -2, 0, 0};
int n,m;
bool vis[N][N];

void check(int r, int c){
    for(int i=0; i<4; i++){
        int nr = r+dx[i];
        int nc = c+dy[i];
        //判断是否出界，是否访问过
        if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]){
            vis[nr][nc] = false;
        }
    }
}

int main(){
    while(cin >> m >> n){
        if( m<1 || n<1 || m>1000 || n > 1000)
            exit(0);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                vis[i][j] = true;
            }
        }


        // 枚举每个点，判断是否访问过
        int pocket = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]){
                    pocket++;
                    check(i,j);
                }
            }
        }
        cout << pocket << endl;
    }
    return 0;
}


