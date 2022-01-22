package Jian_Zhi_Offer.Easy;


//平衡二叉树
public class offer_55_2 {
    /**
     * 值域
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            left = null;
            right = null;
        }

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        //0表示null节点
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{3, 9, 20, 0, 0, 15, 7};
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        //创建树
        root = createTree(root, 0);
        //调用判断平衡二叉树函数并输出结果
        System.out.println(isBalanced(root));

    }

    /**
     * 创建树
     */
    public static TreeNode createTree(TreeNode node, int i) {
        //如果值等于0则表示节点为null
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            //给当前节点赋值
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
     * 判断平衡二叉树
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 判断逻辑
     *
     * @param root
     * @return
     */
    public static int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
//时间复杂度: O(n)
//空间复杂度: O(1)