//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 805 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        for(int num : nums) {
            current.add(num);
        }
        backTrack(nums.length, result, current, 0);
        return result;
    }

    public void backTrack(int len, ArrayList<List<Integer>> result, ArrayList<Integer> current, int first) {
        if(len == first) {
            result.add(new ArrayList<Integer>(current));
        }

        for(int i = first; i< len; i++) {
            Collections.swap(current, first, i);
            backTrack(len, result, current,first +1);
            Collections.swap(current, first, i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
