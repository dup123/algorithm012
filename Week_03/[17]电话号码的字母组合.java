//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 806 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        // 异常 check
        if(digits.equals("")) {
            return result;
        }
        Map<Character, String> map = getNumsForDigits();

        dfs(digits, 0, "", result, map);
        return result;
    }

    /**
     * 中间结果
     *
     * @param digits 目标处理对象
     * @param level  遍历当前层级
     * @param midStr 中间结果
     * @param result
     */
    public void dfs(String digits, int level, String midStr, List<String> result, Map<Character, String> map) {
        // terminator condition
        if (level == digits.length()) {
            result.add(midStr);
            return;
        }

        // 根据 层级 获取要处理的元素
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            // drill down
            dfs(digits, level + 1, midStr + letters.charAt(i), result, map);
        }
    }

    /**
     * getDigits
     *
     * @return
     */
    private Map<Character, String> getNumsForDigits() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
