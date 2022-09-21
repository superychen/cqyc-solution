package com.cqyc.solution;

import java.util.Random;

/**
 * @author cqyc
 * @create 2022-09-21-16:52
 */
public class ScrambleTheArray_384 {

    int[] tempResetNum;
    Random random;

    public ScrambleTheArray_384(int[] nums) {
        tempResetNum = nums;
        random = new Random();
    }

    public int[] reset() {
        return tempResetNum;
    }

    public int[] shuffle() {
        if(tempResetNum == null) {
            return null;
        }
        int[] resTemp = tempResetNum.clone();
        for (int i = 1; i < resTemp.length; i++) {
            int randomInt = random.nextInt(i + 1);
            swap(resTemp, i, randomInt);
        }
        return resTemp;
    }

    private void swap(int[] a, int i, int random) {
        if(i != random) {
            int temp = a[i];
            a[i] = a[random];
            a[random] = temp;
        }
    }
}
