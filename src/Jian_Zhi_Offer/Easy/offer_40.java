package Jian_Zhi_Offer.Easy;

import java.util.Arrays;
import java.util.Scanner;

//最小的k个数
public class offer_40 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        //初始化数组
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //输入k
        int k = sc.nextInt();
        arr = getLeastNumbers(arr, k);
        //输出结果
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /**
     * 处理函数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}

//时间复杂度: O(nlogn)
//空间复杂度: O(logn)