package com.cqyc.solution.other;

import java.util.*;

/**
 * @author cqyc
 * @create 2022-12-15-11:52
 */
public class TreeBuildTree_105 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right) {
            return null;
        }
        //前序遍历的根结点
        int preorder_root = preorder_left;
        //中序遍历找到根结点的下标
        Integer inorder_root = map.get(preorder[preorder_root]);
        //构建根节点
        TreeNode treeNode = new TreeNode(preorder[preorder_root]);
        //得到左子树的节点数目
        int size_left_subTree = inorder_root - inorder_left;
        //
        treeNode.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subTree,
                inorder_left, inorder_root - 1);

        treeNode.right = myBuildTree(preorder, inorder, preorder_left + size_left_subTree + 1, preorder_right,
                 inorder_root + 1, inorder_right);
        return treeNode;
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
