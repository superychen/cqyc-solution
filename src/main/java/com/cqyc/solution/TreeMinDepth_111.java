package com.cqyc.solution;

/**
 * @author cqyc
 * @create 2022-12-12-09:34
 */
public class TreeMinDepth_111 {

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


    public int minDepth(TreeNode root) {
        return minDepthTwo(root, 1);
    }

    private int minDepthTwo(TreeNode root, int minVal) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return minVal;
        }
        int leftVal = minDepthTwo(root.left, minVal + 1);
        int rightVal = minDepthTwo(root.right, minVal + 1);
        if(leftVal == 0) {
            return rightVal;
        }
        if(rightVal == 0) {
            return leftVal;
        }
        return Math.min(leftVal, rightVal);
    }

    public static void main(String[] args) {

        //case 0
//        TreeNode treeNode = new TreeNode(3);
//        treeNode.left = new TreeNode(9);
//        treeNode.right = new TreeNode(20);
//        treeNode.right.left = new TreeNode(15);
//        treeNode.right.right = new TreeNode(7);

        //case 1
//        TreeNode treeNode = new TreeNode(2);
//        treeNode.right = new TreeNode(3);
//        treeNode.right.right = new TreeNode(4);
//        treeNode.right.right.right = new TreeNode(5);
//        treeNode.right.right.right.right = new TreeNode(6);

        //case 3
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);

        TreeMinDepth_111 treeMinDepth_111 = new TreeMinDepth_111();
        System.out.println(treeMinDepth_111.minDepth(treeNode));
    }

}
