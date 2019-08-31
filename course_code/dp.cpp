    #include"cstdio"
    #include"cstdlib"
    #include"cstring"
    #include"algorithm"
    #include"iostream"
    using namespace std;
    const int N=105;
    int data[N][N];
    int ans=0;
    int main()
    {
        int n;
        scanf("%d",&n);
        memset(data,0,sizeof(data));  //初始化为0
        for(int i=1;i<=n;i++)
          for(int j=1;j<=2*i-1;j++)
             cin>>data[i][j];
        for(int i=1;i<=n;i++)
          for(int j=1;j<=i;j++)
          {
              data[i][j]+=max(data[i-1][j],data[i-1][j-1]);  //动态转移方程
              if(data[i][j]>ans)
                 ans=data[i][j];
          }
        cout<<ans<<endl;
        return 0;
    }
