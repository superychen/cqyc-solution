package com.cqyc.solution.other;

import java.util.Arrays;

/**
 * @author cqyc
 * @create 2022-08-31-22:34
 * 旋转图像，给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 */
public class RotatePic {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //上下交换
        for (int i = 0; i < length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //对角线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] class_score={{10, 99, 99, 5},{100, 98, 97, 2},{100, 100, 99, 5},{99,99,98,5}};
        System.out.println(class_score.length);
        System.out.println(Arrays.toString(class_score[0]));
        System.out.println(Arrays.toString(class_score[3]));
    }

}
