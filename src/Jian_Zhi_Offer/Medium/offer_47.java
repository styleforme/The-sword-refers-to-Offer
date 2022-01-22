package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//礼物的最大值
public class offer_47 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组行
        int m = sc.nextInt();
        //输入数组列
        int n = sc.nextInt();
        //初始化数组
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        //调用处理函数并输出
        System.out.println(maxValue(arr));
    }

    /**
     * 求礼物最大值函数
     *
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    //base case
                    continue;
                } else if (i == 0 && j != 0) {
                    //为矩阵第一行元素，只可从左边到达
                    grid[i][j] += grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    //为矩阵第一列元素，只可从上边到达
                    grid[i][j] += grid[i - 1][j];
                } else {
                    //可从左边或上边到达
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        return grid[m - 1][n - 1];
    }
}

//时间复杂度: O(mn)
//空间复杂度: 0(1)