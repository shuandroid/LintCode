## Linked list  
**第六次课**  
*加强对Java链表的理解*  


技巧：  
* Duplicating null  

	把一个链表的头，即第一次，在创建一个新的链表，使该链表指向要处理链表的头，  
	即使原来的头，变成现在的第二个。  

* 在一个算法中，可以把一些实现的小功能化的代码，单独拿出来作为一个方法

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

O(nlogn)  

merge sort(归并排序), quick sort(快排), heap sort(堆排序)  
list : merge sort  
array : quick sort  



**题目：**  
  
* Remove Duplicates from  Sored List 
* Remove Duplicates from  Sored List II  
* Reverse Linked List II
* Reverse Linked List #&160;#&160; 反转链表  
* partition list 
* Reorder list 
