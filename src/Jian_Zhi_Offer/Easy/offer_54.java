package Jian_Zhi_Offer.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//二叉搜索树的第k大节点
public class offer_54 {
    /**
     * 值域
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getRight() {
            return right;
        }
    }

    /**
     * 主函数
     */
    //集合存储树
    static List<TreeNode> nodelist = new LinkedList<>();
    //res存储最后答案，k1做全局变量
    static int res, k1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组大小
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //输入K
        int k = sc.nextInt();
        //创建树
        createtree(arr, nodelist);
        //获取头节点
        TreeNode root = nodelist.get(0);
        //  求k大节点并输出
        System.out.println(kthLargest(root, k));
    }

    /**
     * 构造树
     *
     * @param arr
     * @param nodelist
     */
    public static void createtree(int arr[], List<TreeNode> nodelist) {
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

    public static int kthLargest(TreeNode root, int k) {
        k1 = k;
        dfs(root);
        return res;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);
        if (k1 == 0)
            return;
        if (--k1 == 0)
            res = root.val;
        dfs(root.left);
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1)