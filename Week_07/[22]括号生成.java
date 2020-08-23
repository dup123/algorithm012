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
// 👍 1254 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) {
            res.add("");
            return res;
        }

        for(int m=0; m<n; m++) {
            int k = n-m-1;
            List<String> first = generateParenthesis(m);
            List<String> second = generateParenthesis(k);
            for(String left : first) {
                for(String right: second) {
                    res.add("(" + left +")" + right);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
