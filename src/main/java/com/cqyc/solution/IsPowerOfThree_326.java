package com.cqyc.solution;

/**
 * @author cqyc
 * @create 2022-09-22-15:01
 */
public class IsPowerOfThree_326 {

    public boolean isPowerOfThree(int n) {
//        while(n % 3 == 0) {
//            n = n / 3;
//            if(n == 1) {
//                return true;
//            }
//        }
//        return false;



        return 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int num = 3;
        for (int i = 0; i < 999; i++) {
            if((long) num * 3 > max) {
                break;
            }
            num = num * 3;
        }
        System.out.println(num);
    }


}
