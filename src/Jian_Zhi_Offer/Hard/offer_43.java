package Jian_Zhi_Offer.Hard;

import java.util.Scanner;

//1-n中1出现的次数
public class offer_43 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入n
        int n = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(countDigitOne(n));
    }

    /**
     * 求出现次数
     *
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        //cur 当前位 ；low 低位 ；high 高位 digit 位因子
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}

//时间复杂度: O(logn)
//空间复杂度: O(1)