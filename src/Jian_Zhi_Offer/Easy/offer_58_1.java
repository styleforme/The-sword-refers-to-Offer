package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//翻转单词顺序
public class offer_58_1 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //初始化字符串
        String str = sc.nextLine();
        //调用处理函数
        str = reverseWords(str);
        //输出结果
        System.out.println(str);
    }

    /**
     * 翻转函数
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder ans = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            ans.append(s.substring(i + 1, j + 1)).append(' ');
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return ans.toString().trim();
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)
