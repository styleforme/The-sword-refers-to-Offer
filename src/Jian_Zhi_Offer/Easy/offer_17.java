package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//打印从1到最大n的位数
public class offer_17 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = (int) Math.pow(10, n) - 1;
        int arr[] = new int[len];
        //调用处理函数
        arr = printNumbers(n);
        //输出结果
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /**
     * 打印函数
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        //通过推算得到最大值
        int max = (int) Math.pow(10, n) - 1;
        int arr[] = new int[max];
        for (int i = 0; i < max; i++)
            arr[i] = i + 1;
        return arr;
    }
}


// 时间复杂度: O(10^n)
// 空间复杂度: O(1)