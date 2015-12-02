### Binary  Search Tree  
**二分查找**  
#### Time Complexity 时间复杂度

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
    3. A[mid]==
    4. 

**when and  How**
* 需要优化一个O(n)的暴力算法得到一个更快的算法。
* sorted assry or Rotated Sorted Array.
* 找到第一个,或者是最后一个。

##### 比O(n) 更优化的，几乎只有O(log n).

####Sqrt(x) 

*search insert position*
*search in a big sorted Array.*

**First Bad Version**
* 有重复的元素，和无重复的元素。
    有重复时，不能通过二分法，只能暴力的循环。

**find peak element**  
二分实现  
1. first / last position of xxx
2. 去掉一定没有结果的一半， 保留一定有结果的一半。

O(log n) search target in Rotated sorted Array.

**Recover Rotated Sorted Array.**  
三步翻转法：  
