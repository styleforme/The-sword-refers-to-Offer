package Jian_Zhi_Offer.Easy;

import java.util.LinkedList;
import java.util.Scanner;

//用两个栈实现队列
public class offer_09 {
    //定义两个栈
    static LinkedList<Integer> A;
    static LinkedList<Integer> B;

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Cqueue();//初始化队列

        appendTail(arr, n);//添加元素

        for (int i = 0; i < n; i++)
            System.out.println(deleteHead());//删除元素
    }

    /**
     * 初始化
     */
    public static void Cqueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    /**
     * 添加元素
     *
     * @param arr
     * @param n
     */
    public static void appendTail(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            A.add(arr[i]);
        }
    }

    //删除元素
    private static int deleteHead() {
        if (!B.isEmpty()) return B.removeLast();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
//时间复杂度: O(1)
//空间复杂度: O(n)