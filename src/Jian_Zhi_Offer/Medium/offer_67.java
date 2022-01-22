package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//把字符串转成整数
public class offer_67 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入字符串
        String str = sc.nextLine();
        //调用处理函数并输出结果
        System.out.println(strToInt(str));
    }

    /**
     * 字符串转整数函数
     *
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        //转换成字符数组并删掉首尾空格
        char ch[] = str.trim().toCharArray();
        //判断第一个字符是-还是+或者无，flag为1表示正，为-1表示负，res存储结果
        int i = 1, flag = 1, res = 0;
        //标记越界
        int max = Integer.MAX_VALUE / 10;
        if (ch.length == 0)
            return 0;
        if (ch[0] == '-') {
            flag = -1;
        } else if (ch[0] != '+') {
            //表示第一位没有符号
            i = 0;
        }
        for (int j = i; j < ch.length; j++) {
            if (ch[j] < '0' || ch[j] > '9') {
                break;
            }
            if (res > max || res == max && ch[j] > '7') {
                if (flag == 1) {
                    res = Integer.MAX_VALUE;
                    return res;
                } else {
                    res = Integer.MIN_VALUE;
                    return res;
                }
            }
            res = res * 10 + (ch[j] - '0');
        }
        return res * flag;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)