package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * leetcode 806.写字符串需要的行数
 */
public class NumberOfLinesSolution {

    public int[] numberOfLines(int[] widths, String S){

        // 记录行数
        int lines = 1;
        // 记录最后一行宽度单位
        int last = 0;

        char[] sChar = S.toCharArray();

        for(char s: S.toCharArray()){
            last += widths[s-'a'];
            if(last > 100){
                lines++;
                last = widths[s-'a'];
            }
        }
        return new int[]{lines, last};
    }

    @Test
    public void Test(){
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "bbbcccdddaaa";


        int[] result = numberOfLines(widths, S);

        System.out.println(result[0]+", "+result[1]);
    }
}
