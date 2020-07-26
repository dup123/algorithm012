//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2415 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 排序 夹逼法（双指针）
// 1.去重k,i,j
// 2.三数之和判断 sum<0,i右移，sum>0，j左移
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 异常值判断
        if(null == nums || nums.length <= 2) return Collections.emptyList();
        // 有序化
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int k = 0; k < nums.length-2 ; k++) {
            // 消除无效（k>0不存在三数之和等于0）
            if(nums[k] > 0) break;
            // 去重处理
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1, j=nums.length -1;
            while(i < j) {
                // 三数之和
                int sum = nums[k] + nums[i] + nums[j];
                if(sum > 0) {
                    // 将j指针左移且去重处理
                    while(i < j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    // 将i指针右移且去重处理
                    while(i < j && nums[i] == nums[++i]);
                } else {
                    result.add(new ArrayList(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 去重处理
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
