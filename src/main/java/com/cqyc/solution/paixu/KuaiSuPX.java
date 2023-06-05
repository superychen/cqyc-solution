package com.cqyc.solution.paixu;

/**
 * O(n(logn))
 * 快速排序写法
 * @author cqyc
 * @create 2023-05-31-17:29
 */
public class KuaiSuPX {

    public void quickSort(int[] arr, int begin, int end) {
        if(begin >= end) {
            return;
        }
        //选取第一个值为起始点，进行后面排序
        int key = arr[begin];
        int i = begin;
        int j = end;
        while(i < j) {
            //第一次从后往前找，找到第一个比i下标大的数，找到之后j--
            while(i < j && arr[j] > key) {
                j--;
            }
            //找到之后将j下标的值赋值给i下标的值
            if(i < j) {
                arr[i] = arr[j];
                i++;
            }
            //然后从前往后找，找到比i下标小的数，然后i++
            while(i < j && arr[i] < key) {
                i++;
            }
            //将i的值赋值给j下标，然后j--
            if(i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        //最终第一次交换的i给key赋值
        arr[i] = key;
        //递归调用
        quickSort(arr, begin, i - 1);
        quickSort(arr, i + 1, end);
    }

    public static void main(String[] args) {

        int[] test = new int[]{47, 29, 71, 99, 78, 19, 24, 47};
        KuaiSuPX kuaiSuPX = new KuaiSuPX();
        kuaiSuPX.quickSort(test, 0, test.length - 1);
        for (int i : test) {
            System.out.print(i + " ");
        }
    }

}
