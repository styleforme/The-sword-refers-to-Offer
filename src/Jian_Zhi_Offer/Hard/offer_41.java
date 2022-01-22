package Jian_Zhi_Offer.Hard;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//数据流中的中位数
public class offer_41 {
    static Queue<Integer> A;
    static Queue<Integer> B;

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数据流的个数
        int n = sc.nextInt();
        //调用初始化函数
        MedianFinder();
        for (int i = 0; i < n; i++) {
            //调用添加数据函数
            addNum(sc.nextInt());
        }
        //调用中位数函数并输出结果
        System.out.println(findMedian());
    }

    /**
     * 初始化大小堆
     */
    public static void MedianFinder() {
        //小根堆
        A = new PriorityQueue<>();
        //大根堆
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    /**
     * 添加数据
     *
     * @param num
     */
    public static void addNum(int num) {
        //当数据流是奇数个数
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            //当数据流是偶数个数
            B.add(num);
            A.add(B.poll());
        }
    }

    /**
     * 返回中位数
     *
     * @return
     */
    public static double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}

//时间复杂度: O(logn)
//空间复杂度: O(n)