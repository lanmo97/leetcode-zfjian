package cn.ouc.jeff.leetcode;

import org.junit.Test;

/**
 * 转置矩阵
 */
public class TransposeSolution {

    public int[][] transpose(int[][] A) {

        int M = A.length;
        int N = A[0].length;
        if(M == N){
            for(int i=0; i<M; i++){
                for(int j=i+1;j<N; j++){
                    int temp = A[i][j];
                    A[i][j] = A[j][i];
                    A[j][i] = temp;
                }
            }
            return A;
        }else{
            int[][] B = new int[N][M];
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    B[j][i] = A[i][j];
                }
            }
            return B;
        }
    }

    @Test
    public void test(){
        int[][] result = transpose(new int[][] {{1,2,3},{4,5,6}});
        for(int i=0;i<result.length;i++)
            for(int j=0;j<result[i].length;j++)
                System.out.print(result[i][j]+" ");
            System.out.println();

    }
}
