package Jian_Zhi_Offer.Hard;

import java.util.Scanner;

//数组中的逆序对
public class offer_51 {
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
        //调用处理函数并输出结果
        System.out.println(reversePairs(arr));
    }

    static int[] num, tmp;

    /**
     * 求逆序对数量
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        num = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private static int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = num[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                num[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                num[k] = tmp[i++];
            else {
                num[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}

//时间复杂度: O(nlogn)
//空间复杂度: O(n)