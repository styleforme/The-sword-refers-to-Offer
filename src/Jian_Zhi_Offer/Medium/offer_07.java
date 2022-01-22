package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//重建二叉树
public class offer_07 {
    /**
     * 值域
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
            this.left = left;
            this.right = right;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int preorder[] = new int[m];
        for (int i = 0; i < m; i++) {
            preorder[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int inorder[] = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        TreeNode root = new TreeNode(-1);
        //重建二叉树
        root = buildTree(preorder, inorder);
        //前序遍历并输出结果
        beforetree(root);
    }

    /**
     * 重建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return tree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 具体逻辑
     *
     * @param preorder
     * @param l
     * @param r
     * @param inorder
     * @param l1
     * @param r1
     * @return
     */
    public static TreeNode tree(int preorder[], int l, int r, int inorder[], int l1, int r1) {
        if (l > r)
            return null;
        int index = -1;
        int rootval = preorder[l];
        for (int i = l1; i <= r1; i++) {
            if (inorder[i] == rootval) {
                index = i;
                break;
            }
        }
        int leftsize = index - l1;
        TreeNode root = new TreeNode(rootval);
        root.left = tree(preorder, l + 1, l + leftsize, inorder, l1, index - 1);
        root.right = tree(preorder, l + leftsize + 1, r, inorder, index + 1, r1);
        return root;
    }

    /**
     * 递归前序遍历
     */
    public static void beforetree(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        beforetree(root.left);
        beforetree(root.right);
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)