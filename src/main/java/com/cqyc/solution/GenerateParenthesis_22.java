package com.cqyc.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqyc
 * @create 2022-11-02-10:51
 */
public class GenerateParenthesis_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        _generate(0, 0, n, "", res);
        return res;
    }

    private void _generate(int left, int right, int n, String s, List<String> res) {
        if(left == n && right == n) {
            res.add(s);
            return;
        }
        //这里在判断对应括号合法性
        if(left < n) {
            _generate(left + 1, right, n, s + "(", res);
        }
        if(right < left) {
            _generate(left, right + 1, n,s + ")", res);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis_22 test = new GenerateParenthesis_22();
        test.generateParenthesis(3);
    }


}
