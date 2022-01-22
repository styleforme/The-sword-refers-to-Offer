package Jian_Zhi_Offer.Easy;

import java.util.Scanner;

//两个链表的第一个公共节点
public class offer_52 {
    /**
     * 值域
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入headA的节点个数
        int m = sc.nextInt();
        //初始化headA
        ListNode headA = create(m);
        //输入headB的节点个数
        int n = sc.nextInt();
        //初始化headB
        ListNode headB = create(n);
        //调用处理函数
        ListNode ans = getIntersectionNode(headA, headB);
        //输出结果
        System.out.println(ans.val);
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
     * 求公共节点函数
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)