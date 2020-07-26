//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 递归法
 * 难点：理解题目
 * 1.n代表括号的对数
 * 2.有效括号拼接的条件
 * 2.1 左括号<n 可以拼接左括号2
 * 2.2 右括号<左括号 可以拼接右括号
 */
class Solution {

    private int maxNum;
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        maxNum = n;
        generateParenthesisRecur(0, 0, "", res);
        return res;
    }

    public void generateParenthesisRecur(int leftNum, int rightNum, String ptString, List<String> res) {
        // terminator condition
        if(leftNum == maxNum && rightNum == maxNum) {
            res.add(ptString);
            return;
        }

        // current level logic and drill down
        if(leftNum < maxNum) generateParenthesisRecur(leftNum + 1, rightNum, ptString + "(", res);
        if(rightNum < leftNum) generateParenthesisRecur(leftNum, rightNum+1, ptString + ")", res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
