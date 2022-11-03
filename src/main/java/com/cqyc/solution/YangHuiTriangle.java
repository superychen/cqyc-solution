package com.cqyc.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cqyc
 * @create 2022-09-26-09:13
 */
public class YangHuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) {
            return res;
        }
        if(numRows == 1) {
            res.add(Arrays.asList(1));
            return res;
        }
        if(numRows == 2) {
            res.add(Arrays.asList(1, 1));
            return res;
        }
        res.add(Arrays.asList(1));
        res.add(Arrays.asList(1, 1));

        for (int i = 2; i < numRows; i++) {
            List<Integer> list = res.get(i - 1);
            List<Integer> nowList = new ArrayList<>();
            nowList.add(1);
            for (int j = 0; j < list.size(); j++) {
                if (list.size() > (j + 1)) {
                    nowList.add(list.get(j) + list.get(j + 1));
                }
            }
            nowList.add(1);
            res.add(nowList);
        }
        return res;

    }

    public static void main(String[] args) {

        YangHuiTriangle yangHuiTriangle = new YangHuiTriangle();
        List<List<Integer>> generate = yangHuiTriangle.generate(5);
        for (List<Integer> list : generate) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println("---");
        }
    }


}
