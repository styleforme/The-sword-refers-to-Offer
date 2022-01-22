package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//丑数
public class offer_49 {
    //主函数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入n
        int n = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(nthUglyNumber(n));
    }

    /**
     * 求丑数
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        //dp[a]×2>dp[i−1]≥dp[a−1]×2
        //dp[b]×3>dp[i−1]≥dp[b−1]×3
        //dp[c]×5>dp[i−1]≥dp[c−1]×5
        int a = 0, b = 0, c = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (n2 == dp[i]) a++;
            if (n3 == dp[i]) b++;
            if (n5 == dp[i]) c++;
        }
        return dp[n - 1];
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)