package Jian_Zhi_Offer.Hard;

import java.util.Scanner;

//正则表达式匹配
public class offer_19 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入字符串s
        String s = sc.nextLine();
        //输入字符串p
        String p = sc.nextLine();
        //调用处理函数并输出结果
        System.out.println(isMatch(s, p));
    }

    /**
     * 正则匹配
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        return dp(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public static boolean dp(char s[], int i, char p[], int j) {
        int m = s.length;
        int n = p.length;
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1)
                return false;
            for (; j + 1 < n; j += 2) {
                if (p[j + 1] != '*') {
                    return false;
                }
            }
            return true;
        }
        boolean res = false;
        //相等
        if (s[i] == p[j] || p[j] == '.') {
            if (j < n - 1 && p[j + 1] == '*') {
                //匹配一次或多次
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                //匹配一次
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            //不相等
            if (j < n - 1 && p[j + 1] == '*') {
                //匹配一次
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        return res;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)