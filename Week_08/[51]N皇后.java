//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 519 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 递归+回溯法
 * 要点：确认攻击范围，已经放置成功的列，行 和 撇 捺 上 都不应该再防止后续的皇后
 */
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], result);
        return result;
    }

    /**
     * 递归排除数组的错误位置
     *
     * @param r      行
     * @param cols   列
     * @param d1     撇位置集
     * @param d2     捺位置集合
     * @param boards 每行原始结果集
     * @param result 结果
     */
    public void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] boards, List<List<String>> result) {
        // recursion terminator (check limited)
        if (r == boards.length) result.add(Arrays.asList(boards.clone()));
        else {
            int len = boards.length;
            // current levle logic(check attract location)
            for (int c = 0; c < len; c++) {
                int id1 = r - c + len;
                int id2 = 2 * len - r - c - 1;
                // 确认皇后位置，不在攻击位置
                if (!cols[c] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[len];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    // 当前列的Q位置
                    boards[r] = new String(row);

                    cols[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    // drill down( deal next row localtion)
                    helper(r + 1, cols, d1, d2, boards, result);

                    cols[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
