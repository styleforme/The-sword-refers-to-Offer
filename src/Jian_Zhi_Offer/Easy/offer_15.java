package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

// 二进制中1的个数
public class offer_15 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(hammingWeight(n));
    }

    /**
     * 求二进制1的个数的函数
     */

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //按位与
            count += n & 1;
            //无符号右移一位
            n >>>= 1;
        }
        return count;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1）