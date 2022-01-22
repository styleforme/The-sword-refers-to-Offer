package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//圆圈中最后剩下的数字
public class offer_62 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入n,m
        int n = sc.nextInt();
        int m = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(lastRemaining(n, m));
    }

    /**
     * 求数字
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i != n + 1; i++) {
            x = (m + x) % i;
        }
        return x;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)
