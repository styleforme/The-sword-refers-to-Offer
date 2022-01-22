package Jian_Zhi_Offer.Medium;

//树的子结构
public class offer_26 {

    /**
     * 值域
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public TreeNode() {
            left = null;
            right = null;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树的值和索引
     */
    public static class TreeValueA {
        //0表示null节点
        public static int indexA = 0;
        //public static final int[] TREE_VALUEA = new int[]{3,4,1,0,0,2,0,0,5,0,0};
        public static final int[] TREE_VALUEA = new int[]{1, 2, 0, 0, 3, 0, 0};
    }

    /**
     * 二叉树的值和索引
     */
    public static class TreeValueB {
        //0表示null节点
        public static int indexB = 0;
        //public static final int[] TREE_VALUEB = new int[]{4,1,0,0,0};
        public static final int[] TREE_VALUEB = new int[]{3, 1, 0, 0, 0};
    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode A = new TreeNode(-1);
        TreeNode B = new TreeNode(-1);
        //创建树A
        A = createTreeA(A, 0);
        //创建树B
        B = createTreeB(B, 0);
        //调用判断子树方法并输出结果
        System.out.println(isSubStructure(A, B));
    }

    /**
     * 创建A树
     */
    public static TreeNode createTreeA(TreeNode node, int i) {
        //如果值等于0则表示节点为null
        if (0 == TreeValueA.TREE_VALUEA[i]) {
            return null;
        } else {
            //给当前节点赋值
            node.setVal(TreeValueA.TREE_VALUEA[i]);
        }
        //构造左节点
        TreeNode leftChild = new TreeNode();
        node.left = createTreeA(leftChild, ++TreeValueA.indexA);
        //构造右节点
        TreeNode rightChild = new TreeNode();
        node.right = createTreeA(rightChild, ++TreeValueA.indexA);
        return node;
    }

    /**
     * 创建B树
     */
    public static TreeNode createTreeB(TreeNode node, int i) {
        //如果值等于0则表示节点为null
        if (0 == TreeValueB.TREE_VALUEB[i]) {
            return null;
        } else {
            //给当前节点赋值
            node.setVal(TreeValueB.TREE_VALUEB[i]);
        }
        //构造左节点
        TreeNode leftChild = new TreeNode();
        node.left = createTreeB(leftChild, ++TreeValueB.indexB);
        //构造右节点
        TreeNode rightChild = new TreeNode();
        node.right = createTreeB(rightChild, ++TreeValueB.indexB);
        return node;
    }

    /**
     * 判断是否是子树
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return ((A != null && B != null) && (isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }

    /**
     * 判断B是否是以A为起点的子树
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isSub(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }

}
//时间复杂度: O(mn)
//空间复杂度: O(n)