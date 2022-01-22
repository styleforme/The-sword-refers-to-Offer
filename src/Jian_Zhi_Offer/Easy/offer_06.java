package Jian_Zhi_Offer.Easy;

import java.util.Scanner;
import java.util.Stack;

//从头到尾打印链表
public class offer_06 {
    /**
     * 值域
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        ListNode head = new ListNode(-1);
        head = create(n);
        reversePrint(head);
    }

    /**
     * 创建链表
     *
     * @param n
     * @return
     */
    public static ListNode create(int n) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode q = head;
        int num = sc.nextInt();
        head.val = num;
        n = n - 1;
        while (n != 0) {
            p = new ListNode(0);
            p.val = sc.nextInt();
            q.next = p;
            q = p;
            n--;
        }
        return head;
    }

    /**
     * 反转链表
     *
     * @param head
     */
    public static void reversePrint(ListNode head) {
        //通过栈先进后出的特点实现反向链表
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        while (head != null) {
            stack.add(head.val);
            head = head.next;
            n++;
        }
        int arr[] = new int[n];
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        for (int j = 0; j < n - 1; j++)
            System.out.print(arr[j] + " ");
        System.out.println(arr[n - 1]);
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)