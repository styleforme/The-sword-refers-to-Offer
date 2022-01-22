package Jian_Zhi_Offer.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//对称的二叉树
public class offer_28 {
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

    /**
     * 主函数
     */
    //创建集合存储树的节点
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
        //调用处理函数并输出结果
        System.out.println(isSymmetric(root));
    }

    /**
     * 构建树并初始化
     *
     * @param arr
     * @param list
     */
    public static void creattree(int arr[], List<TreeNode> list) {
        //将数组变成node节点
        for (int nodeindex = 0; nodeindex < arr.length; nodeindex++) {
            TreeNode node = new TreeNode(arr[nodeindex]);
            nodelist.add(node);
        }
        //给所有父节点设定子节点
        for (int index = 0; index < nodelist.size() / 2 - 1; index++) {
            //编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
            //这里父节点有1（2,3）,2（4,5）,3（6,7）,4（8,9） 但是最后一个父节点有可能没有右子节点 需要单独处理
            nodelist.get(index).setLeft(nodelist.get(index * 2 + 1));
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
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
     * 判断是否对称返回结果
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return mirror(root.left, root.right);
    }

    //依次判断root.left,root.right是否对称
    public static boolean mirror(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null || A.val != B.val)
            return false;
        return mirror(A.left, B.right) && mirror(A.right, B.left);
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)