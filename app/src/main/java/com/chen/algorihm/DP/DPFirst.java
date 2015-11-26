package com.chen.algorihm.DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by chen
 * Date : 15-11-26
 * Name : Algorihm
 */
public class DPFirst  {

    /**
     * Unique paths.
     * 在网格里寻找向右下脚移动的路径.
     * methods : sum[i][j] = sum[i-1][j] + sum[i][j-1]
     * @param m : positive integer
     * @param n : positive integer
     * @return : an integer.
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        //initialize the data.
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1];
            }
        }

        return sum[m-1][n-1];
    }

    /**
     * from unique paths.
     * add obstacle in grid. obstacle is 1; others is 0.
     * 总体思想和第一种 unique paths 相同.
     * @param obstacleGrid : a list of lists of integers.
     * @return : an integer.
     */
    public int uniquePathsWithObtacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 ) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];

        for (int i = 0;i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j =1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                } else {
                    paths[i][j] = 0;
                }
            }
        }

        return paths[n - 1][m - 1];

    }


    /**
     * Each element in the array represents your maximum jump length at that position.
     * A = [2,3,1,1,4], return true.
     * A = [3,2,1,0,4], return false.
     * @param A : a list of integers
     * @return : the boolean answer.
     */
    //TODO: use Dynamic Programming, and time complexity is O(n^2).
    public boolean canJUmp(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        boolean[] can = new boolean[A.length];
        can[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                //j can arrive and can jump to 1.
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[A.length - 1];
    }

    //TODO: use Greedy ,and time complexity is O(n).
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            // i <= farthest and make the farthest can arrive at the end.
            if (i <= farthest && A[i] + i >= farthest) {
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }

    /**
     * Jump game II
     * Each element in the array represents your maximum jump length at that position.
     * to reach the last index in the minimum number of jumps
     * @param A : a list of lists of integers.
     * @return : an integer.
     */

    //TODO: use Dynamic Programming, and time complexity is O(n^2).
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] steps = new int[A.length];
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }

        }
        return steps[A.length - 1];
    }

    //TODO: use Greedy.
    public int jumpTwo(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jump = 0;
        //对当前元素进行一个区域的划分，不断计算A[i] + i最大值，在区域里使其达到最大值.
        while (end < A.length - 1) {
            jump++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jump;
    }


    /**
     * Two Sum.
     * numbers=[2, 7, 11, 15],  target=9,
     * return [1, 2].
     * @param numbers : an array of integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1]
     */
    public int[] twoSumHashmap (int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i], i + 1);

        }

        for (int i = 0; i < numbers.length; i++) {
            // if the hashMap has the values of the key.
            if (hashMap.containsKey( target - numbers[i])) {
                int index = i + 1;
                // the values has already added 1.
                int indexS = hashMap.get(target - numbers[i]);
                if (index == indexS) {
                    continue;
                }
                result[0] = index;
                result[1] = indexS;
                return result;
            }
        }

        return result;
    }

    public int[] twoSumPointer(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return null;
        }
        // array the list for numbers from little to big.
        //TODO： there are still other questions about the sort about Array.
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        int[] rst = new int[2];

        while( left < right){
            int sum = numbers[left] +  numbers[right];
            if( sum == target){
                rst[0] = left + 1;
                rst[1] = right + 1;
                break;
            }else if( sum < target){
                left++;
            }else{
                right--;
            }
        }
        return rst;
    }

    /**
     * Scramble String.
     * TODO: not finish.
     * @param s1 : a string
     * @param s2 : another string
     * @return : whether s2 is a scrambled string of s1.
     */
    public boolean isScramable(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 || s2.equals(s1)) {
            return false;
        }

        int n = s1.length();
        boolean[][][] result = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        return false;
    }


    /**
     * K Sum .
     * 给定n个不同的正整数，整数k（k < = n）以及一个目标数字
     * 在这n个数里面找出K个数，使得这K个数的和等于目标数字，求问有多少种方案
     * find k numbers where sum is target. Calculate how many solutions there are.
     * Example : Given [1,2,3,4], k = 2, target = 5.
     * There are 2 solutions: [1,4] and [2,3].
     * Return 2.
     * TODO : not understand, waiting for thinking.
     * @param A : an integer array.
     * @param k : a positive integer.
     * @param target : an integer
     * @return : an integer.
     */
    public int kSum (int A[], int k, int target) {
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    f[i][j][t] = 0;
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];
                    }
                    f[i][j][t] += f[i - 1][j][t];
                }
            }
        }
        return f[n][k][target];

    }

    /**
     * BackPack .背包问题
     * how full you can fill this backpack.
     * @param m : an integer m denotes the size of a backPack.
     * @param A : given n items with size A[i]
     * @return : the maximum size.
     */
    public int backPack (int m, int[] A) {

        boolean f[][] = new boolean[A.length + 1][m+1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= A[i] && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
            }
        }

        for (int i =m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
    }




}
