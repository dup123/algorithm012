//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 607 👎 0


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
 * 方法；辅助栈迭代
 * stack 主要存储下一次元素的 节点信息和层级
 */
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (null != root) {
            stack.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();
            if(null != root) {
                depth = Math.max(depth, currentDepth);
                stack.add(new Pair(root.left, currentDepth + 1));
                stack.add(new Pair(root.right, currentDepth + 1));
            }
        }
        return depth;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
