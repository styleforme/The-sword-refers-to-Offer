package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//构建乘积数组
public class offer_66 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组大小
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //定义结果数组
        int ans[] = new int[n];
        //调用处理函数
        ans = constructArr(arr);
        //输出结果
        for (int i = 0; i < n - 1; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println(ans[n - 1]);
    }

    /**
     * 构建乘积数组函数
     *
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0)
            return new int[0];
        int b[] = new int[len];
        b[0] = 1;
        int temp = 1;
        //求下三角每行乘积
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //求上三角乘积
        for (int i = len - 2; i >= 0; i--) {
            //求上三角每行乘积
            temp *= a[i + 1];
            //构造数组
            b[i] *= temp;
        }
        return b;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)