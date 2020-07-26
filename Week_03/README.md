学习笔记
---
数组结构
----------
####递归(Recurison)
含义:本身是是循环，通过调用函数体来进行的循环  
**思维要点**  
1. 不要人肉进行递归
2. 找最近最简方法，将其拆解成可重复解决的问题(重复子问题)
3. 数学归纳法思维
**递归模板**
~~~java
/**
 * java recur
 */
public void recur(int level, int param) {
    // recursion terminator
    if(level > MAX_LEVEL) {
        // process result
        return;
    }

    // process logic in current level
    process(level, param);

    // drill down
    recur(level+1, newParam);

    // restore current level status if needed 
}
~~~

###分治算法
####模板
1. recursion teminator
2. process(split your big problem)
3. drill down (subProblems),merge(subResult)
4.reverse status

#实战题目
####N皇后
#####编程概念
1. 约束编程：在放置每个皇后以后增加限制。当在棋盘上放置了一个皇后后，立即排除当前行，列和对应的两个对角线。该过程传递了 约束 从而有助于减少需要考虑情况数。
2. 回溯法：回退一步，来改变最后放置皇后的位置并且接着往下放置。如果还是不行，再 回溯