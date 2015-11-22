## DynamicProgramming  第二讲  
动态规划  
*有向图的最短距离，最长距离*  
（与贪婪的区别： 贪婪求当前的最好算法，但结果不一定是最优）.  

>优先使用动态规划解决Dynamic Programming.  

## 参看上节课程记录.  

* 单序列动态规划  
  * state
  * function
  * 
  * 例子： 
    1. palindrome Partitioning II
      state： f[i] : 前i个字符，最少切几次，得到全部的是回文串。  
      functioin : f[]
      answer： f[i] = min{f[j] + 1} , j<i && j + 1 ~ i 是一个回文串.
      回文切割，对字符串进行切割处理，使其得到回文数。  
      单个字符也是一个回文串，切0刀.  
      能切出几个回文串，最少切几次.
    2. 
  

* 区间型动态规划  
 




