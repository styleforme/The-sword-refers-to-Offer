package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//剪绳子2
public class offer_14_2 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(cuttingRope(n));
    }

    /**
     * 剪绳子
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n < 4) return n - 1;
        if (n == 4) return n;
        long res = 1L;
        int mod = 1000000007;
        while (n > 4) {
            res = res * 3 % mod;
            n = n - 3;
        }
        res = res * n % mod;
        return (int) res;
    }
}
//时间复杂度: O(1)
//空间复杂度: O(1)