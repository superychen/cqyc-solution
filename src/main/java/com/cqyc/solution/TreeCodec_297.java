package com.cqyc.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cqyc
 * @create 2022-12-13-09:56
 */
public class TreeCodec_297 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> arrayList = new LinkedList<>(Arrays.asList(split));
        return reDeserialize(arrayList);
    }

    private String reSerialize(TreeNode root, String str) {
        if(root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = reSerialize(root.left, str);
            str = reSerialize(root.right, str);
        }
        return str;
    }

    private TreeNode reDeserialize(List<String> dataList) {
        if(dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        treeNode.left = reDeserialize(dataList);
        treeNode.right = reDeserialize(dataList);
        return treeNode;
    }


    public static void main(String[] args) {
        String str = "1,2,3,None,None,4,5";
        TreeCodec_297 tree = new TreeCodec_297();
//        TreeNode node = tree.deserialize(str);
//        System.out.println(node.val);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = tree.serialize(root);
        System.out.println("serialize = " + serialize);
    }



}
