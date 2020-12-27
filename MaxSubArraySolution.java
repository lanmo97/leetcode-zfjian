package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * @ClassName MaxSubArraySolution
 * @Description 最大子序和（DY问题）
 * @Author Jeff_ZHU
 * @Date 2020/12/26 8:54 下午
 * @Version 1.0
 */
public class MaxSubArraySolution {
    /**
     * 状态转移方程： 当加入第 i 个数时，前面的子数组的和加[i] 与 当前数[i] 谁大要谁。
     */
    /**
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];

        for(int x : nums){
            pre = Math.max(pre + x, x);

            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
     */

    /*分治解法*/
    class Status {
        public int lSum, rSum, mSum, iSum;
        public Status(int lSum, int rSum, int mSum, int iSum){
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums){
        return getInfo(nums, 0, nums.length -1).mSum;
    }

    public Status getInfo(int[] a, int l, int r){
        if(l == r)
            return new Status(a[l], a[l], a[l], a[l]);
        int m = l+r >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m+1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r){
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum+r.lSum);
        int rSum = Math.max(r.rSum, r.iSum+l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum+r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    @Test
    public void test(){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
