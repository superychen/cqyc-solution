package com.cqyc.solution;

/**
 * @author cqyc
 * @create 2022-11-03-10:59
 */
public class InvertTree_226 {

    public class TreeNode {
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


    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

}
