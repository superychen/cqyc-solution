package com.cqyc.solution.paixu;

/**
 * 希尔排序（O(n^(1.3-2))）
 * @author cqyc
 * @create 2023-06-05-10:05
 */
public class XiErPx {

    public void sort(int[] arr) {

        //定义gap为间距，起始为数组长度 / 2，必须大于0， 等于0的时候就是代表排序快要完成， 每次循环都在这个间距的基础上除2
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //然后定义i为间距的值，然后依次开始从间距加数了
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                //这里直接减去间距，然后依次开始判断是否两个值需要交换，不需要给予直接下一组数据判断
                while(j - gap >= 0 && arr[j] < arr[j-gap]) {
                    //交换值
                    swap(arr, j, j - gap);
                    j = j - gap;
                }
            }
        }

    }

    private void swap(int[] arr, int j, int gap) {
//        arr[j] = arr[j] + arr[gap];
//        arr[gap] = arr[j] - arr[gap];
//        arr[j] = arr[j] - arr[gap];
        int index = arr[j];
        arr[j] = arr[gap];
        arr[gap] = index;
    }

    public static void main(String[] args) {
        int[] test = new int[]{47, 29, 71, 99, 78, 19, 24, 47};
        XiErPx xiErPx = new XiErPx();
        xiErPx.sort(test);
        for (int i : test) {
            System.out.print(i + " ");
        }
    }

}
