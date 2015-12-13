## DynamicProgramming  第二讲  
动态规划  
**有向图的最短距离，最长距离**  
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
      initalize : f[i] = i-1,  （初始化） 
      answer： f[i] = min{f[j] + 1} , j<i && j + 1 ~ i 是一个回文串.
      回文切割，对字符串进行切割处理，使其得到回文数。  
      单个字符也是一个回文串，切0刀.  
      能切出几个回文串，最少切几次.
    2. 
  

* 区间型动态规划  
 
* 独孤九剑：破鞭式    
  0的位置单独留出来。  
  * word break.  
   state : f[i]表示前i 个字符是否被完美切割.  
   function :   
   initalize :   
   answer : 

* 双序列动态规划 ： 
  * state :f[i][j] 代表了第一个sequence的前i个数字/字符，配上第二个sequence的前j个...
  * function : f[i][j] = 研究第i个和第j个的匹配关系  
  * initialize : 初始化：f[i][0]和f[]0[j]  
  * answer : f[s1.length][s2.length()].  
 
longest common ancestor  
longest increasing subsequence
edit distance.  
distince subsequence  
interleaving string   
longest Common Subsequence.  最长公共子序列。  
分析： 利用从大到小来一一去掉，到最后相同。  
function: f[i][j] = max{f[i-1][j], f[i][j-1]}     //a[i] == b[j]  
initialize : 

####题目：  
* palindrome Partitioning II.
* word break.
* longest common ancestor
* longest increasing subsequence
* edit distance
* distinct subsequence
* interleaving string
* longest common Subsequence.
