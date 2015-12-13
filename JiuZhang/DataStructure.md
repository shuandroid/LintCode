## Data Structure  
**第八次课**

以它为中心，向左向右，利用递增栈，递减栈   

* 递增栈  
	保持这个栈一直是递增的关系，
	pop一些比push进来的大的数。
	当该数被Pop出去的时候，注意它此时的左右  
	同时可以添加一个-1，因为它比所有的数都低，方便pop出所有的数  


open hash   

close hash

hash Function magic number 33  

LinkedHashMap = DoublyLinkedList + HashMap  
双向链表加hash表  
> 保留了顺序的hashmap.  

 

**java :**  

* hashTable
	线程安全(thread safe)

* hashSet


* HashMap
	线程不安全

hash 删除一个节点：  
需要把它前面的节点和后面的节点连接起来。  

* insert O(1)  
* delete O(1) 


**题目：**   
 
* Largest Rectangle in Histogrm   

	以当前高度为最矮的即高，那么它可以构成的矩形的最大面积，是依次找到
	它左边比它低的，右边比它低的
	利用递增栈(被谁pop出去的，那个数便是它的右边)
	
* 数字三角形

* happy Number

* rehashing  
	hashcode 

* LRU Cache  
	least Recently Used cache(最近不利用的)  
	淘汰策略，  
	[2,1 3,2,5,3,6,7]  
	dummy->null->	

	查询key 是否在这个序列中  
	2->1->3(代表使用的先后顺序)  
	2->1->3 插入2, 发现已有, 1->3->2(从头拿出来放在这里)，利用linkedList

* LFU Cache  
	least frequently Used (最不常用的)


* Median Number  


