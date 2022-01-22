package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//0-n-1缺失的数字
public class offer_53_2 {
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
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(missingNumber(arr));
    }

    /**
     * 找缺失数字
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        //左右指针
        int i = 0, j = nums.length - 1;
        //二分
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}

//时间复杂度: O(logn)
//空间复杂度: O(1)
