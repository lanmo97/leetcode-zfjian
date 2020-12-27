package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class SortedSquaresSolution {

    public int[] sortedSquares(int[] A){
        int n = A.length;
        int negative = -1;

        /*
        for (int i = 0; i < n; ++i) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }*/
        negative = bsearch(A, n, 0);

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    public int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + ((high-low) >> 1);

            if(a[mid] >= value){
                if((mid == 0) || (a[mid-1] < value)) return mid;
                else{
                    high = mid-1;
                }
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] result = sortedSquares(new int[]{-7,-3,3,3,11,14,16,35,56});
        for(int x: result)
            System.out.println(x);
    }
}
