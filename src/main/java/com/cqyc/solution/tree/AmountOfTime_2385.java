package com.cqyc.solution.tree;

import java.util.*;

/**
 * 感染二叉树需要的总时间
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * <p>
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * <p>
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 */
public class AmountOfTime_2385 {


    /**
     * 深度优先搜索建图 + 广度优先搜索求感染时间
     * 需求出值为 start的节点到其他节点最远的距离。树中的最远距离可以用广度优先搜索来求解。但是 start不一定为根节点，
     * 我们需要先将树的结构用深度优先搜索解析成无向图，再用广度优先搜索来求最长距离。代码中 graph即为邻接表，用一个哈希表来表示。
     * 哈希表的键为节点值，值为其相邻节点的值组成的列表。建完表后用广度优先搜索求最长距离。
     *
     */
    public int amountOfTime(TreeNode root, int start) {
        //将节点中的父、子节点全部放在对应节点map中
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(graph, root);
        //再用广度遍历
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int time = 0;
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nodeVal = arr[0];
            time = arr[1];
            List<Integer> parentChildNodes = graph.get(nodeVal);
            for (Integer parentChildNode : parentChildNodes) {
                if(visited.add(parentChildNode)) {
                    queue.offer(new int[]{parentChildNode, time + 1});
                }
            }

        }
        return time;
    }

    private void  dfs(Map<Integer, List<Integer>> graph, TreeNode node) {
        graph.putIfAbsent(node.val, new ArrayList<>());
        for (TreeNode child : Arrays.asList(node.left, node.right)) {
            if(child != null) {
                graph.get(node.val).add(child.val);
                //往子节点在添加父节点
                graph.putIfAbsent(child.val, new ArrayList<>());
                graph.get(child.val).add(node.val);
                dfs(graph, child);
            }
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
