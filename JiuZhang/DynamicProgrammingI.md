## Dynamic Programming I
* 从递归到动归 -Triangle  
 
* 什么样的题适合使用动态规划  

* 当我们谈论动态规划的时候，我们在谈论什么

* 面试中常见动态规划分类：  

lintcode上面的题目：triangle（树的三角形）  
解决方法：  
* 遍历： DFS : Traverse  
  time complexity : O(2^n), 
* DFS: Divide Conquer(分治).
  time  complexity : O(2^n) 
* Divide Conquer + Memorization (建表优化)  
  time complexity:  O(n^2) 
  在return之前，用hashmap表存储,去掉重复访问的元素，优化。


 
