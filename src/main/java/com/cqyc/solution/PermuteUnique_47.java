package com.cqyc.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cqyc
 * @create 2023-01-09-16:40
 */
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯 👍 1260 👎 0
public class PermuteUnique_47 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        this.permuteUniqueTwo(nums, 0);
        return res;
    }

    public void permuteUniqueTwo(int[] nums, int dix) {
        if(dix == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            path.addLast(nums[i]);
            vis[i] = true;
            permuteUniqueTwo(nums, dix + 1);
            vis[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteUnique_47 test = new PermuteUnique_47();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = test.permuteUnique(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
