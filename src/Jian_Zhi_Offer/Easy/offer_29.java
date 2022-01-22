package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//顺时针打印矩阵
public class offer_29 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        //初始化数组
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        int ans[] = new int[m * n];
        //调用顺时针处理函数
        ans = spiralOrder(arr);
        //输出结果
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }

    /**
     * 顺时针打印数组
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int res[] = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // 左->右
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // 上->下
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // 右->左
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // 下->上
            if (++l > r) break;
        }
        return res;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1)