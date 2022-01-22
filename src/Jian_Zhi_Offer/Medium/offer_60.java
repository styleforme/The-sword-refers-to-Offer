package Jian_Zhi_Offer.Medium;

import java.util.Arrays;
import java.util.Scanner;

//n个骰子的个数
public class offer_60 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double res[] = new double[6];
        //调用处理函数
        res = dicesProbability(n);
        //输出结果
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.println(res[res.length - 1]);
    }

    /**
     * 求骰子个数函数
     *
     * @param n
     * @return
     */
    public static double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
//时间复杂度: O(n^2)
//空间复杂度: O(n)
