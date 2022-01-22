package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//数组中出现次数超过一半的数字
public class offer_39 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组的大小
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用处理函数并输出结果
        System.out.println(majorityElement(arr));
    }

    /**
     * 求结果函数
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        //计数
        int cnt = 0;
        //结果
        int ans = 0;
        //遍历数组
        //因为数组中有一个数字出现的次数超过数组长度的一半
        //如果我们把众数（出现次数超过一半的数字）记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                ans = nums[i];
            }
            if (ans == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return ans;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)