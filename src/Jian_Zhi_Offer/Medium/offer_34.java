package Jian_Zhi_Offer.Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//二叉树为某一值的路径
public class offer_34 {
    /**
     * 值域
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode() {
            left = left;
            right = right;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树的值和索引
     */
    public static class TreeValue {
        //0表示null节点
        public static int index = 0;
        //public static final int[] TREE_VALUE = new int[]{1,2,0,0,3,0,0};
        public static final int[] TREE_VALUE = new int[]{5, 4, 11, 7, 0, 0, 2, 0, 0, 0, 8, 13, 0, 0, 4, 5, 0, 0, 1, 0, 0};
    }

    //定义全局集合
    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        Scanner sc = new Scanner(System.in);
        int targer = sc.nextInt();
        //创建树
        root = createTree(root, 0);
        //求路径函数
        pathSum(root, targer);
        //遍历List集合
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
     * @param node
     * @param i
     * @return
     */
    public static TreeNode createTree(TreeNode node, int i) {
        if (TreeValue.TREE_VALUE[i] == 0) {
            return null;
        } else {
            node.setVal(TreeValue.TREE_VALUE[i]);
        }
        //构造左节点
        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++TreeValue.index);
        //构造右节点
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++TreeValue.index);
        return node;
    }

    /**
     * 求路径函数
     *
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    /**
     * 具体操作
     *
     * @param root
     * @param tar
     */
    public static void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)