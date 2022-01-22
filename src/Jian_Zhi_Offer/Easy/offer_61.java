package Jian_Zhi_Offer.Easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//扑克牌中的顺子
public class offer_61 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入抽的牌数组大小
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用处理函数并输出
        System.out.println(isStraight(arr));
    }

    /**
     * 判断是否是顺子函数
     *
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        //set用来去重
        Set<Integer> set = new HashSet<>();
        //初始化最大值和最小值
        int min = 14, max = 0;
        for (int i = 0; i < nums.length; i++) {
            //跳过大小王
            if (nums[i] == 0) {
                continue;
            }
            //更新最大值
            max = Math.max(max, nums[i]);
            //更新最小值
            min = Math.min(min, nums[i]);
            //判断是否重复
            if (set.contains(nums[i])) {
                return false;
            }
            //添加进set集合
            set.add(nums[i]);
        }
        //因为每次是拿5张牌，所有最大牌和最小牌差小于5则一定是顺子
        return max - min < 5;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)