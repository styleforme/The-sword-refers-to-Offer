package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//数组中数字出现的次数
public class offer_56_1 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组的大小
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用函数
        arr = singleNumbers(arr);
        //输出结果
        for (int i = 0; i < 2; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 求数组中出现一次的两个数字
     *
     * @param arr
     * @return
     */
    private static int[] singleNumbers(int[] arr) {
        //x:存第一个出现一次的数字 y:存第二个出现一次的数字 m:找到x,y首位为1的位置 n:存第一次异或运算结果
        int x = 0, y = 0, m = 1, n = 0;
        for (int num : arr) {
            //通过遍历异或得到两个出现一次的数字
            n ^= num;
        }
        //找到x,y首位为1的位置
        while ((n & m) == 0) {
            //右移一位
            m <<= 1;
        }
        //遍历数组构造x,y
        for (int num : arr) {
            if ((num & m) != 0) {
                //构造x
                x ^= num;
            } else {
                //构造y
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}

//时间复杂度:O(n)
//空间复杂度:O(1)