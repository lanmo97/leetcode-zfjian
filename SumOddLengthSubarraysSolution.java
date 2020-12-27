package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 *  所有奇数长度的子数组的总和
 */
public class SumOddLengthSubarraysSolution {

    public int sumOddLengthSubarrays(int[] arr){

        int N = arr.length;
        int sum = 0;
        int s = 0;

        // 1. iterator all
        for(int i=0; i<N; i++){
            int left = i+1;
            int right = N-i;
            int leftEven = (left+1)/2;
            int leftOdd = left/2;
            int rightEven = (right+1)/2;
            int rightOdd = right/2;
            sum = sum + arr[i] * (leftEven*rightEven + leftOdd*rightOdd);
        }
        return sum;
    }

    @Test
    public void test(){
        int result = sumOddLengthSubarrays(new int[]{1,4,2,5,3});
        System.out.println(result);
    }
}
