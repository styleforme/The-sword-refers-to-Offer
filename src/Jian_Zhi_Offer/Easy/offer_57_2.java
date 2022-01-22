package Jian_Zhi_Offer.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//和为s的连续正整数序列
//由于跟力扣函数形式吻合，以至于数组大小定义不方便，输出正确的结果以后会报数组越界异常。
public class offer_57_2 {
    static List<int[]> res = new ArrayList<>();

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //定义结果数组
        int arr[][] = new int[res.size()][];
        //输入target
        int target = sc.nextInt();
        //调用处理函数
        arr = findContinuousSequence(target);
        //输出结果
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 求序列函数
     *
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        int i = 1, j = 1, sum = 0;
        while (i <= target / 2) {
            if (sum > target) {
                sum -= i;
                i++;
            } else if (sum < target) {
                sum += j;
                j++;
            } else {
                int arr[] = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

//时间复杂度: O(logn)
//空间复杂度: O(1)