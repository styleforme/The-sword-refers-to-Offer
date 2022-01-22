package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//数值的整数次方
public class offer_16 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(myPow(x, n));
    }

    /**
     * 处理函数
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (x == 0)
            return 0.0;
        long b = n;
        double res = 1.0;
        //如果n<0把问题转化至n≥0 的范围内
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        //
        while (b > 0) {
            //当 n 为奇数：会多出一项 xx
            if ((b & 1) == 1) res *= x;
            x *= x;
            //右移一位相对于除2
            b >>= 1;
        }
        return res;
    }
}


// 时间复杂度O(log2n)
// 空间复杂度O(1)

