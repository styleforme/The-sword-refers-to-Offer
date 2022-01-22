package Jian_Zhi_Offer.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//字符串的排列
public class offer_38 {
    //存放结果的集合
    static List<String> ans = new ArrayList<>();
    //存放路径的数组
    static char ch[];

    //主函数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入字符串
        String s = sc.nextLine();
        //调用排列函数
        permutation(s);
        String str[] = ans.toArray(new String[ans.size()]);
        //输出结果
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
    }

    /**
     * 排列函数
     *
     * @param s
     * @return
     */
    public static String[] permutation(String s) {
        ch = s.toCharArray();
        //开始回溯
        dfs(0);
        //返回结果集
        return ans.toArray(new String[ans.size()]);
    }

    //回溯函数
    public static void dfs(int x) {
        //满足条件，添加进集合
        if (x == ch.length - 1) {
            ans.add(String.valueOf(ch));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        //开始递归
        for (int i = x; i < ch.length; i++) {
            //去重
            if (set.contains(ch[i])) {
                continue;
            }
            //满足条件则添加进路径
            set.add(ch[i]);
            swap(i, x);
            //选择列表
            dfs(x + 1);
            //撤销操作
            swap(i, x);
        }
    }

    /**
     * 交换函数
     *
     * @param i
     * @param j
     */
    public static void swap(int i, int j) {
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
    }
}

//时间复杂度: O(n!n)
//空间复杂度: O(n^2)