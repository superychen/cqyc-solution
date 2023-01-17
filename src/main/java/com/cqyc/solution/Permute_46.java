package com.cqyc.solution;

import java.util.ArrayList;
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
