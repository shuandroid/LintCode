package com.chen.algorihm.linked;

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


}
