package Jian_Zhi_Offer.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//二叉树的深度
public class offer_55_1 {
    /**
     * 值域
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }

    /**
     * 主函数
     */
    //定义全局集合存储树节点
    static List<TreeNode> nodelist = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组大小
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //调用函数创建树
        creattree(arr, nodelist);
        //获取头节点
        TreeNode root = nodelist.get(0);
        //求二叉树深度,并输出结果
        System.out.println(maxDepth(root));
    }

    /**
     * 创建树
     *
     * @param arr
     * @param nodelist
     */
    public static void creattree(int arr[], List<TreeNode> nodelist) {
        for (int i = 0; i < arr.length; i++) {
            nodelist.add(new TreeNode(arr[i]));
        }
        for (int i = 0; i < nodelist.size() / 2 - 1; i++) {
            nodelist.get(i).setLeft(nodelist.get(i * 2 + 1));
            nodelist.get(i).setRight(nodelist.get(i * 2 + 2));
        }
        int index = nodelist.size() / 2 - 1;
        nodelist.get(index).setLeft(nodelist.get(index * 2 + 1));
        if (nodelist.size() % 2 == 1) {
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
    }

    /**
     * 求深度
     */
    static int ans = 0;

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        bfs(root);
        return ans;
    }

    /**
     * bfs
     *
     * @param root
     */
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans++;
        }
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)