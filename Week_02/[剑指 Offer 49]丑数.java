//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 48 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 用最小堆进行处理
 * 1.定义质因子数组
 * 2.从一开始相乘质因子
 * 3.对首输出
 */
class Solution {
    private int[] uglyNums = new int[]{2,3,5};
    public int nthUglyNumber(int n) {

        Queue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        int num = 0;
        while (!pq.isEmpty()) {
            long current = pq.poll();
            if(++num >= n) return (int)current;
            for(int uglyNum : uglyNums) {
                if(!pq.contains(uglyNum * current)) {
                    pq.add(uglyNum * current);
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
