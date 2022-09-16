package com.cqyc.solution;

/**
 * 验证二叉搜索树
 * @author cqyc
 * @create 2022-09-16-11:05
 */
public class IsValidBST_98 {

    public boolean isValidBST(TreeNode root) {
//        if(root == null ) {
//            return true;
//        }
//        if(root.left != null && root.val <= root.left.val) {
//            return false;
//        }
//        if(root.right != null && root.val >= root.right.val ) {
//            return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
        return isValidBSTNum(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTNum(TreeNode root, long minValue, long maxValue) {
        if(root == null) {
            return true;
        }
        if(root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBSTNum(root.left, minValue, root.val) && isValidBSTNum(root.right, root.val, maxValue);
    }

    TreeNode pre;
    public boolean isValidBSTTwo(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isValidBSTTwo(root.left)) {
            return false;
        }
        if(pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        if(!isValidBSTTwo(root.right)) {
            return false;
        }
        return true;
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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(7);
        IsValidBST_98 isValidBST_98 = new IsValidBST_98();
        System.out.println(isValidBST_98.isValidBST(treeNode));
    }
    
}
