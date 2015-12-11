package com.chen.algorihm.linked;

import com.chen.algorihm.utils.ListNode;
import com.chen.algorihm.utils.TreeNode;

/**
 * Created by chen
 * Date : 15-12-5
 * Name : Algorihm
 * a class for linked list
 */
public class LinkedList  {


    /**
     * Remove Duplicates from sorted array
     * sorted array means the array has benn sorted . from small to big.
     * @param nums : a array of integers
     * @return : return an integer
     */
    public int removeDUplicates(int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                size += 1;
                nums[size] = nums[i];
            }
        }

        return size + 1;

    }


    /**
     * Remove Duplicates from sorted array II
     * sorted array means the array has benn sorted . from small to big.
     * This one is allowed two duplicates numbers.
     * 如果可以允许出现两次重复将如何处理？
     * @param nums : a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        int i, j;
        for (i = 0; i < nums.length;) {
            int now = nums[i];
            for (j = i; j < nums.length; j++) {
                if (nums[j] != now) {
                    break;
                }
                if (j -i < 2) {
                    nums[size++] = now;
                }

            }
            i = j;
        }

        return size;

    }


    /**
     * Reverse Linked List 反转链表
     * For linked list 1->2->3, the reversed linked list is 3->2->1
     * @param head : the head of linked list.
     * @return :the new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode previous = null;

        //先让第一个节点指向null(即每个链表的最后都是null),
        //然后把head的下一个节点给temp
        //然后让之前存的previous 作为head 的next
        //让此时的head的节点给previous ,使previous 增加了一个
        //head = temp ,使head的节点向原链表的下一个.

        while (head != null) {
            ListNode temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
        }

        return previous;
    }


    /**
     *  Reverse Linked List II
     *  Given  1->2->3->4->5->NULL, m = 2 and n = 4,
     *  return 1->4->3->2->5->NULL.
     */

    /**
     *
     * @param head : is the head of the linked list
     * @param m :
     * @param n :
     * @return : the head of the reversed ListNode.
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m >= n || head == null) {
            return head;
        }

        // 利用好特性
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // 先找到m 位置对应的前节点
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        //前节点
        ListNode premNode = head;
        //pre 的下一个节点
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode temp;
        ListNode postNode = mNode.next;
        //翻转指定位置的链表
        for (int i = m; i < n; i++) {
            if (postNode == null) {
                return null;
            }
            temp = postNode.next;
            postNode.next = nNode;
            nNode = postNode;
            postNode = temp;
        }
        mNode.next = postNode;
        premNode.next = nNode;

        return dummy.next;

    }


    /**
     *  Partition List 划分链表
     *  给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
     *  你应该保留两部分内链表节点原有的相对顺序
     *  给定链表 1->4->3->2->5->2->null，并且 x=3
     *  返回 1->2->2->4->3->5->null
     * @param head :
     * @param x :
     * @return :
     */
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return  null;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;

            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;

    }


    /**
     * Recorder List 重排链表
     * 给定一个单链表L： L0→L1→…→Ln-1→Ln,
     * 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 必须在不改变节点值的情况下进行原地操作
     * 给出链表1->2->3->4->null，重新排列后为1->4->2->3->null
     *
     * @param head : the head of linked list
     */
    public void reorderList(ListNode head) {

        //需要反转和寻找中间数
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode tail = reverse2(mid.next);
        mid.next = null;

        //此时head 和tail 各只有一半
        merge(head, tail);
    }

    //思想和上面的一样，是反转链表的作用
    private ListNode reverse2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    //利用双指针来实现找到中点的方法
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    //合并两个listNode，分单双的分别拿出其中的一个
    private void merge(ListNode headOne, ListNode headTwo) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (headOne != null && headTwo != null) {
            if (index % 2 == 0) {
                dummy.next = headOne;
                headOne = headOne.next;
            } else {
                dummy.next = headTwo;
                headTwo = headTwo.next;
            }
            dummy = dummy.next;
            index++;
        }
        if (headOne != null) {
            dummy.next = headOne;
        } else {
            dummy.next = headTwo;
        }

    }

    /**
     * Linked list Cycle
     * 利用双指针，一块，一慢，若他们能够相遇，则，该链表有环.
     * 思想和上面的差不多.
     * @param head : the head of linked list
     * @return : weather it has a cycle or not
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    /**
     * Linked list Cycle II
     * solve it without using extra space
     * 给定一个链表，如果链表中存在环，则返回到链表中环的起始节点的值，如果没有环，返回null。
     * @param head : the first of linked list
     * @return :
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        //也是利用双指针的作用
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        //运行到这里，说明是fast == slow, 说明环出现，
        //此时，执行while 循环，最终相遇的地方肯定是环的开始节点
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }


    /**
     * Rotate List
     * 给出链表1->2->3->4->5->null和k=2
     * 返回4->5->1->2->3->null
     * 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
     *
     * @param head : the list
     * @param k : rotate to the right k places
     * @return : the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode tail = dummy;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }

        /**while 后，tail 指向倒数第k + 1 个节点(3)。head 在最后的节点(5)，且head.next == null .**/

        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }

        /**head.next 由原来的Null, 指向原链表的头(1)**/
        /**然后tail 的next 为（4， 5）， 即此时为 0->4->5->1->2->3->4->5**/
        /**然后使tail.next 为null, 即节点3后为null, 这样的话， 聊表为0->4->5->1->2->3->null **/
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;

        return dummy.next;

    }

    /**获取链表的长度**/
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }


    /**
     * Copy List with Random Pointer
     * 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点
     * 利用 O(1) 的空间.
     * @param head : the head of linked list with a random pointer
     * @return : a new head of a deep copy of the list
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }


    public class RandomListNode  {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }

    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }


    /**
     * COnvert Sorted List To Binary Search Tree.
     * @param head :
     * @return :
     */

    private ListNode current;
    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);
        return sortedListToBSTHelper(size);
    }

    private TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }


}
