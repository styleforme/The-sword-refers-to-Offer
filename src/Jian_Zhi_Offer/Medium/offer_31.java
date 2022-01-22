package Jian_Zhi_Offer.Medium;

import java.util.Scanner;
import java.util.Stack;

//栈的压入、弹出序列
public class offer_31 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入压入数组大小
        int n = sc.nextInt();
        int pushed[] = new int[n];
        //输入弹出数组大小
        int m = sc.nextInt();
        int popped[] = new int[m];
        //初始化入栈数组
        for (int i = 0; i < n; i++)
            pushed[i] = sc.nextInt();
        //初始化出栈数组
        for (int i = 0; i < m; i++)
            popped[i] = sc.nextInt();
        //调用处理函数并输出结果
        System.out.println(validateStackSequences(pushed, popped));
    }

    /**
     * 判断入栈出栈顺序是否正确
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //辅助栈，存放入栈数据
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            //入栈
            stack.push(num);
            //当辅助栈不为null并且栈顶元素和出栈数组当前值相等
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                //弹出
                stack.pop();
                //出栈数组下标向前移一位
                i++;
            }
        }
        //辅助栈最后为空则匹配正确
        return stack.isEmpty();
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)