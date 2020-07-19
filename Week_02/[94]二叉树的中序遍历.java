//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 581 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 思路
 * 中序遍历：先访问左结点，再访问根节点，最后访问右节点
 * 注意，三种遍历方式先，中和后 都是针对根节点被访问的顺序来命名的
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if(null != root) {

            if(null != root.left) {
                helper(root.left, res);
            }
            res.add(root.val);
            if(null != root.right) {
                helper(root.right, res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
