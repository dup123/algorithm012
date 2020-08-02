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
// 👍 682 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }

    public int helper(int[] nums, int left, int right) {
        // terminator condition
        if(left == right) return nums[left];

        int mid = left + (right -left) /2;
        int leftRes = helper(nums, left, mid);
        int rightRes = helper(nums, mid+1, right);
        if(leftRes == rightRes) return leftRes;
        int countLeft = countElment(nums, leftRes, left, mid);
        int countRight = countElment(nums, rightRes, mid+1, right);
        return countLeft > countRight ? leftRes:rightRes;
    }

    public int countElment(int[] nums, int num, int left, int right) {
        int count =0;
        for(int i = left; i<= right; i++) {
            if(nums[i] == num) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
