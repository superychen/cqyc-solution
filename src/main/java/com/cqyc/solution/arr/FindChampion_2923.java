package com.cqyc.solution.arr;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 找到冠军
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。
 * 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：
 * 如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
 * 返回这场比赛中将会成为冠军的队伍。
 */
public class FindChampion_2923 {

    public int findChampion(int[][] grid) {

        LinkedList<Integer> list = new LinkedList<>();

        //这个i就是第几队
        for (int i = 0; i < grid.length; i++) {
            list.add(i);
            for (int j = 0; j < grid[i].length; j++) {
                if(i == j) {
                    continue;
                }
                if(grid[i][j] != 1) {
                    list.removeLast();
                    break;
                }
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {

        String str = "-12*34";
//        String str = "*-1234";
        char[] chars = str.toCharArray();
        if(chars.length == 0) {
            System.out.println("111");
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(i == 0 && aChar == '-') {
                res.append("-");
            }
            if (aChar >= '0' && aChar <= '9') {
                res.append(aChar);
            }
        }
        System.out.println("res = " + Integer.parseInt(res.toString()));

//        FindChampion_2923 test = new FindChampion_2923();
//        int[][] ints = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
//        System.out.println("res = " + test.findChampion(ints));
    }

}
