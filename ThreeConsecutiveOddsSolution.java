package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * 存在三个连续奇数的数组
 *
 * n & 1 和 n % 2 效果一样
 * 1000 & 0001 = 0000
 * 1001 & 0001 = 0001
 * 只有两数同时为 1 时，结果才为 1
 */
public class ThreeConsecutiveOddsSolution {

    public boolean threeConsecutiveOdds(int[] arr){
        int n = arr.length;

        for(int i=0; i<n; i++){
            if((arr[i] & 1) != 0 && (arr[i+1] & 1) != 0 && (arr[i+2] & 1) != 0 )
                return true;
        }
        return false;
    }

    @Test
    public void test(){
        boolean result = threeConsecutiveOdds(new int[]{2,6,4,1});
    }
}
