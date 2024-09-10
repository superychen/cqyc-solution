package com.cqyc.solution.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵（模拟，清晰图解）
 *
 * 你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * @author cqyc
 * @create 2024-08-31-16:32
 */
public class 螺旋矩阵_54 {


    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new ArrayList<>();
        }
        //初始化左、右、上、下
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int b = matrix.length - 1;
        //下标值
        int index = 0;
        Integer[] res = new Integer[(right + 1) * (b + 1)];

        while(true) {
            //从左到右
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            //从左到右后，top + 1，如果大于下，就break
            if(++top> b) {
                break;
            }
            //从上到下
            for (int i = top; i <= b; i++) {
                res[index++] = matrix[i][right];
            }
            //从上到下过后，right - 1,如果小于左，就break
            if(--right < left) {
                break;
            }
            //从右到左
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[b][i];
            }
            //从右到左后，下 - 1，如果小于上，就break
            if(--b < top) {
                break;
            }
            //从下到上
            for (int i = b; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            //从下到上后，left + 1, 如果大于right，就break
            if(++left > right) {
                break;
            }
        }

        return Arrays.asList(res);
    }

    public List<Integer> spiralOrderTest(int[][] matrix) {
        return null;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        螺旋矩阵_54 test = new 螺旋矩阵_54();
        List<Integer> integers = test.spiralOrder(arr);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

}
