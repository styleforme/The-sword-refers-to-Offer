package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//在排序数组中查询数字
public class offer_53_1 {
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
        //输入target
        int target = sc.nextInt();
        //调用函数并输出结果
        System.out.println(search(arr, target));
    }

    /**
     * 查询函数
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        //右边界-左边界-1
        return bianjie(nums, target) - bianjie(nums, target - 1);
    }

    private static int bianjie(int[] nums, int target) {
        //左右指针
        int i = 0, j = nums.length - 1;
        //二分
        while (i <= j) {
            //求中点
            int m = (i + j) >> 1;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] <= target) {
                i = m + 1;
            }
        }
        return i;
    }
}

//时间复杂度: O(logn)
//空间复杂度: O(1)