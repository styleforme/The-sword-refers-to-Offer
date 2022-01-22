package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//求1+2+...+n
public class offer_64 {
    //定义全局变量存储数据
    static int res = 0;

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
        System.out.println(sumNums(n));
    }

    /**
     * 求和函数
     *
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        //利用逻辑与的短路机制终止递归
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
//时间复杂度: 0(n)
//空间复杂度: O(1)