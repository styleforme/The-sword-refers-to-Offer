package Jian_Zhi_Offer.Medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//队列的最大值
public class offer_59_2 {
    //定义队列
    static Queue<Integer> q;
    //定义双端队列
    static Deque<Integer> d;

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //调用初始化队列函数
        MaxQueue();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //添加元素
        for (int i = 0; i < n; i++) {
            push_back(arr[i]);
        }
        //获取队列最大值
        System.out.println(max_value());
        //出队列
        System.out.println(pop_front());
        //获取队列最大值
        System.out.println(max_value());
    }

    /**
     * 初始化队列
     */
    public static void MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    /**
     * 获取最大值
     *
     * @return
     */
    public static int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    /**
     * 入队列
     *
     * @param value
     */
    public static void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    /**
     * 出队列
     *
     * @return
     */
    public static int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}

//时间复杂度: O(1)
//空间复杂度: O(n)