//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1146 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 方法：滚动数组
 * 转移方程：f(x) = f(x-1) + f(x-2)
 */
class Solution {
    public int climbStairs(int n) {
        //起始状态判断
        if(n == 0) return 1;
        if(n <= 2) return n;
        int x1 = 1, x2 = 2, sum = 0;
        // 边界值为 2
        while (n-- > 2) {
            sum = x1 + x2;
            x1 = x2;
            x2 = sum;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
