package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//把数字翻译成字符串
public class offer_46 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数字
        int num = sc.nextInt();
        //调用函数并输出结果
        System.out.println(translateNum(num));
    }

    /**
     * 求有多少种翻译方法
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        //把数字转换成字符串
        String str = String.valueOf(num);
//        //base case
//        int a=1,b=1,c=0;
//        //动态规划
//        for(int i=2;i<=str.length();i++){
//            String temp=str.substring(i-2,i);
//            c=temp.compareTo("10")>=0&&temp.compareTo("25")<=0?a+b:a;
//            a=b;
//            b=c;
//        }
//        return a;
        int dp[] = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)