package com.cqyc.solution.paixu;

import java.util.Arrays;

/**
 * 归并排序，（分治算法）
 * @author cqyc
 * @create 2023-06-07-15:02
 */
public class GuiBingPx {

    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //左序列指针
        int j = mid + 1; //有序列指针
        int t = 0; //临时数组指针
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //将剩余左边元素填充进临时队列
        while(i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        //将剩余右边元素填充进临时队列
        while(j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        t = 0;
        while(left <= right) {
            arr[left] = temp[t];
            left++;
            t++;
        }
    }

    public static void main(String[] args) {
        GuiBingPx guiBingPx = new GuiBingPx();
        int []arr = {9,8,7,6,5,4,3,2,1};
        guiBingPx.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
