package com.chen.algorihm.array;

/**
 * Created by chen
 * Date : 15-12-12
 * Name : Algorihm
 */
public class ArraySolution  {

    //TODO: Array & Number


    /**
     * Median of Two Sorted Array
     * 两个排序的数组A和B分别含有m和n个数，
     * 找到两个排序数组的中位数，要求时间复杂度应为O(log (m+n))。
     * 给出数组A = [1,2,3,4,5,6] B = [2,3,4,5]，中位数3.5
     * 给出数组A = [1,2,3] B = [4,5]，中位数 3
     * @param A :
     * @param B : integer array
     * @return : a double whose format is *.5 or *.0
     */
    //todo : not understand
    public double findMedianSortedArrays(int[]A, int[] B) {

        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (findKth(A, 0, B, 0, len / 2) +
                findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }


    public  static int findKth(int[] A, int A_start, int[] B,
                               int B_start, int  k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1] ;
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }


        int A_key = A_start + k / 2 - 1 < A.length
                ? A[A_start + k / 2 - 1]
                : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length
                ? B[B_start + k / 2 - 1]
                : Integer.MAX_VALUE;
        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }


    /**
     * Maximum Subarray
     * 给定一个整数数组，找到一个具有最大和的子树组，返回其最大和
     * 给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
     *
     * the time complexity is O(n)
     * @param nums : a list of integers
     * @return : A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {

    }



}
