package Jian_Zhi_Offer.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//第一个只出现一次的字符
public class offer_50 {
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
        System.out.println(firstUniqChar(str));
        ;
    }

    /**
     * 求只出现一次的字符
     *
     * @param str
     * @return
     */
    private static char firstUniqChar(String str) {
        //用来统计字符出现次数
        Map<Character, Integer> map = new HashMap<>();
        //统计各个字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        //找出第一个只出现的字符
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return ' ';
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)