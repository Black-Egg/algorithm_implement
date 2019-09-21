"""
基于邻接矩阵实现的图的搜索算法

"""

import java.util.Scanner;

class main {
    static int n;
    static  int m;
   static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int M=Integer.valueOf(input.split(",")[0]);
        int N=Integer.valueOf(input.split(",")[1]);
        n=M;
        m=N;
        int[][] grid=new int[M][N];
        for(int i=0;i<M;i++)
        {
            String str=sc.nextLine();
            String[] nums=str.split(",");
            for(int j=0;j<N;j++)
            {
                grid[i][j]=Integer.valueOf(nums[j]);
            }
        }
        int area=maxAreaOfIsland(grid);
        System.out.println(area);
    }
    public static  int maxAreaOfIsland(int[][] grid)

    {
        if(grid==null||grid.length==0)
            return 0;
        n=grid.length;
        m=grid[0].length;
        int maxArea=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                maxArea=Math.max(maxArea,DFS(grid,i,j));
            }
        return maxArea;
    }
    public static int DFS(int[][] grid,int i,int j)
    {
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0)
            return 0;
        int area=1;
        grid[i][j]=0;
        for(int[] d:directions)
        {
            int x=i+d[0];
            int y=j+d[1];
            area+=DFS(grid,x,y);
        }
        return area;
    }
}