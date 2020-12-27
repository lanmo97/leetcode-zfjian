package cn.ouc.jeff.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 思路：
 * 1、只关注最后一个玩家即可
 * 如果最后一个玩家的同一行或同一列或对角线上有三个或三个以上相同元素则最后一个玩家获胜
 * 至于最后一个玩家到底是A还是B可以通过判断索引是奇数还是偶数还确定到底是哪个玩家
 * 2、最后一个玩家没有获胜的情况
 * 此时检查一下方格是否已经被填满了，如果填满了说明是平局
 * 如果没有填满说明游戏还未结束
 *
 */
public class TictactoeSolution {

    public String tictactoe(int[][] moves){

/*
        int C = moves.length;
        if(C <= 4) return "Pending";

        int[][] A = new int[(C+1)/2][2];
        int[][] B = new int[C/2][2];

        int aSumX=0, bSumX = 0;
        int aSumY=0, bSumY = 0;
        int k=0;
        for(int i=0; i<C; i=i+2){
            A[k] = moves[i];
            k++;
            aSumX += moves[i][0];
            aSumY += moves[i][1];
        }
        if(aSumX == 3 &&(aSumY == 0 || aSumY == 3 || aSumY==6)) return "A";

        if(aSumY == 3 &&(aSumX == 0 || aSumX == 3 || aSumX==6)) return "A";

        for(int j=1; j<C; j=j+2){
            bSumX += moves[j][0];
            bSumY += moves[j][1];
        }
        if(bSumX == 3 &&(bSumY == 0 || bSumY == 3 || bSumY==6)) return "B";
        if(bSumY == 3 &&(bSumX == 0 || bSumX == 3 || bSumX==6)) return "B";

        if(C == 9) return "Draw";

        return "Pending";
*/

        // 同一行
        int rowCounter = 0;
        // 同一列
        int colCounter = 0;
        // 主对角线
        int mainCounter = 0;
        // 副对角线
        int subCounter = 0;
        int key = (moves.length - 1) % 2;
        int[] last = moves[moves.length - 1];
        int he = last[0] + last[1];
        int cha = last[0] - last[1];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == key) {
                int[] move = moves[i];
                if (move[0] == last[0]) {
                    rowCounter++;
                }
                if (move[1] == last[1]) {
                    colCounter++;
                }
                if (move[0] + move[1] == he) {
                    subCounter++;
                }
                if (move[0] - move[1] == cha) {
                    mainCounter++;
                }
            }
        }
        if (rowCounter >= 3 || colCounter >= 3 || mainCounter >= 3 || subCounter >= 3) {
            return key == 0 ? "A" : "B";
        }
        // 格子未填满并且未分出胜负的情况
        if (moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }

    public String tictactoe2(int[][] moves){
        int C = moves.length;

        // 只需要考虑最后一步棋和前面的是否能够组成一个三连
        int[] last = moves[C-1];

        int row =0, col=0, main=0, sub=0;

        int index = C-1;
        while (index >= 0){
            int current[] = moves[index];
            if(current[1] == last[1])   row++;
            if(current[0] == last[0])   col++;
            if(current[0] == current[1]) main++;
            if(current[0] + current[1] == 2) sub++;
            index -= 2;
        }
        if(row>=3 || col>=3 || main>=3 || sub>=3){
            return C%2 == 0? "B":"A";
        }
        if(C < 9) return "Pending";
        return "Draw";
    }
    @Test
    public void test(){
        //[[0,0],[2,0],[1,1],[2,1],[2,2]]
        //[[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]

        int[][] moves = {{0,0}, {2,0}, {1,1}, {2,1}, {2,2}};
        System.out.println(tictactoe2(moves));
    }
}
