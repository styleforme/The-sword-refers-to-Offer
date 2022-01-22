package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//剪绳子1
public class offer_14_1 {
    /**
     * 主函数
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
        int a = n / 3;
        int b = n % 3;
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else if (b == 2) {
            return (int) Math.pow(3, a) * 2;
        }
        return (int) Math.pow(3, a);
    }
}
//时间复杂度: O(1)
//空间复杂度: O(1)