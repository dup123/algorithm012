//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 238 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * n为2的幂的条件（解题思路）
 * 1.n的二进制的最高位为1，其余所有位为0
 * 2.n-1最高位为0，且其余位位1
 * 结论 n & (n-1) == 0
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
