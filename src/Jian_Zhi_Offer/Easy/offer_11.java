package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//旋转数组中最小的数字
public class offer_11 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        //初始化数组
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(minArray(arr));
    }

    /**
     * 旋转
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        //双指针，二分
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) >> 1;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }
}
//时间复杂度: O(logn)
//空间复杂度: O(1)