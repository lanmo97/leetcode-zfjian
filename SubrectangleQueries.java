package cn.ouc.jeff.leetcode;

/**
 * 子矩形查询
 * 就是一道 简单的将类方法进行实现的题目
 *
 * 给的测试用例比较迷，仔细分析是每执行一步返回的结果，当执行无返回值的语句时，返回 null
 */
public class SubrectangleQueries {

    private int[][] rectangle;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1; i<=row2; i++){
            for(int j=col1; j<=col2; j++){
                rectangle[i][j] = newValue;
            }
        }
/* col1 大小不可控
        for(;row1<row2+1;row1++) {
            for(;col1<col2+1;col1++){
                rectangle[row1][col1]=newValue;
            }
        } */
    }



    public int getValue(int row, int col) {

        return rectangle[row][col];
    }

    public static void main(String[] args){
        int[][] rectangle = new int[][]{{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries obj = new SubrectangleQueries(rectangle);

        // null

        // 1
        System.out.println(obj.getValue(0,2));

        // null
        obj.updateSubrectangle(0,0,3,2,5);

        // 5
        System.out.println(obj.getValue(0,2));

        // 5
        System.out.println(obj.getValue(0,1));

        obj.updateSubrectangle(3,0,3,2,10);

        // 10
        System.out.println(obj.getValue(3,1));

        // 5
        System.out.println(obj.getValue(0,2));

    }
}
