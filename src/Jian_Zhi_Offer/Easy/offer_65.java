package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//不用加减乘除做加法
public class offer_65 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入a,b
        int a = sc.nextInt();
        int b = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(add(a, b));
    }

    /**
     * 做加法
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        while (b != 0) {
            //进位
            int c = (a & b) << 1;
            //非进位和
            a ^= b;
            b = c;
        }
        return a;
    }
}

//时间复杂度: O(1)
//空间复杂度: O(1)