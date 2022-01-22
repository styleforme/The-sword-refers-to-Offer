package Jian_Zhi_Offer.Medium;

import java.util.Arrays;
import java.util.Scanner;

//把数组排成最小的数字
public class offer_45 {
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
        //调用处理函数
        String ans = minNumber(arr);
        //输出结果
        System.out.println(ans);
    }

    /**
     * 求最小数函数
     *
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {
        if (nums.length == 0)
            return null;
        String str[] = new String[nums.length];
        //把数组转换为字符串数组
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        //排序
        Arrays.sort(str, ((o1, o2) -> ((o1 + o2).compareTo(o2 + o1))));
        //存储字符串
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }
}

//时间复杂度: O(nlogn)
//空间复杂度: O(n)