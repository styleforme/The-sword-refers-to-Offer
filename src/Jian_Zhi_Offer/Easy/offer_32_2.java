package Jian_Zhi_Offer.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//从上到下打印二叉树2
public class offer_32_2 {
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

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public int getVar() {
            return val;
        }

        public void setVar(int val) {
            this.val = val;
        }
    }

    //定义全局集合存储答案
    static List<List<Integer>> res = new LinkedList<>();
    //定义构建树的集合
    static List<TreeNode> nodelist = new LinkedList<>();

    /**
     * 主函数
     *
     * @param args
     */
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
        //调用函数层序打印
        bfs(root);
        //遍历res集合并输出
        for (List<Integer> t1 : res) {
            for (int t2 : t1) {
                System.out.print(t2 + " ");
            }
            System.out.println();
        }
    }

    /**
     * 创建树
     *
     * @param arr
     * @param nodelist
     */
    public static void creattree(int arr[], List<TreeNode> nodelist) {
        //把数组元素转换成TreeNode节点
        for (int i = 0; i < arr.length; i++) {
            nodelist.add(new TreeNode(arr[i]));
        }
        //构建树
        //给所有父节点设定子节点
        for (int i = 0; i < nodelist.size() / 2 - 1; i++) {
            //编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
            //这里父节点有1（2,3）,2（4,5）,3（6,7）,4（8,9） 但是最后一个父节点有可能没有右子节点 需要单独处理
            nodelist.get(i).setLeft(nodelist.get(i * 2 + 1));
            nodelist.get(i).setRight(nodelist.get(i * 2 + 2));
        }
        //单独处理最后一个父节点 因为它有可能没有右子节点
        int index = nodelist.size() / 2 - 1;
        //先设置左子节点
        nodelist.get(index).setLeft(nodelist.get(index * 2 + 1));
        //如果有奇数个节点，最后一个父节点才有右子节点
        if (nodelist.size() % 2 == 1) {
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)