package com.cqyc.solution.guangdu_2309;

/**
 * @author cqyc
 * @create 2023-09-18-10:24
 */
public class NumsIsland_200 {

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private char[][] copyG;

    public int numIslands(char[][] grid) {
        int isLands = 0;
        copyG = grid;
        for (int i = 0; i < copyG.length; i++) {
            for (int j = 0; j < copyG[i].length; j++) {
                if(copyG[i][j] == '0') {
                    continue;
                }
                isLands = isLands + sink(i, j);
            }
        }
        return isLands;
    }

    private int sink(int i, int j) {
        if(copyG[i][j] == '0') {
            return 0;
        }
        copyG[i][j] = '0';
        for (int k = 0; k < dx.length; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && y >= 0 && x < copyG.length && y < copyG[i].length) {
                if(copyG[x][y] == '0') {
                    continue;
                }
                sink(x, y);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        NumsIsland_200 test = new NumsIsland_200();
        System.out.println(test.numIslands(grid));
    }





}
