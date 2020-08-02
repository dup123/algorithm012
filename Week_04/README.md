深度优先搜索(Depth-First-Search) 

二叉树 

```plain
def dfs(node): 
  if node in visited: 
      # already visited 
      return 
  visited.add(node) 
   
  #process current node 
  #... #logic here 
  dfs(node.left) 
  dfs(node.right)   
```
多叉树 
```
visited = set() 
def dfs(node, visited): 
  visited.add(node) 
  #process current node here 
  for next_node in node_children(): 
    if not next_node in visited: 
      dfs(next_node, visited) 
```
非递归模板 
```plain
def dfs(self, tree) 
  if tree.node is None: 
    return [] 
  visited, stack=[], [tree.root] 
  while stack: 
    node = stack.pop() 
    visited.add(node) 
    process(node) 
    nodes = generate_related_nodes(node) 
    stash.push(nodes) 
     
  # other processing work 
```
广度优先搜索(Breath-First-Search)：使用队列 
```plain
def bsf(graph, start, end): 
  queue = [] 
  queue.append(start) 
  visited.add(start) 
  while queue: 
    node = queue.pop() 
    visited.add(node) 
     
    process(node) 
    nodes = generate_related_node(node) 
    queue.push(nodes) 
     
  # other processing work 
```
# 贪心算法 

含义：在每一步选择中都采取在当前状态最优或最好的选择，从而希望最终结果是全局最好或最优的算法。 

特点：与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有退回功能 

区别：当下做局部最优判断（贪心），回溯（能够回退），最优判断+回退（动态规划） 

场景：解决最优化的问题，如图中最小生成树，求哈夫曼编码等 

# 二分查找 

含义： 

前提条件： 

1.目标函数单调性（单调递增或递减） 

2.存在上下界（bounded） 

3.能够通过索引访问（index accessible） 

代码模板 

```plain
left, right =0; len(array) -1 
while left <= right: 
  mid = (left+right)/2 
  if array[mid] == target: 
    # find the target!! 
    break or return result 
  elif array[mid] < target 
    left = mid + 1 
  else: 
    right = mid -1 
```
