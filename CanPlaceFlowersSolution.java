package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * 种花问题 贪心算法最快
 */
public class CanPlaceFlowersSolution {

    public boolean canPlaceFlowers(int[] flowerbed, int n){

        int summary = 0; //求出的可种植的数，当大于n 时就返回true
        int cnt = 0; // 每一段连续0的数

        // 下标0处，值为 0，需要单独加一个。
        if(flowerbed[0] == 0) cnt++;

        for(int j=0; j<flowerbed.length; j++){

            if(flowerbed[j] == 0){
                cnt++;
            }

            // 下标为末尾处，值为 0，需要单独加一个。
            if(j+1 == flowerbed.length && flowerbed[j] == 0){
                cnt++;
            }

            // 计数结束：遇见不为0的数；或者到了末尾
            if(flowerbed[j] != 0 || j == flowerbed.length-1){
                if(cnt % 2 == 0)
                    summary = Math.max(summary+(cnt / 2) -1,0);
                else
                    summary = Math.max(summary + ((cnt+1) / 2-1),0);
                cnt = 0;
            }

            if(summary >= n)
                return true;
        }

        return false;
    }

    @Test
    public void test(){
        System.out.println(canPlaceFlowers(new int[]{0,0,0,0,0}, 3));
    }
}
