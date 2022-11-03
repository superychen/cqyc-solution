package com.cqyc.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author cqyc
 * @create 2022-10-27-11:39
 */
public class TreeCengXuList_429 {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> resTemp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if(cur != null ) {
                    resTemp.add(cur.val);
                    if(cur.children != null) {
                        for (Node temp : cur.children) {
                            queue.offer(temp);
                        }
                    }
                }
            }
            res.add(resTemp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeCengXuList_429 test = new TreeCengXuList_429();
        test.levelOrder(new Node());
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
