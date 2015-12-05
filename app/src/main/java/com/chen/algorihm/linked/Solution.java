package com.chen.algorihm.linked;

/**
 * Created by chen
 * Date : 15-11-12
 * Name : Algorihm
 */
public class Solution {

    /**
     * given 7->1->6 + 5->9->2, that is 617 + 295.
     * return 2->1->9, that is 912.
     * definition for singly-linked list
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     *
     * @param listNodeFirst: the first list
     * @param listNodeSecond: the second list
     * @return: the sum list of listNodeFirst and listNodeSecond
     */
    public ListNode addList(ListNode listNodeFirst, ListNode listNodeSecond) {
        if (listNodeFirst == null && listNodeSecond == null) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode point = node;
        int carry = 0;
        while (listNodeFirst != null && listNodeSecond != null) {
            int sum = carry + listNodeFirst.val + listNodeSecond.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            listNodeFirst = listNodeFirst.next;
            listNodeSecond = listNodeSecond.next;
            point = point.next;
        }
        while (listNodeFirst != null) {
            int sum = carry + listNodeFirst.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            listNodeFirst = listNodeFirst.next;
            point = point.next;
        }
        while (listNodeSecond != null) {
            int sum = carry + listNodeSecond.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            listNodeSecond = listNodeSecond.next;
            point = point.next;
        }

        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return node.next;
    }


}
