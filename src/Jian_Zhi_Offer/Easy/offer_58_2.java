package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//左旋转字符串
public class offer_58_2 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入字符串
        String str = sc.nextLine();
        //输入k
        int k = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(reverseLeftWords(str, k));
    }

    /**
     * 左旋转函数
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        StringBuilder ans = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            ans.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)