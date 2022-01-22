package Jian_Zhi_Offer.Easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//数组中重复的数字
public class offer_03 {
    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用处理函数并输出结果
        System.out.println(findRepeatNumber(arr));
    }

    /**
     * 找重复的数
     */
    public static int findRepeatNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        //利用HashSet的性质去重
        for (; i < n; i++) {
            if (set.contains(nums[i]))
                break;
            set.add(nums[i]);
        }
        return nums[i];
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)