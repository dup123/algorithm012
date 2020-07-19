//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 454 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 方法:双端队列法
 * 思路
 * 1.确认滑动队列窗口为[i,i+k]
 * 2.使用双端队列存储滑动窗口的有效元素
 * 3.保证队列类递减，且确保队首为最大元素
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 异常check
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }

        // 初始化双端队列和结果数组
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 滑动窗口的开始范围为[1-k,0],遍历数组
        for(int j = 0, i = 1-k; j<nums.length; i++,j++) {
            // 滑动窗口移动后，移出队列中不在滑动窗口中的元素
            if(i > 0 && deque.peekFirst() == nums[i-1]) {
                deque.removeFirst();
            }
            // 遍历元素大于栈尾元素，移出栈尾元素
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            // 往队尾添加元素
            deque.addLast(nums[j]);
            if(i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
