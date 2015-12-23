package com.chen.algorihm.array;

import java.util.ArrayList;

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
    //利用了贪婪算法 greed.
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;

    }

    //minSum 占据了一个很大的位置，它是前面所有数组里面加之后的最小的那一个值
    //因为sum一直在加，从第一个到最后一个，当遇到所要寻找的，条件必然不是
    //max(max, sum) 而应该是max(max, sum - minSum),
    //即把最小的sum(旧的) 的值再次用sum(新的)减去，意义便是此时sum - minSum,
    //是我们需要的几个数的数组，把之前的几个去掉。得到需要的最大和max.
    public int maxSubArrayDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }

    /**
     * Maximum SubArray II
     * 给定一个整数数组，找出两个不重叠子数组使得它们的和最大。
     * 每个子数组的数字在数组中的位置应该是连续的
     * return 最大的和
     * 要求 Time Complexity is O(n)
     *
     * @param nums : a list of integers
     * @return : an integer denotes the sum of max two array.
     */

    //思想： 这两个数组不是重叠的，必然是把一个大数组，分为两个小数组，
    //不防假设一个从第一个开始向右出发，另外一个从最后一个向左出发。

    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;

        //left[i] 表示从第一个到第i个数组成的数组，的Maximum subArray.

        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }

        //同理求处另外一个数组
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        //right[i] 表示从第i个数到最后一个数组成的数组的Maximum SubArray.
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;

        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;

    }


    /**
     * Maximum SubArray III
     * 给定一个整数数组和一个整数k，找出k个不重叠子数组使得它们的和最大。
     * 每个子数组的数字在数组中的位置应该是连续的。
     * 返回最大的和。
     *
     * @param nums : a list of integers
     * @param k : an integer denote to find k subArray
     * @return : an integer the sum of k subArray
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {

        int len = nums.size();
        int[][] f = new int[k + 1][len];
        for (int i = 1; i < k + 1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums.get(i);

            }
            f[i][i + 1] = sum;
        }

        for (int i = 1; i < len; i++) {
            f[1][i] = Math.max(f[1][i - 1] + nums.get(i), nums.get(i));
        }

        for (int i = 2; i < k + 1; i++) {
            for (int n = i;  n< len; n++) {
                int curMax = f[i][n-1] + nums.get(n);
                for (int j = i-2; j < n; j++) {
                    if ((f[i-1][j] + nums.get(n)) > curMax) {
                        curMax = f[i-1][j] + nums.get(n);
                    }
                }
                f[i][n] = curMax;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = k-1; i < len; i++){
            if (f[k][i] > res) {
                res = f[k][i];
            }
        }
        return res;
    }




}
