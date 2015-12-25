package com.chen.algorihm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

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


    /**
     * Minimum SubArray
     * 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
     * 给出数组[1, -1, -2, 1]，返回 -3
     *
     * @param nums : a list of integers
     * @return : a integer indicate the sum of minimum subArray.
     */
    public int minSubArray(ArrayList<Integer> nums) {

        if (nums == null) {
            return 0;
        }
        int len = nums.size();
        int[] localMin = new int[len];
        int[] globalMin = new int[len];

        //localMin[i] 存放的是当前数到这个地方的所组成的最小值，包含改nums[i]
        //globalMin[i] 存放的是当前数和前面所有的数字组成的数组的最小的和，因此最后一个值为所需要的值
        //还可以通过求该数组的每一个数的相反数，来组成一个新的数组B，而变成求B数组的最大和
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                localMin[0] = globalMin[0] = nums.get(0);
            } else {
                localMin[i] = Math.min(localMin[i - 1] + nums.get(i), nums.get(i));
                globalMin[i] = Math.min(globalMin[i - 1], localMin[i]);
            }
        }

        return globalMin[len - 1];

    }


    /**
     * Best time to buy and sell Stock
     * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
     * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
     * 给出一个数组样例 [3,2,3,1,2], 返回 1
     * 先买后买，寻找最大的利润
     * @param prices : given an integer array
     * @return : Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            //最小的留在min中
            //用i减去前面搜索到的最小的min，比较它和profit的大小，选取大的.
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }

        return profit;
    }


    /**
     * SubArray Sum
     * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
     * 给出 [-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
     * @param nums : a list of integers
     * @return : a list of integers includes the index of the first number
     * and the index of the last number.
     */


    public ArrayList<Integer> subArraySum(int[] nums) {
        int len = nums.length;


        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        //利用了HashMap 的性质，首先map.put(0, -1),键值对，第一个为0 ，后面代表的是位置，-1，
        // 表示后面的数的位置是从0开始的，其中 key：0， value：-1；
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            //map.containsKey(sum), 匹配是否sum为0，因为在前面存入了key：0
            if (map.containsKey(sum)) {

                //匹配到则map.get(sum), 返回的是value,
                //因为value第一个是为-1, 其余各是 i ,(map.put(sum, i), 在后面)所以需要加1
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }

            map.put(sum, i);
        }

        return ans;
    }


    /**
     * SubArray Sum Closest
     * 给定一个整数数组，找到一个和最接近于零的子数组。返回第一个和最有一个指数。
     * 你的代码应该返回满足要求的子数组的起始位置和结束位置
     * @param nums : a list of integers
     * @return :
     */
    public int[] subArraySumClosest(int[] nums) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        if (len == 1) {
            res.add(0);
            res.add(0);
            return turn(res);
        }

        Pair[] sums = new Pair[len + 1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i-1], i);
            prev = sums[i].sum;
        }
        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {

            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                res.clear();
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res.add(temp[0] + 1);
                res.add(temp[1]);
            }
        }

        return turn(res);

    }

    public int[] turn(ArrayList<Integer> res ) {


        int len = res.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = res.get(i);
        }
        return answer;

    }


    class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }

}
