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

> 第一节课内容结束，题目训练. 详情 [strStr](https://github.com/shuandroid/LintCode/blob/master/JiuZhang/strStr.md)

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

> 第二次课结束.  详情 [BinartSearchTree](https://github.com/shuandroid/LintCode/blob/master/JiuZhang/second.md)

### 第三次  
> miss  

### Dynamic Programming I (动态规划)
> 第四次课 DP I  
* 什么样的题适合使用动态规划  
  满足下面三个条件：
  * 求最小最大
  * 求能不能，存不存在
  * 方案总数

#### 四个要素：  
* 状态 state  
* 方程：function
* 初始化: initialization
* 答案：answer
   终点，始点  
**题目：**  
* unique paths 2.  
* climbing stairs.  
* jump game. &#160;&#160; jumo game 2.  
* two sum.  
* scramble String.  
* k sum  
* backpack  

> 第四次课结束. 详情 [DP I](https://github.com/shuandroid/LintCode/edit/master/JiuZhang/DynamicProgrammingI.md)  

### Dynamic Programming II  
> 第五次课 DP II  

* 区间型动态规划  
* 双序列动态规划  

**题目：**  
* palindrome Partitioning II.
* word break.
* longest common ancestor
* longest increasing subsequence
* edit distance
* distinct subsequence
* interleaving string
* longest common Subsequence.

> 第五次课结束. 详情 : [DP II](https://github.com/shuandroid/LintCode/edit/master/JiuZhang/DynamicProgramming2.md)  

### LinkedList  
> 第六次课 LinkedList  

**加强对Java链表的理解**  

技巧：  
* Duplicating null  

	把一个链表的头，即第一次，在创建一个新的链表，使该链表指向要处理链表的头，  
	即使原来的头，变成现在的第二个。  

* 快慢指针  
	用来寻找链表的中间点： 
	去搜索一个链表的中点：创建一个slow、fast指针，while循环，每次slow向下指一个，  
	而fast向下指两个，当fast指到终点时，这时slow指向的正好是中间。

		private ListNode findMiddle(ListNode head) {
			ListNode slow = head, fast = head.next;
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		} 

**题目：**  
* Remove Duplicates from  Sored List 
* Remove Duplicates from  Sored List II  
* Reverse Linked List II
* Reverse Linked List  反转链表  
* partition list 
* Reorder list 
* Linked list Cycle
* Linked List Cycle II
* Rotate list
* Merge k Sorted Lists  
* Copy List with Random Pointer
* convert Sorted List

> 第六次课结束   详情 ：[LinkedList](https://github.com/shuandroid/LintCode/edit/master/JiuZhang/LinkedList.md)  

### Array  
> 第七次课 array  

**题目**  
* median of two Sorted Array 
* Maximum Subarray  
* Maximum Subarray
* Maximum Subarray II
* Maximum Subarray III
* Minimum Subarray  
* Best time to buy and sell stock 
* find k
* Subarray Sum  
* Subarray Sum Closet
* Two Sum
* Three Sum  
* K Sum  
* Sort Colors
* partition Array
* Sort letter by Cases.  


> 第七次课结束 详情 : [Array](https://github.com/shuandroid/LintCode/edit/master/JiuZhang/Array.md)  

### Data Structure  
> 第八次课  Data Structure  

* 递增栈  
* 递减栈  

**题目：**   
* Largest Rectangle in Histogrm   
* 数字三角形
* happy Number
* rehashing 
* LRU Cache  
* LFU Cache  
* Median Number  

> 第八次课结束 详情 ： [Data Structure](https://github.com/shuandroid/LintCode/edit/master/JiuZhang/DataStructure.md)  

**目前就是这样，如果有可能，以后还会继续添加新的内容**  

**END**  

> chenzhao@hustunique.com  
> Blog:  http://shuandroid.github.io/  
> 算法笔记 欢迎交流学习    
> 以上为自己在算法学习中的一些小收获和记录，不对之处请指出。  


