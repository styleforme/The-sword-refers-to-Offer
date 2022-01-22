package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//替换空格
public class offer_05 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            //调用处理函数并输出结果
            System.out.println(replaceSpace(s));
        }
    }

    /**
     * 替换空格
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        //利用StringBuilder拼接
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)
