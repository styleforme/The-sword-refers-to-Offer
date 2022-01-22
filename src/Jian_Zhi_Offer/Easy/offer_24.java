package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//反转链表
public class offer_24 {
    /**
     * 值域
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
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

        //创建链表
        head = create(n);
        //调用处理函数
        head = reverseList(head);
        //输出结果
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
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
     * 反转函数
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode pre = null;
        //反转链表
        while (p != null) {
            ListNode t = p.next;
            p.next = pre;
            pre = p;
            p = t;
        }
        return pre;
    }
}


//时间复杂度: O(n)
//空间复杂度: O(1)