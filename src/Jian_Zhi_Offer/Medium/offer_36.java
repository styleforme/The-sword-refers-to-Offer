package Jian_Zhi_Offer.Medium;

//二叉搜索树和双向链表
public class offer_36 {
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
        //二叉搜索树转双向链表
        treeToDoublyList(root);
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

    static TreeNode head, pre;

    /**
     * 转化
     *
     * @param root
     * @return
     */
    public static TreeNode treeToDoublyList(TreeNode root) {
        if (root == null)
            return head;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序遍历逻辑
     *
     * @param cur
     */
    public static void dfs(TreeNode cur) {
        if (cur == null)
            return;
        dfs(cur.left);
        if (pre != null)
            pre.right = cur;
        else
            head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
//时间复杂度: O(n)
//空间复杂度: O(n)