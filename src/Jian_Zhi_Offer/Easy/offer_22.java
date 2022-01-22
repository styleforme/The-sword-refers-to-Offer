package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//链表中倒数第k个结点
public class offer_22 {
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
        //输入k
        int k = sc.nextInt();
        //调用处理函数
        ListNode ans = getKthFromEnd(head, k);
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
     * 求链表倒数第K个结点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        //快慢指针
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1)