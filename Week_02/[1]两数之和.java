//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8665 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 一遍哈希法
 * 思路使用hashMap存储数组中元素的下表和值
 * 值为key,value为下表
 * 判断target-nums[i]的值 是否存在hashMap表中
 * 有则返回哈希表中key值的value 即下表，和当前元素的下表
 * 如果没有就返回null
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length;i++) {
            int difference = target - nums[i];
            if(map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
