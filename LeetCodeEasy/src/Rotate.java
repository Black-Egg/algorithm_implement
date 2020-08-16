class Solution {

    // 使用辅助数组的方案。时间复杂度O(n^2)，空间复杂度O(n^2)
    public int[][] rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                newMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = newMatrix[n - 1 - j][i];
            }
        }
    }

    // 不使用辅助数组的方案一，先转置（b[j][i] = a[i][j]），再水平翻转（b[i][j] = a[i][n - 1 -j]）
    // 时间复杂度O(n^2)，空间复杂度O(1)
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        int half = n/2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < half; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    // 不适用辅助数组的方案二：自外向内顺时针循环。
    // 自外向内一共有不超过 n/2 层（单个中心元素不算一层）矩形框。
    // 对于第 times 层矩形框，其框边长 len=nums−(times∗2)，
    // 将其顺时针分为 4 份 len−1 的边，对四条边进行元素的循环交换即可。
    public void rotate3(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return;
        int n = matrix.length;
        int times = 0;
        while (times <= n/2){
            int len = n - times * 2;
            for (int i = 0; i < len - 1; i++){
                int tmp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - 1 - i][times];
                matrix[times + len - 1 - i][times] = matrix[times + len - 1][times + len - 1 -i];
                matrix[times + len - 1][times + len - 1 - i] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = tmp;
            }
            times++;
        }
    }



}

public class Rotate{
    public static void main(String[] args){
        int[][]  matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution sol = new Solution();
        int[][] newMatrix = sol.rotate1(matrix);
        int n = newMatrix.length;
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}