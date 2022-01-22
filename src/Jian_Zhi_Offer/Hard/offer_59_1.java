package Jian_Zhi_Offer.Hard;

import java.util.LinkedList;
import java.util.Scanner;

//滑动窗口的最大值
public class offer_59_1 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int q[] = maxSlidingWindow(arr, k);
        for (int i = 0; i < q.length; i++)
            System.out.print(q[i] + " ");
    }

    /**
     * 获取最大窗口函数
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1)
            return new int[0];
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int res[] = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //进窗口
            //如果双端队列不为null,并且里面的数比要入窗口的数小
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                //一直弹出
                qmax.pollLast();
            }
            //把当前数添加进去
            qmax.addLast(i);

            if (qmax.peekFirst() == i - k) {//过期位置
                //头部弹出
                qmax.pollFirst();
            }
            //形成w大小的窗口
            if (i >= k - 1) {
                //生成答案
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)