//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 627 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        // 异常检查
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        // dp数组
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        // 左边界
        for(int i=1; i< rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 上边界
        for(int i=1; i<cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // 遍历所有元素求最小路径
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][cols-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
