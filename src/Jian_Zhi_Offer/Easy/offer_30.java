package Jian_Zhi_Offer.Easy;

import java.util.Scanner;
import java.util.Stack;

//包含min函数的栈
public class offer_30 {
    static Stack<Integer> A;
    static Stack<Integer> B;

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入要输入的个数
        int n = sc.nextInt();
        //调用初始化函数
        MinStack();
        //把数组元素依次添加入栈
        for (int i = 0; i < n; i++) {
            push(sc.nextInt());
        }
        //调用min函数并输出结果
        System.out.println(min());
        //出站
        pop();
        //调用top函数并输出结果
        System.out.println(top());
        //调用min函数并输出结果
        System.out.println(min());
    }

    /**
     * 初始化A、B两栈
     */
    public static void MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    /**
     * push操作
     */
    public static void push(int x) {
        //通过辅助栈B实现min O(1)复杂度
        A.add(x);
        if (B.isEmpty() || B.peek() >= x)
            B.add(x);
    }

    /**
     * pop的操作
     */
    public static void pop() {
        //通过辅助栈B实现min O(1)复杂度
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    //top操作
    public static int top() {
        return A.peek();
    }

    //min操作
    public static int min() {
        //通过辅助栈B实现min O(1)复杂度
        return B.peek();
    }
}
//时间复杂度: O(1)
//空间复杂度: O(n)