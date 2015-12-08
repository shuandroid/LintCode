package com.chen.algorihm.linked;

import com.chen.algorihm.utils.ListNode;

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



}
