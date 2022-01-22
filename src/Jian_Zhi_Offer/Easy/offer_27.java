package Jian_Zhi_Offer.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class offer_27 {
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
     * 主方法
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
        //调用镜像方法
        root = mirrorTree(root);
        //利用层序遍历输出结果
        bfs(root);
    }

    /**
     * 构建树
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
     * 求镜像
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode t = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = t;
        return root;
    }

    //输出节点值
    public static void checkCurrentNode(TreeNode node) {
        System.out.print(node.getVar() + " ");
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public static void bfs(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        //首先将根节点存入队列
        queue.offer(root);
        //当队列里有值时，每次取出队首的node打印，打印之后判断node是否有子节点，若有，则将子节点加入队列
        while (queue.size() > 0) {
            TreeNode node = queue.peek();
            queue.poll(); //取出队首元素并打印
            System.out.print(node.val + " ");
            //如果有左子节点，则将其存入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            //如果有右子节点，则将其存入队列
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)