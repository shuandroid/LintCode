package com.chen.algorihm.other;

/**
 * Created by chen
 * Date : 15-11-12
 * Name : Algorihm
 */
public class Solution  {


    /**
     * A Fibonacci sequence is defined as follow:
     * the first two number are 0 and 1.
     * the i th number is the sum of i-1 th number and
     * i-2 th number.
     *  0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {

        int a = 0;
        int b = 1;
        int sum = 0;
        if (0 == n || 1 == n) {
            return 0;
        }
        if (2 == n) {
            return 1;
        }
        for(int i = 1; i < n - 1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    /**
     * example: a = 11, b = 1; return 100.
     * @param a : a binary number
     * @param b : a binary number
     * @return: return the result.
     */
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;
        String rst = "";

        while (pb >= 0) {
            int sum = (int)(a.charAt(pa) - '0') +
                    (int)(b.charAt(pb) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa--;
            pb--;
        }
        while (pa >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa--;
        }

        if (carries == 1) {
            rst = "1" + rst;
        }
        return rst;
    }



}
