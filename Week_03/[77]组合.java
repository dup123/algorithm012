//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 320 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, 1, new ArrayList<Integer>(), k, n);
        return result;
    }

    public void dfs(List<List<Integer>> result, int index, List<Integer> current, int k, int n) {
        // recursion terminator condition: current list.size = k
        if (current.size() == k) {
            result.add(new ArrayList<Integer>(current));
        }
        // process current level logic: loop index ~ n
        for (int i = index; i < n + 1; ++i) {
            // add item
            current.add(i);
            // drill down
            dfs(result, i + 1, current, k, n);
            // reverse status: remove last item;
            current.remove(current.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
