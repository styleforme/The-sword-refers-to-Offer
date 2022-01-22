package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//删除链表的节点
public class offer_18 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入要创建的链表节点个数
        int n = sc.nextInt();
        //输入要删除的节点值
        int val = sc.nextInt();
        //调用创建链表函数
        ListNode head = create(n);
        //调用删除链表节点函数
        ListNode ans = deleteNode(head, val);
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
    public static ListNode create(int n) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(-1);
        ListNode p = head, q = head;
        p.val = sc.nextInt();
        n--;
        while (n > 0) {
            q = p;
            p = new ListNode(-1);
            p.val = sc.nextInt();
            q.next = p;
            n--;
        }
        return head;
    }

    /**
     * 删除函数
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        ListNode q = head;
        if (head.val == val)
            return head.next;
        while (p != null && p.val != val) {
            q = p;
            p = p.next;
        }
        q.next = p.next;
        return head;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)