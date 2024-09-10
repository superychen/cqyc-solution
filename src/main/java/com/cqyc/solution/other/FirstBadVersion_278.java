package com.cqyc.solution.other;

/**
 * @author cqyc
 * @create 2022-09-19-09:37
 */
public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;

//        while(start < end) {
//            int mid = (end - start) / 2 + start;
//            if(!isBadVersion(mid)) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
//        }
        return start;
    }



}
