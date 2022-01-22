package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//机器人的运动范围
public class offer_13 {
    static int ans = 0;

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean flag[][] = new boolean[m][n];
        dnf(m, n, flag, 0, 0, k);
        System.out.println(ans);
    }

    /**
     * dnf
     *
     * @param m
     * @param n
     * @param flag
     * @param i
     * @param j
     * @param k
     */
    public static void dnf(int m, int n, boolean[][] flag, int i, int j, int k) {
        if (i >= m || i < 0 || j >= n || j < 0 || flag[i][j])
            return;
        int count = sum(i) + sum(j);
        if (count > k)
            return;
        flag[i][j] = true;
        ans++;
        dnf(m, n, flag, i + 1, j, k);
        dnf(m, n, flag, i - 1, j, k);
        dnf(m, n, flag, i, j + 1, k);
        dnf(m, n, flag, i, j - 1, k);
    }

    /**
     * 计算数位和
     *
     * @param n
     * @return
     */
    public static int sum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n % 10;
            n = n / 10;
        }
        return ans;
    }
}
//时间复杂度: O(mn)
//空间复杂度: O(mn)