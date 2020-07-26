//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 669 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 递归
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;

        dfs(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    /**
     *
     * @param result 结果集
     * @param nums 源数组
     * @param list 中间数组
     * @param index 元素层级
     */
    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {
        // terminator condition
        if(index == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        // do not add current item
        dfs(result, nums, list, index+1);
        // add item
        list.add(nums[index]);
        dfs(result, nums, list, index+1);

        // reverse status = delete item
        list.remove(list.size() -1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
