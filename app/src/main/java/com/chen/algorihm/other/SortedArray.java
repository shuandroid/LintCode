package com.chen.algorihm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen
 * Date : 15-11-15
 * Name : Algorihm
 */
public class SortedArray {


    /**
     * 一般的题型可利用暴力来实现，大部分的Time Complexity 为： O(N)
     * 比O(N)更优化的，几乎只有O(log N).
     * 而其的实现方式大部分为二分法。
     * 二分法的主要点：
     * 1. start + 1 < end;  2. mid = start + (end - start) / 2;
     * 3. A[mid] == > < 分开实现
     * 4. 对最后条件的判断，A[start] == target, 或是A[end] == target.
     */


    /**
     * for [4, 5, 1, 2, 3] and target = 1, return 2.
     * for [4, 5, 1, 2, 3] and target = 0, return -1.
     * Time Complexity (时间复杂度) O(log n)
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else  {
                //situation 2
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }


        return -1;
    }
    /**
     * 暴力破解，Time Complexity is O(n)
     * @param A: an integer array
     * @param target: an integer to searched
     * @return
     */
    public boolean searchO(int[] A, int target) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * p is a peak : A[p] > A[p-1] && A[p] > A[p + 1]
     * Given [1, 2, 1, 3, 4, 5, 7, 6] return index 1 (which is number 2) or 6(which is number 7)
     * Time Complexity: O(log N).
     * 利用二分法，可以做到实现时间复杂度为O(long N) 主要是因为，peak 的特性。
     * 利用暴力的话，就是O(n)
     * @param A: an integers array
     * @return : return any of peak positions.
     */
    public int findPeak(int[] A) {
        int start = 1;
        int end = A.length - 2; // 1. the result in mid,
        while (start + 1 < end ) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }

    /**
     * 在矩阵里面: 行、列
     * A[j][i] is a peak :
     * A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
     * Time Complexity is : O(nlog(n))
     * @param A: an integer matrix
     * @return : the index of peak.
     */
    public List<Integer> findPeakII(int[][] A) {

        int low = 1;
        int high =A.length - 2;
        List<Integer> ans = new ArrayList<Integer>();
        while (low <= high) {
            int mid = (low + high) / 2;
            int col = find(mid, A);
            if(A[mid][col] < A[mid - 1][col]) {
                high = mid - 1;
            } else if(A[mid][col] < A[mid + 1][col]) {
                low = mid + 1;
            } else {
                ans.add(mid);
                ans.add(col);
                break;
            }
        }
        return ans;
    }

    int find (int row, int  [][]A) {
        int col = 0;
        for (int i = 0; i < A[row].length; i ++) {
            if (A[row][i] > A[row][col]) {
                col = i;
            }
        }
        return col;
    }


}
