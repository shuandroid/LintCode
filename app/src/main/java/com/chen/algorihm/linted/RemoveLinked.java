package com.chen.algorihm.linted;

/**
 * Created by chen
 * Date : 15-11-12
 * Name : Algorihm
 */
public class RemoveLinked {


    /**
     * remove all elements from a linked list of integers that hava value val.
     * Given 1->2->3->3->4->5->3, val = 3, you should return the list
     * as 1->2->4->5
     */

    /**
     * definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class Solution {
        /**
         * @param head a ListNode
         * @param val  an integer
         * @return a ListNode
         */
        public ListNode removeElements(ListNode head, int val) {
            // Write your code here
            ListNode node = new ListNode(0);
            node.next = head;
            head = node;
            while (head.next != null) {
                if (head.next.val == val) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
            return node.next;
        }
    }
}
