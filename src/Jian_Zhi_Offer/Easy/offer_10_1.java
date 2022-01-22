package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//斐波那契数列
public class offer_10_1 {
    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(fib(n));
    }

    /**
     * 求f(n)
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        //动态规划
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1)