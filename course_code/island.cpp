#include <iostream>
using namespace std;
const int N = 100;
int mp[N][N];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int n,m;
bool vis[N][N];

void dfs(int r, int c){
    vis[r][c] = true;
    for(int i=0; i<4; i++){
        int nr = r+dx[i];
        int nc = c+dy[i];
        if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && mp[nr][nc]==1){
            dfs(nr,nc);
        }
    }
}

int main(){
    while(cin >> m >> n){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                cin >> mp[i][j];
                vis[i][j] = false;
            }
        }
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mp[i][j]==1 && !vis[i][j]){
                    res++;
                    dfs(i,j);
                }
            }
        }
        if(res == 1)
            cout<< "Yes" << endl;
        else
            cout << "No" << endl;
    }
    return 0;
}
