package com.cqyc.solution.arr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: CQYC
 * @date: 2024-08-28-11:42
 */
public class 二叉树的锯齿形层序遍历_103 {


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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resInts = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOrderLeft = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> res = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(isOrderLeft) {
                    res.offerLast(node.val);
                } else {
                    res.offerFirst(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            resInts.add(res);
            isOrderLeft = !isOrderLeft;
        }
        return resInts;
    }

}
