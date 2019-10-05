import java.util.HashMap;

class Solution {

    // 方法一：三次遍历，分别去判断行、列、3*3子数独中没有重复的数字。
    public boolean isValidSudoku1(char[][] board) {
        // HashMap<Integer, Integer> row = new HashMap<>();
        // HashMap<Integer, Integer> column = new HashMap<>();
        // HashMap<Integer, Integer> box = new HashMap<>();
        
        HashMap<Integer, Integer> row;
        HashMap<Integer, Integer> column;
        HashMap<Integer, Integer> box;

        // 检查每一行是否有重复数字
        // 按行优先遍历
        for(int i=0; i<9; i++){
            row = new HashMap<>();
            for(int j=0; j<9; j++){
                char num = board[i][j];
                if(num != '.'){
                    int n = num - '0';
                    row.put(n, row.getOrDefault(n, 0) + 1);
                    if (row.get(n) > 1)
                    return false;
                }
            }
        }

        // 检查每一列是否有重复数字
        // 按列优先遍历
        for(int i=0; i<9; i++){
            column = new HashMap<>();
            for(int j=0; j<9; j++){
                char num = board[j][i];
                if(num != '.'){
                    int n = num - '0';
                    column.put(n, column.getOrDefault(n, 0) + 1);
                    if (column.get(n) > 1)
                    return false;
                }
            }
        }

        // 检查小方格是否有重复数字
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                box = new HashMap<>();
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        char num = board[i*3+k][j*3+l];
                        if(num != '.'){
                            int n = num - '0';
                            box.put(n, box.getOrDefault(n, 0) + 1);
                            if (box.get(n) > 1)
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // 一次遍历。同时判断行、列、3*3子数独中没有重复的数字。
    public boolean isValidSudoku2(char[][] board) {
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];

        for(int i=0; i<9; i++){
            rows[i] = new HashMap<Integer, Integer> ();
            columns[i] = new HashMap<Integer, Integer> ();
            boxes[i] = new HashMap<Integer, Integer> ();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char num = board[i][j];
                if(num != '.'){
                    int n = num - '0';
                    int boxIdx = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[boxIdx].put(n, boxes[boxIdx].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIdx].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}