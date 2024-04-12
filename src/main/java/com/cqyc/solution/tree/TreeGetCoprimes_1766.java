package com.cqyc.solution.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * todo 没做出来！！
 * 互质树
 * 给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 号点。
 *
 * 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节点 uj 和节点 vj 在树中有一条边。
 *
 * 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。
 *
 * 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。
 *
 * 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 ，如果不存在这样的祖先节点，ans[i] 为 -1 。
 */
public class TreeGetCoprimes_1766 {



    public int[] getCoprimes(int[] nums, int[][] edges) {
        if(nums.length <= 1) {
            return new int[]{-1};
        }
        Map<Integer, Integer> parentDexMap = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            for (int index = 0; index < edges[i].length; index++) {
                //找到num数组的下标
                int numDex = edges[i][index];
                if(index > 0) {
                    parentDexMap.put(numDex, edges[i][index - 1]);
                }
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //找到父亲节点
            Integer parentIndex = parentDexMap.get(i);
            int result = -1;
            while(parentIndex != null) {
                //祖先节点的值
                int parentNum = nums[parentIndex];
                int gcdRes = computeGCD(parentNum, nums[i]);
                if(gcdRes == 1) {
                    result = parentIndex;
                    break;
                }

                //一直卡着找父节点
                parentIndex = parentDexMap.get(parentIndex);
            }
            ans[i] = result;
        }

        return ans;
    }

    public int computeGCD(int a, int b) {
        if (a < 0 || b < 0) {
            // 数学上不考虑负数的约数
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1}, {0,2}, {1,3}, {1,4}, {2,5}, {2,6}};
        int[] nums = new int[]{5,6,10,2,3,6,15};
        TreeGetCoprimes_1766 test = new TreeGetCoprimes_1766();
        int[] coprimes = test.getCoprimes(nums, edges);
        for (int coprime : coprimes) {
            System.out.println("coprime = " + coprime);
        }


    }

}
