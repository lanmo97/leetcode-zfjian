package cn.ouc.jeff.leetcode;

import org.junit.Test;

public class LargestTriangleAreaSolution {

    public double largestTriangleArea(int[][] points){

        int N = points.length;

        double ans = 0;

        for(int i=0; i<N; ++i)
            for(int j=i+1; j<N; ++j)
                for(int k=j+1; k<N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    public double area(int[] p, int[] q, int[] k){
        return 0.5 * Math.abs(p[0]*q[1] + q[0]*k[1] + k[0]*p[1]-p[1]*q[0]-q[1]*k[0]-k[1]*p[0]);
    }

    @Test
    public void test(){
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        double result = largestTriangleArea(points);
        System.out.println(result);
    }
}
