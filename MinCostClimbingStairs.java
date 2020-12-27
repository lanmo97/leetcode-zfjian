package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * 使用最小话费爬楼梯
 *
 * 动态规划！
 *
 *
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost){
        /*
        int result1 =cost[0];
        int result2 =cost[1];
        int C = cost.length;
        for(int i=0; i<C-1;){
            if(i+1 <= C-1 && i+2 <= C-1){
                result1 += Math.min(cost[i+1], cost[i+2]);
                i = cost[i+1] >= cost[i+2] ? i+2:i+1;
            }else{
                break;
            }
        }

        for(int j=1; j<C-1;){
            if(j+1 <= C-1 && j+2 <= C-1){
                result2 += Math.min(cost[j+1], cost[j+2]);
                j = cost[j+1] >= cost[j+2] ? j+2:j+1;
            }else{
                break;
            }
        }

        return result1 > result2 ? result2:result1;

         */
        /*
        int C = cost.length;
        int i=0;
        int result = 0;
        if(C >= 3){
            while (i+2<C){
                if(cost[i] + cost[i+2] <= cost[i+1]){
                    result = result+cost[i]+cost[i+2];
                    i = i+2+1;
                }else {
                    result = result + cost[i+1];
                    i = i+1+1;
                }
            }
            return result;
        }else {
            return Math.min(cost[0],cost[1]);
        }

 */

        // 到第 n  层需要从 n-1 或者 n-2， 那就找 n-1 或者 n-2 累计花费最少的
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0]=dp[1]=0;
        for(int i=2; i<=n; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
