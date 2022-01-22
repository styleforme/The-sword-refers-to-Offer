package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//数组中数字出现次数2
public class offer_56_2 {
    //主函数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组大小
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用处理函数并输出结果
        System.out.println(singleNumber(arr));
    }

    /**
     * 求次数函数
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int cnt[] = new int[32];
        for (int num : nums)
            for (int j = 0; j < 32; j++) {
                //统计num出现1的次数
                cnt[j] += num & 1;
                //右移一位
                num >>>= 1;
            }
        int res = 0, m = 3;
        //还原数字
        for (int i = 0; i < cnt.length; i++) {
            //左移一位
            res <<= 1;
            res |= cnt[31 - i] % 3;
        }
        return res;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)