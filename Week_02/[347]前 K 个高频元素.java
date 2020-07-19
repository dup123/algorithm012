//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 使用大顶堆
 * 1.使用map遍历数组元素出现的频次
 * 2.使用堆存储前k个的高频元素
 * 3.输出结果
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 异常校验
        if(nums.length == 0 || k <= 0) {
            return new int[0];
        }
        // 1.遍历元素和频次信息
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 2.使用大顶堆存储频次
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1,o2)-> (countMap.get(o1)-countMap.get(o2)));
        for(int num : countMap.keySet()) {
            heap.add(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        // 3.输出结果
        int[] res = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            res[index++] = heap.poll();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
