package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//青蛙跳台阶问题
public class offer_10_2 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numWays(n));
    }

    /**
     * 求一共有多少跳法
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {
        //动态规划
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)