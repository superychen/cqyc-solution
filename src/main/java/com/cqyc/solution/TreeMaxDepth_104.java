package com.cqyc.solution;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cqyc
 * @create 2022-09-15-13:42
 */
public class TreeMaxDepth_104 {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int i = maxDepth(root.left) + 1;
        int j = maxDepth(root.right) + 1;
        return Math.max(i, j);
    }

    public int maxDepthTwo(TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }

    //广度
    public int maxDepth_BFS(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode pop = queue.pop();
                if(pop.left != null) {
                    queue.addLast(pop.left);
                }
                if(pop.right != null) {
                    queue.addLast(pop.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        TreeMaxDepth_104 depth = new TreeMaxDepth_104();
//        System.out.println(depth.maxDepth(treeNode));
        System.out.println(depth.maxDepthTwo(treeNode));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
