package com.cqyc.solution.arr;

/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
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
