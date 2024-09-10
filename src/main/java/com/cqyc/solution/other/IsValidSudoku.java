package com.cqyc.solution.other;

/**
 * 有效的数独
 *
 */
public class IsValidSudoku {

    /**
     * 有效的数独
     * 这里最重要的两步
     * 计算下标： board[i][j] - '0' - 1;
     * 计算1-9分块的区域值： (i / 3) * 3 + j / 3;
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int[][] line = new int[length][length];
        int[][] row = new int[length][length];
        int[][] cell = new int[length][length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //判断是不是'.', 如果是就跳过
                if(board[i][j] == '.') {
                    continue;
                }
                //计算存储在line、row、cell下标值
                int index = board[i][j] - '0' - 1;
                //计算在1-9分块的区域
                int k = (i / 3) * 3 + j / 3;
                //直接判断了
                if(line[i][index] != 0 || row[j][index] != 0 || cell[k][index] != 0) {
                    return false;
                }
                line[i][index] = row[j][index] = cell[k][index] = 1;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] class_score={{10, 99, 99, 5},{100, 98, 97, 2},{100, 100, 99, 5},{99,99,98,5}};
        System.out.println(class_score.length);

        IsValidSudoku twoNumberSum = new IsValidSudoku();
//        twoNumberSum.isValidSudoku(class_score);

//        System.out.println(3 - '0' - 1);
        System.out.println('1' - '0' - 1);


    }


}
