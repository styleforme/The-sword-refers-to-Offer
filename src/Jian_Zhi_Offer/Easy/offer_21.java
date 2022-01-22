package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//调整数组顺序使奇数位于偶数前面
public class offer_21 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用调整函数
        arr = exchange(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 调整数组
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        //双指针
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 != 1 && nums[j] % 2 == 1) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            } else if (nums[i] % 2 == 1)//奇数
            {
                i++;
            } else if (nums[j] % 2 == 0) {//偶数
                j--;
            }
        }
        return nums;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1)