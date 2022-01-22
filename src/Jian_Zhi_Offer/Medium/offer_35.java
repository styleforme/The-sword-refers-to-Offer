package Jian_Zhi_Offer.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//复杂链表的复制
public class offer_35 {
    /**
     * 值域
     */
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int x) {
            val = x;
            next = null;
            random = null;
        }

        /**
         * 主函数
         *
         * @param args
         */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //输入创建链表的节点个数
            int n = sc.nextInt();
            //调用创建链表函数
            Node head = create(n);
            //调用复制链表函数
            Node ans = copyRandomList(head);
            //输出结果
            while (ans != null) {
                System.out.print(ans.val + " ");
                ans = ans.next;
            }
        }

        /**
         * 创建链表函数
         *
         * @param n
         * @return
         */
        public static Node create(int n) {
            Scanner sc = new Scanner(System.in);
            Node head = new Node(-1);
            Node p = head;
            Node q = head;
            p.val = sc.nextInt();
            n--;
            while (n > 0) {
                q = p;
                p = new Node(-1);
                p.val = sc.nextInt();
                q.next = p;
                n--;
            }
            return head;
        }

        /**
         * 复制链表函数
         *
         * @param head
         * @return
         */
        public static Node copyRandomList(Node head) {
            //定义一个hash表
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            //初始化hash表
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            //cur重新回到head
            cur = head;
            //遍历链表
            while (cur != null) {
                //cur 老节点
                //map.get(cur) 新节点
                //新节点的next指向老节点的下一个指针的value
                map.get(cur).next = map.get(cur.next);
                //新节点的random指向老节点的下一个指针的value
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            //返回链表头结点
            return map.get(head);
        }
    }
}

//时间复杂度分析: O(n)
//空间复杂度分析: O(n)