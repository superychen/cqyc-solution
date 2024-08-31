package com.cqyc.solution.other;

/**
 * @author cqyc
 * @create 2022-10-14-10:54
 */
public class SearchMatrix_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int leftIndex = 0;
        int rightIndex = matrix[0].length - 1;
        int key;
        while (leftIndex <= matrix.length - 1 && rightIndex >= 0) {
            key = matrix[leftIndex][rightIndex];
            if(key > target) {
                rightIndex--;
            } else if (key < target) {
                leftIndex++;
            }else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] ints = {{1,4,7,11,15}, {2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}, {18,21,23,26,30}};
        int[][] intkey = {{-1, 3}};

        SearchMatrix_240 main = new SearchMatrix_240();
        System.out.println(main.searchMatrix(intkey, 3));

    }





}
