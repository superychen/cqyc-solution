package com.cqyc.solution.other;

/**
 * @author cqyc
 * @create 2022-12-14-10:28
 */
public class TreeLowestCommonAncestor_236 {


    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        System.out.print(root.val + " ");
        boolean rson = dfs(root.right, p, q);
        //lson和rson都为空，p、q两个值找到了并且lson或者rson
        if((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left  = new TreeNode(5);
        root.left.left  = new TreeNode(6);
        root.left.right  = new TreeNode(2);
        root.left.right.left  = new TreeNode(7);
        root.left.right.right  = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        new TreeLowestCommonAncestor_236().lowestCommonAncestor(root, root, root);


    }

}
