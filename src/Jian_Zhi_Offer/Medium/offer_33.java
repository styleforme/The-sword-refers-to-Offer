package Jian_Zhi_Offer.Medium;

import java.util.Scanner;
import java.util.Stack;

//二叉树的后续遍历序列
public class offer_33 {
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

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode() {
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入数组大小
        int n = sc.nextInt();
        //初始化数组
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //判断函数
        System.out.println(verifyPostorder(arr));

    }

    /**
     * 判断后续遍历序列
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}

//时间复杂度: O(n)
//空间复杂度: O(n)