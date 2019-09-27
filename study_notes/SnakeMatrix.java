import java.util.Scanner;

/**
 * 
 * Problem蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。 

Input
本题有多组数据，每组数据由一个正整数N组成。（N不大于100） 

Output
对于每一组数据，输出一个N行的蛇形矩阵。两组输出之间不要额外的空行。 

矩阵三角中同一行的数字用一个空格分开。行尾不要多余的空格。 

Sample Input
5

Sample Output
1 3 6 10 15
2 5 9 14
4 8 13
7 12
11

 * 
 */


class Solution{
    public int[][] snakeMatrix(int n){
        int[][] matrix = new int[n][n];
        int num = 1;
        for(int i=0; i<n; i++){
            int j = 0;
            int k = i;
            while(k >= 0){
                matrix[k][j] = num;
                k--;
                num++;
                j++;
            }
        }
        return matrix;
    }
}


public class SnakeMatrix{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        
        int n = sc.nextInt();
        int[][] matrix = sol.snakeMatrix(n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i; j++){
                if(j == n-i-1)
                    System.out.println(matrix[i][j]);
                else
                    System.out.print(matrix[i][j] + " ");
            }
        }
    }
}