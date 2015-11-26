package com.chen.algorihm.DP;

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




}
