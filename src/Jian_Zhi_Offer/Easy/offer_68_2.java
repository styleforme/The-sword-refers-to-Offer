package Jian_Zhi_Offer.Easy;

//二叉树的最近公共祖先
public class offer_68_2 {
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

        public void setVal(int val) {
            this.val = val;
        }
    }

    /**
     * 初始化二叉树索引和值
     */
    public static class Treevalue {
        public static int index = 0;
        public static final int arr[] = new int[]{3, 5, 6, 0, 0, 2, 7, 0, 0, 4, 0, 0, 1, 1, 0, 0, 8, 0, 0};
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode root = new TreeNode(-1);
        root = createTree(root, 0);
        root = lowestCommonAncestor(root, p, q);
        System.out.println(root.val);

    }

    /**
     * 创建树
     *
     * @param root
     * @param i
     * @return
     */
    public static TreeNode createTree(TreeNode root, int i) {
        if (Treevalue.arr[i] == 0) {
            return null;
        } else {
            root.setVal(Treevalue.arr[i]);
        }
        TreeNode leftchild = new TreeNode(-1);
        root.left = createTree(leftchild, ++Treevalue.index);
        TreeNode rightchild = new TreeNode(-1);
        root.right = createTree(rightchild, ++Treevalue.index);
        return root;
    }

    /**
     * 求二叉树公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right
        if (left == null) {
            return right;
        }
        //当 right 为空 ，left 不为空 ：p,q 都不在 root 的右子树中，直接返回 left
        if (right == null) {
            return left;
        }
        //当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q,返回 null
        if (left == null && right == null) {
            return null;
        }
        //当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root
        return root;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)