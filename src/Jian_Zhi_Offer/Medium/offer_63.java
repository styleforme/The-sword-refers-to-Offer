package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//股票的最大利润
public class offer_63 {
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
        System.out.println(maxProfit(arr));
    }

    /**
     * 求最大利润函数
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //base case
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //求出前面最小的买入价格
            min = Math.min(min, prices[i]);
            //求出当前卖出的利润和之前的利润的最大值
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)