package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//数字序列中的某一位数字
public class offer_44 {
    //主函数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数字
        int n = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(findNthDigit(n));
    }

    /**
     * 求数位函数
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        long k = n;
        int i = 1;
        //每个数字字符宽度都补成当前位数i, 那么返回第k/i个数的第k%i位即可
        while (true) {
            if (i * Math.pow(10, i) > k) {
                String s = k / i + "";
                return s.charAt((int) (k % i)) - '0';
            }
            k += Math.pow(10, i);
            i++;
        }
    }
}

//时间复杂度: O(logn)
//空间复杂度: O(logn)