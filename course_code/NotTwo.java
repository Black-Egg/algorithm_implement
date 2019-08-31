import java.util.Scanner;
public class NotTwo{
    static int[] dx = {0, 0, -2, 2};
    static int[] dy = {2, -2, 0, 0};
    static boolean[][] vis = new boolean[1000][1000];
    static int n,m;

    public static void check(int r, int c){
         for(int i=0; i<4; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];
            //判断是否出界，是否访问过
            if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]){
                vis[nr][nc] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        if( m<1 || n<1 || m>1000 || n > 1000)
            System.exit(-1);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                vis[i][j] = true;
            }
        }

        int pocket = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]){
                    pocket++;
                    check(i,j);
                }
            }
        }
        System.out.println(pocket);
    }
}
