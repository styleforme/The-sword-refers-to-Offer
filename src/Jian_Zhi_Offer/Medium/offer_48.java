package Jian_Zhi_Offer.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//最长不含重复字符的子字符串
public class offer_48 {
    //主函数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入字符串
        String str = sc.nextLine();
        //调用处理函数并输出结果
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 求字符串函数
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        //i:左指针
        int i = -1, res = 0;
        //右指针j遍历字符串
        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //更新左指针
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)