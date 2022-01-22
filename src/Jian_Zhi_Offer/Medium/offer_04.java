package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//二维数组中的查找
public class offer_04 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        int targer = sc.nextInt();
        System.out.println(findNumberIn2DArray(arr, targer));
    }

    /**
     * 查找
     *
     * @param arr
     * @param targer
     * @return
     */
    private static boolean findNumberIn2DArray(int[][] arr, int targer) {
        //双指针
        int i = arr.length - 1, j = 0;
        while (i >= 0 && j < arr[0].length) {
            if (arr[i][j] > targer) {
                i--;
            } else if (arr[i][j] < targer) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1)