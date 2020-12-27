package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 翻转图像
 *
 * for 循环长度需要过半
 * ^: 相对应位 值相同，则为0；不同则为 1。
 * n ^ 1: n 为1，结果为 0； n 为 0，结果为 1
 */
public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A){
        for(int i=0; i<A.length; i++){
            int low = 0, high = A[i].length-1;
            while(low<=high){
                int temp = A[i][low];
                A[i][low] = A[i][high];
                A[i][high] = temp;

                if(A[i][low] == 1)
                    A[i][low] = 0;
                else
                    A[i][low] = 1;

                if(low != high){
                    if(A[i][high] == 1)
                        A[i][high] = 0;
                    else A[i][high] = 1;
                }

                low++;
                high--;
            }
        }

        return A;
    }

    public int[][] flipAndInvertImage2(int[][] A){
        int C = A[0].length;

        for(int[] row: A){
            for(int i=0; i<(C+1)/2; i++){
                int temp = row[i] ^ 1;
                row[i] = ~row[C-1-i] ^ 1;
                row[C-1-i] = temp;
            }
        }
        return A;
    }
    @Test
    public void test(){
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};

        System.out.println(flipAndInvertImage2(A));
    }
}
