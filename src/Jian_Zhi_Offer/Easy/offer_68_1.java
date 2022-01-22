package Jian_Zhi_Offer.Easy;

//二叉搜索树的公共祖先
public class offer_68_1 {
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
        public static final int arr[] = new int[]{6, 2, 1, 0, 0, 4, 3, 0, 0, 5, 0, 0, 8, 7, 0, 0, 9, 0, 0};
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
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
     * 求公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if (root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else break;
        }
        return root;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(1)