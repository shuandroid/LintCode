## Dynamic Programming I
*第四次课*
* 从递归到动归 -Triangle  
 
* 什么样的题适合使用动态规划  
 满足下面三个条件：
  * 求最小最大
  * 求能不能，存不存在
  * 方案总数
 不使用： 
  * 求出所有具体方案，而不是方案个数：
  * 输入的是集合，没有先后关系，而不是序列。

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
* 

## Memorization Search(记忆化搜索)  
动态规划是一种思想， 它解决了重复计算，优化了算法  
与分治区别：  

#### 多重循环 vs 记忆化搜索  
* 多重循环  
 优： 存在优化的可能性  
 缺：不容易思考  
 自底向上：  
  * time complexity:  O(n^2)
  * memory complexity: O(n^2)
 自顶向下：  
  * time complexity : 
  * memory complexity :
* 记忆化搜索  
 优：
 缺：分治


#### 四个要素：  
* 状态 state  
  * 
* 方程：function
* 初始化: initialization
* 答案：answer
 终点，始点

*坐标型动态规划*  

state：
f[x] ：&#160;&#160;表示从起点走到坐标x  
f[x][y]  
functioin: 研究走到x, y这一点前的一步  

intialize : 终点  

题：minimum path sum   
unique paths.  

state ： f[x][y] 从起点到x,y的路径数  
function: (研究倒数第一步) f[x][y] = f[x-1][y] + f[x][y-1]   
intialize: f[0][i] = 1  
f[i][0] = 1  
answer : f[n-1][m-1]  

*题目:*  

unique paths 2.  
climbing stairs.  
jump game. &#160;&#160; jumo game 2.  
two sum.  
scramble String.  
k sum  
backpack  


#Concusion  
* why DP?  
* when DP?
* how DP?  

> 我的问题： 需要重新看一下，之前专业课，老师讲的算法导论和数据结构，一些基本的概念要明白，  
> 熟悉在心。

#### 独孤九剑
初始化一个二维的动态规划时，就去初始化第0行第0列！！！
