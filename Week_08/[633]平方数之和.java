//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。 
//
// 示例1: 
//
// 
//输入: 5
//输出: True
//解释: 1 * 1 + 2 * 2 = 5
// 
//
// 
//
// 示例2: 
//
// 
//输入: 3
//输出: False
// 
// Related Topics 数学 
// 👍 137 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        for(long a=0; a*a<=c; a++) {
            int b = c - (int)(a*a);
            if(binarySearch(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(long s, long e, int n) {
        if(s > e) return false;
        long mid = s + (e-s)/2;
        if(mid * mid == n) return true;
        if(mid * mid > n) return binarySearch(s, mid-1, n);
        return binarySearch(mid+1, e, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
