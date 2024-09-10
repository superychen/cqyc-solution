package com.cqyc.solution.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cqyc
 * @create 2022-12-15-19:28
 */
public class NumCombine_77 {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.myCombine(n, k, 1);
        return result;
    }

    public void myCombine(int n, int k, int startIndex) {
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            myCombine(n, k, i + 1);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        NumCombine_77 numCombine = new NumCombine_77();
        List<List<Integer>> combine = numCombine.combine(4, 2);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println("--");
        }
    }
}
