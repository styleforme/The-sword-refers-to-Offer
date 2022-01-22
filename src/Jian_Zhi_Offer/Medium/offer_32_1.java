package Jian_Zhi_Offer.Medium;

import java.util.LinkedList;
import java.util.Queue;

//从上到下打印二叉树1
public class offer_32_1 {
    /**
     * 值域
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public TreeNode() {
            this.left = null;
            this.right = null;
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
        public static final int[] TREE_VALUE = new int[]{3, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        //创建树
        root = createTree(root, 0);
        //从上往下打印
        levelOrder(root);

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
        node.left = createTree(leftChild, ++offer_26.TreeValueA.indexA);
        //构造右节点
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++offer_26.TreeValueA.indexA);
        return node;
    }

    /**
     * 层序打印
     *
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = new TreeNode();
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.println(res[res.length - 1]);
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)