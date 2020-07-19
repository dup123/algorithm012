//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
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
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 65 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 方法：双端队列
 * 思路：
 * res 结果列表
 * 1.deque 第一个元素始终为最大窗口中最大的元素
 * 1.1.形成窗口前 如果队尾的元素比当前遍历的数组元素小则删除首元素，让队列中大的元素往队列前移
 * 1.2.形成窗口后，保存队列的首元素
 *
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
        // 移动窗口的开始范围为[1-k,0],遍历数组
        for(int j=0,i = 1-k; j<nums.length; i++,j++) {
            // 要移除的元素 和队列中的首元素相等，则异常队列中的值小的元素
            if(i > 0 && deque.peekFirst() == nums[i -1]) {
                deque.removeFirst();
            }
            // 如果首元素小于当前遍历的元素，移出末尾元素
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();

            }
            // 往队尾添加元素
            deque.addLast(nums[j]);
            if(i>=0) {
                // 保存队列中首元素即最大值
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
