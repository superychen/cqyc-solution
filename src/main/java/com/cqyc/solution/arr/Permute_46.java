package com.cqyc.solution.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cqyc
 * @create 2023-01-10-15:33
 */
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 2358 👎 0
public class Permute_46 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        this.permuteTwo(nums, 0);
        return res;
    }

    public void permuteTwo(int[] nums, int dix) {
        if(dix == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]) {
                continue;
            }
            path.addLast(nums[i]);
            vis[i] = true;
            permuteTwo(nums, dix + 1);
            path.removeLast();
            vis[i] = false;
        }
    }


    /**
     * 第二种解法
     */
    public List<List<Integer>> permuteTwo(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //先把原数据添加到path中
        for (int num : nums) {
            path.add(num);
        }
        int n = nums.length;
        backTrack(n, path, res, 0);
        return res;
    }

    private void backTrack(int n, List<Integer> path, List<List<Integer>> res, int first) {
        //所有数都填完了
        if(first == n) {
            res.add(new ArrayList<>(path));
        }
        for (int i = first; i < n; i++) {
            //先交换一手
            Collections.swap(path, first, i);
            //递归
            backTrack(n, path, res, first + 1);
            //在交换回来，撤销
            Collections.swap(path, first, i);
        }

    }


    public static void main(String[] args) {
        Permute_46 test = new Permute_46();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = test.permute(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
