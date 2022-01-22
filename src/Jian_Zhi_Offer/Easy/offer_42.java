package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//连续子数组最大和
public class offer_42 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组大小
        int n = sc.nextInt();
        //定义数组
        int arr[] = new int[n];
        //初始化数组
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用函数并输出结果
        System.out.println(maxSubArray(arr));
    }

    /**
     * 求最大和函数
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //base case
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //nums[]相当于dp数组
            //转移方程式: dp[i]=dp[i-1]+nums[i] dp[i-1]>0
            //          dp[i]=nums[i]         dp[i-1]<=0
            nums[i] += Math.max(nums[i - 1], 0);
            //得到每一轮的最大和
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)