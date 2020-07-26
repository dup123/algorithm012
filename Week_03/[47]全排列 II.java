//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 358 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }
    public void backTrack(int[] nums, boolean[] visited, List<Integer> output, List<List<Integer>> result) {
        // recursion terminator condition output.size == nums.length
        if(output.size() == nums.length) {
            result.add(new ArrayList<Integer>(output));
        } else {
            // loop nums item to check
            for(int i = 0; i< nums.length; i++) {
                // check visited item
                if(visited[i]) continue;
                // check repeat
                if(i > 0 && nums[i] == nums[i-1] && visited[i-1]) break;
                // add item
                output.add(nums[i]);
                // sign i visited
                visited[i] = true;
                // drill down
                backTrack(nums, visited, output, result);
                // reverse status
                output.remove(output.size() -1);
                visited[i] = false;
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
