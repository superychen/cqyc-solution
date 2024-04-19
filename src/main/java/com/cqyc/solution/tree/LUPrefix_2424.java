package com.cqyc.solution.tree;

/**
 * @author: CQYC
 * @date: 2024-04-17-9:51
 *  2424. 最长上传前缀
 */
public class LUPrefix_2424 {

    int[] arr;
    int ans;

    public LUPrefix_2424(int n) {
        arr = new int[n + 2];
    }

    public void upload(int video) {
        arr[video] = 1;
    }

    public int longest() {
        while(arr[ans + 1] == 1) {
            ans++;
        }
        return ans;
    }

}
