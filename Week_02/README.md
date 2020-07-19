学习笔记

## 第五课
### 哈希表、映射、集合

#### 哈希表
**哈希表** (Hash Table)，也叫 **散列表**，是根据关键码值(Key Value)而直接进行访问的数据结构。 它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
这个映射函数叫作 **散列函数** (Hash Function)，存放记录的数组叫作 **哈希表** (或散列表)。

##### 工程实践

- 电话号码簿
- 用户信息表
- 缓存(LRU Cache)
- 键值对存储(Redis)

#### 映射 (Map)
#### 集合 (Set)


## 第六课
### 树、二叉树、二叉搜索树

- 前序知识回顾： 链表等一维结构
- 单链表 Linked List
- 树 Tree
- 二叉树 Binary Tree
- 图 Graph

**Linked List 是特殊化的 Tree**

**Tree 是特殊化的 Graph**


示例代码:

```python
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
```

### 二叉树遍历 Pre-order/In-order/Post-order

1. 前序(Pre-order):根-左-右
2. 中序(In-order):左-根-右
3. 后序(Post-order):左-右-根


示例代码:

```python
def preorder(self, root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)

def inorder(self, root):
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)

def postorder(self, root):
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)
```

### 二叉搜索树 Binary Search Tree

二叉搜索树，也称二叉排序树、有序二叉树(Ordered Binary Tree)、
排序二叉树(Sorted Binary Tree)，是指一棵空树或者具有下列性质的二叉树:

1. 左子树上所有结点的值均小于它的根结点的值;
2. 右子树上所有结点的值均大于它的根结点的值;
3. 以此类推:左、右子树也分别为二叉查找树。 (这就是重复性!)

中序遍历:升序排列

**树的面试题解法一般都是递归**

# 为什么?

# 课程表

## 第二周
### 实战
| 题号 | 名称 | 难度 | 分类 | 备注 |
| --- | --- | --- | --- | --- |
| [70](https://leetcode.com/problems/climbing-stairs/discuss/?currentPage=1&orderBy=most_votes&query=) | [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)| 🟢 简单 | 泛型递归、树的递归 | - |
| [22](https://leetcode.com/problems/generate-parentheses/discuss/?currentPage=1&orderBy=most_votes&query=) | [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)| 🟡 中等 | 泛型递归、树的递归 | - |
| [226](https://leetcode.com/problems/invert-binary-tree/discuss/?currentPage=1&orderBy=most_votes&query=) | [翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)| 🟢 简单 | 泛型递归、树的递归 | - |
| [98](https://leetcode.com/problems/validate-binary-search-tree/discuss/?currentPage=1&orderBy=most_votes&query=) | [验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)| 🟡 中等 | 泛型递归、树的递归 | - |
| [104](https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/?currentPage=1&orderBy=most_votes&query=) | [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)| 🟢 简单 | 泛型递归、树的递归 | - |
| [111](https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/?currentPage=1&orderBy=most_votes&query=) | [二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)| 🟢 简单 | 泛型递归、树的递归 | - |
| [297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/?currentPage=1&orderBy=most_votes&query=) | [二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)| 🔴️ 困难 | 泛型递归、树的递归 | - |

### 课后作业
| 题号 | 名称 | 难度 | 分类 | 备注 |
| --- | --- | --- | --- | --- |
| [242](https://leetcode.com/problems/valid-anagram/discuss/?currentPage=1&orderBy=most_votes&query=) | [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)| 🟢 简单 | 哈希表、映射、集合 | ⭐️ 也是实战题目 |
| [49](https://leetcode.com/problems/group-anagrams/discuss/?currentPage=1&orderBy=most_votes&query=) | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)| 🟡 中等 | 哈希表、映射、集合 | ⭐️ 也是实战题目 |
| [1](https://leetcode.com/problems/two-sum/discuss/?currentPage=1&orderBy=most_votes&query=) | [两数之和](https://leetcode-cn.com/problems/two-sum/)| 🟢 简单 | 哈希表、映射、集合 | ⭐️ 也是实战题目 |
| [94](https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) | [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)| 🟡 中等 | 树、二叉树、二叉搜索树 | ⭐️ 也是实战题目 |
| [144](https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) | [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)| 🟡 中等 | 树、二叉树、二叉搜索树 | ⭐️ 也是实战题目 |
| [590](https://leetcode.com/problems/n-ary-tree-postorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) | [N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)| 🟢 简单 | 树、二叉树、二叉搜索树 | ⭐️ 也是实战题目 |
| [589](https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) | [N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)| 🟢 简单 | 树、二叉树、二叉搜索树 | ⭐️ 也是实战题目 |
| [429](https://leetcode.com/problems/n-ary-tree-level-order-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) | [N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)| 🟡 中等 | 树、二叉树、二叉搜索树 | ⭐️ 也是实战题目 |
| [236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/?currentPage=1&orderBy=most_votes&query=) | [二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)| 🟡 中等 | 泛型递归、树的递归 | - |
| [105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=) | [从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)| 🟡 中等 | 泛型递归、树的递归 | - |
| [264](https://leetcode.com/problems/ugly-number-ii/discuss/?currentPage=1&orderBy=most_votes&query=) | [丑数](https://leetcode-cn.com/problems/ugly-number-ii/)| 🟡 中等 | 泛型递归、树的递归 | - |
| [347](https://leetcode.com/problems/top-k-frequent-elements/discuss/?currentPage=1&orderBy=most_votes&query=) | [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)| 🟡 中等 | 泛型递归、树的递归 | - |
