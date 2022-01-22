package Jian_Zhi_Offer.Medium;

import java.util.Scanner;

//矩阵中的路径
public class offer_12 {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char arr[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(exist(arr, str));
        }
    }

    /**
     * 求路径
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char words[] = word.toCharArray();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                //对每一个字符进行深度优先搜索
                if (bractre(board, words, i, j, 0))
                    return true;
            }
        return false;
    }

    /**
     * dnf
     *
     * @param board
     * @param words
     * @param i
     * @param j
     * @param k
     * @return
     */
    public static boolean bractre(char board[][], char words[], int i, int j, int k) {
        //判断是否越界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k])
            return false;
        //字符串匹配成功
        if (words.length - 1 == k)
            return true;
        //将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问
        board[i][j] = '\0';
        //对当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res
        boolean ans = bractre(board, words, i + 1, j, k + 1)
                || bractre(board, words, i - 1, j, k + 1)
                || bractre(board, words, i, j + 1, k + 1)
                || bractre(board, words, i, j - 1, k + 1);
        //还原当前矩阵值
        board[i][j] = words[k];
        return ans;
    }
}
//时间复杂度: O(3^kmn)
//空间复杂度: O(k)