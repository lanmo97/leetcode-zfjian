package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * 分发糖果-贪心算法 局部最优解 （局部：递增部分/递减部分）
 * 12/24 每日打卡题
 */
public class CandySolution {

    public int candy(int[] ratings) {
        /* 未通过
        int cur = 1;

        for(int i=0; i<ratings.length-1; i++){
            if(ratings[i] < ratings[i+1]){
                ratings[i] = cur;
                ratings[i+1] = ratings[i] + 1;
            }else if(ratings[i] > ratings[i+1]){
                ratings[i+1] = cur;
                ratings[i] = ratings[i+1];
            }else{
                if(i > 0){
                    if(ratings[i] > ratings[i-1]){
                        ratings[i] = ratings[i-1]+1;
                        ratings[i+1] = ratings[i] -1;
                    }else {

                    }
                }
            }
        }*/
/* 未通过
        int C = ratings.length;
        int[] candyNumber = new int[C];
        for(int i=0; i<C; i++){
            if(((i-1<0) || (ratings[i] <= ratings[i-1])) &&( (i+1 >= C)|| (ratings[i] <= ratings[i+1]))){
                candyNumber[i] = 1;
            }
        }

        int lastOne = -1;
        for(int i=1; i<C; i++){
            if (candyNumber[i] != 1){
                if(i==C-1){
                    while(lastOne < C-1){
                        int num = lastOne+1;
                        candyNumber[num] = candyNumber[lastOne]+1;
                        lastOne++;
                    }
                }

            }else {
                int j=i-1;
                while (candyNumber[j] == 0) {
                    candyNumber[j] = candyNumber[j+1]+1;
                    j--;
                    if(j < 0) break;
                }
                lastOne = i;
            }
        }
        int result = 0;
        for(Integer a : candyNumber){
            result += a;
        }
        return result;

 */

        // 升序个数 ： inc 降序个数：dec
        // 一直升，一直加，pre 中个数可以理解为当前小孩分得糖果数量
        // 一直降，新增的小孩糖果数最少，dec 连续降序个数同样可以理解为新增一个小孩后，新增小孩给了一个，前面的小孩给dec个。
        // 此时只记录总数的变化，不在乎到底哪个小孩多少糖，总数是符合要求的。
        // 当两个小孩分数相等时，就先给后面的小孩一颗，骗骗他，他后面如果是递减，就再给他加回来；他后面递增，那他就只能1个了

        // 递减小孩（相同的小孩没分在递减，所以如果是递减，铁定他比前一个小孩糖要少）连续个数如果超过了前面的递增，递增的最后一个小孩，
        // 必须跟着递减的总数往上加。只需要记录这个糖总数就行，不必必须记录到这个小孩，所以只记录dec == inc 时，给dec 再多一个糖就行。
        // 最后结果呈现出来就是分支岭一个大一个小，不能相同。
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

    @Test
    public void test(){
        //System.out.println(candy(new int[]{1,0,2}));
        System.out.println(candy(new int[]{29,51,87,87,72,12}));
    }
}
