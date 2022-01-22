package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//合并两个升序链表
public class offer_25 {
    /**
     * 值域
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        //给head1赋值
        int m = sc.nextInt();
        head1 = create(head1, m);
        //给head2赋值
        int n = sc.nextInt();
        head2 = create(head2, n);
        //调用合并函数
        ListNode ans = mergeTwoLists(head1, head2);
        //输出结果
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    /**
     * 创建链表
     *
     * @param n
     * @return
     */
    public static ListNode create(ListNode head, int n) {
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
     * 合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode r = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }

        if (l1 != null) {
            r.next = l1;
        }
        if (l2 != null) {
            r.next = l2;
        }

        return pre.next;
    }
}
//时间复杂度: 0(n)
//空间复杂度: O(1)