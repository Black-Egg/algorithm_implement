/**
 * 动态规划路径
 * 
 * 豚厂开发了一个酒店客服机器人，机器人要送水到客人房间，此时机器人在一个M X N网格的左上角，
 * 客人房间在网格右下角，这个机器人在任意点只能向下或向右移动一步，机器人要把水送到客人房间，有多少种可能的唯一路径？
 * 
 * 说明：
 * 
 *  网格中的障碍物和空位置分别用 1 和 0 来表示。
 *  
 *  M 和 N 的值均不超过 100。
 * 
 * 输入
 *  第一行输入网格的长宽M和N；
 *  第二行至M+1行,输入障碍物和空位，以空格分开。
 * 
 * 输出
 *  机器人在给定网格上可能的路径数。
 * 
 * 样例输入
 * 
 * 3
 * 3
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 样例输出
 * 
 * 2
 * 
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PathPlans {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static int DynamicPathPlanning(int[][] matrixGrid) {
        int row = matrixGrid.length;
        int col = matrixGrid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for(int i = 0; i < row + 1; i++){
            for(int j = 0; j < col + 1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        dp[1][1] = 1;

        for(int i = 1; i < row + 1; i++){
            for(int j = 1; j < col + 1; j++){
                if(i > 0 && j > 0 && matrixGrid[i-1][j-1] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = Math.max(dp[i-1][j] + dp[i][j-1], dp[i][j]);
            }
        }
        for(int[] i : dp){
            System.out.println(Arrays.toString(i));
        }
        
        return dp[row][col];
    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
    
        int _matrixGrid_rows = 0;
        int _matrixGrid_cols = 0;
        _matrixGrid_rows = Integer.parseInt(in.nextLine().trim());
        _matrixGrid_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] _matrixGrid = new int[_matrixGrid_rows][_matrixGrid_cols];
        for(int _matrixGrid_i=0; _matrixGrid_i<_matrixGrid_rows; _matrixGrid_i++) {
            for(int _matrixGrid_j=0; _matrixGrid_j<_matrixGrid_cols; _matrixGrid_j++) {
                _matrixGrid[_matrixGrid_i][_matrixGrid_j] = in.nextInt();
                
            }
        }
        
        if(in.hasNextLine()) {
          in.nextLine();
        }
  
        res = DynamicPathPlanning(_matrixGrid);
        System.out.println(String.valueOf(res));    

    }
}
