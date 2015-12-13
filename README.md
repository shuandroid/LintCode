# LintCode  
### 关于算法的一些记录  
**全部是在andorid studio 上面写成java项目**  

> 关于为何在AS上写代码，，因为方便，便于记录，和对以后的维护。  

**记录内容：**  
### strStr  

> 第一节课内容  

* coding style   

  变量名， 空格， 换行，   
  Google style  
  Java程序花括号在最右边（同一行右侧）  
  
* 检查是否为空 null

  检查null, 这个很重要

* 对时间复杂度，空间复杂度的考虑  

* 题目：  

  - Permutations
  - Unique Permutations
  - Combination Sum
  - Letter Combination of a Photo Number
  - Palindrome Par

> 第一节课内容结束，题目训练.

### Binary Search Tree (二叉查找树)
> 第二次课， Binary Search Tree  

* T(n) = O(1) + T( n/2)  = O（log n）  

* T(n) = O(1) + T(n-1)  = O(n)
    时间复杂度为： O(n)

* T(n) =  O(1) + 2T(n/2)
    时间复杂度： 还是O(n)  

**Recursion or While Loop**  
推荐使用 while loop
* 递归消耗资源  

* 使用非递归， while 循环。  

  - 循环结束条件
  - 四点要素
    1. start + 1 < end;
    2. mid = start + (end - start) / 2;
    3. A[mid]==, < , > 
    4. A[start] A[end] ? target 

> 比O(n) 更优化的，几乎只有O(log n).  

**题目**  

* Search Insert Position  
* Search a 2D Matrix  
* Search a 2D Matrix II
* Search in a Big Sorted Array
* First Bad Version 
* Find Peak Element  
* Recover Rotated Sorted Array
* Recover Rotated Sorted Array II
* Find Minimum in Rotated Sorted Array
* Find Minimum in Rotated Sorted Array II
* Merge Sorted Array
* Merge Sorted Array II
* Rotate String  

> 第二次课结束.  



* Binary 
  * Binary Tree
  * Other Binary
  * Invert Binary Tree (翻转二叉树)  
    递归和非递归方式.
* Sorted Array
* List  
* Peak Of List
* Search Binary
* 二分法

**动态规划 Dynamic Programming**  
*题目:*  

* unique paths 2.  
* climbing stairs.  
* jump game. &#160;&#160; jumo game 2.  
* two sum.  
* scramble String.  
* k sum  
* backpack  
* palindrome Partitioning II.
* word break.
* longest common ancestor
* longest increasing subsequence
* edit distance &#160;&#160;&#160;&#160; (finish)
* distinct subsequence
* interleaving string
* longest common Subsequence. 
* Lowest Common Ancestor  




> waiting  
> chenzhao@hustunique.com  
> Blog:  http://shuandroid.github.io/
> 算法笔记 欢迎交流学习  

