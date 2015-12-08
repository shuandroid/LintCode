package com.chen.algorihm.utils;

/**
 * Created by chen
 * Date : 15-11-26
 * Name : Algorihm
 * 单独把ListNode 写出来作为一个基类，方便被其他调用。
 */
public class ListNode  {
    public int val ;
    public ListNode next;

    public ListNode(int values) {
        val = values;
        this.next = null;
    }

}
