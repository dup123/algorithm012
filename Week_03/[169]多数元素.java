//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 676 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 递归-分治
 * 思路：a为nums的众数条件，是平分nums为两部分，这a至少为其中一部分的众数
 */
class Solution {
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }

    public int helper(int nums[], int start, int end) {
        // recursion terminator
        if(start == end) {
            return nums[start];
        }

        // process current logic and drill drown
        int mid = (end - start) / 2 + start;
        int left = helper(nums, start,mid);
        int right = helper(nums, mid+1, end);

        // reverse status
        if(left == right) {
            return left;
        }
        int leftCount = countElment(nums, left, start, end);
        int rightCount = countElment(nums, right, start, end);

        return leftCount > rightCount ? left : right;
    }


    /**
     * 元素计数
     * @param nums
     * @param num
     * @param start
     * @param end
     * @return
     */
    public int countElment(int[] nums, int num, int start, int end) {
        int count = 0;
        for(int i = start; i<= end; i++) {
            if(nums[i] == num) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
