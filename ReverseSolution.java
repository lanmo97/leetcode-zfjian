package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * @ClassName ReverseSolution
 * @Description 整数翻转
 * @Author Jeff_ZHU
 * @Date 2020/12/25 5:11 下午
 * @Version 1.0
 */
public class ReverseSolution {
    // Integer 类型最大值 2**31 -1 == 2147483647(Integer.MAX_VALUE); 最小值负数 -2**31(Integer.MIN_VALUE)
    public int reverse(int x){
        int ans = 0;
        int pop = 0;
        while(x != 0){  // x == 0时，取到了个位，他已经被取余拿到了
            pop = x %10; // 和10求余，得到末尾的一个数字
            x = x / 10; // 和10求整，得到除末尾外的前面的数字
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) return 0; // 正数，防溢出
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE /10 && pop < -8)) return 0; // 负数，防溢出
            ans = ans * 10 + pop; // 10倍的增大，代表着位的变化，每次挂上前面求得的余数
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MAX_VALUE%10);

        System.out.println(reverse(1534236469));
    }
}
