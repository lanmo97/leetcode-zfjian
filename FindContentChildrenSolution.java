package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 分发饼干- 贪心算法
 * 把尺寸最合适的饼干分给胃口正合适的小孩
 * 不浪费，能达到最多
 */
public class FindContentChildrenSolution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
/*
        int cur = 0;
        int max = 0;
        for(int i=0; i<g.length; i++){
            for(int j=cur; j<s.length; j++){
                if(s[j] >= g[i]){
                    s[j] = 0;
                    max++;
                    cur = j+1;
                    break;
                }
            }
        }

 */

        int max = 0;
        for (int i=0, j=0; i<g.length && j<s.length; ){
            if(g[i] <= s[j]){
                max++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return max;
    }

    @Test
    public void test(){
        //System.out.println(findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
