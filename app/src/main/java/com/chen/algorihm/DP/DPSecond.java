package com.chen.algorihm.DP;

import java.util.ArrayList;

/**
 * Created by chen
 * Date : 15-12-1
 * Name : Algorihm
 */
public class DPSecond  {


    /**
     * Palindrome Partitioning 分割回文串
     * 返回所有可能的回文串分割方案
     * Given s = "aab"
     * @param s : a string
     * @return : a list of lists of string
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return result;
        }

        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result);
        return result;
    }

    private boolean isPalindrome(String s) {
        int beg = 0;
        int end = s.length() -1;
        while (beg < end) {
            // whether  the first equal the last or not.
            //只要有一个不同，则返回false.
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }

    private void helper (String s, ArrayList<String> path, int position,
                         ArrayList<ArrayList<String>> result) {
        if (position == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = position + 1; i <= s.length(); i++) {
            String prefix = s.substring(position, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            path.add(prefix);
            //在i位置的所有可能的子回文串
            helper(s, path, i, result);
            path.remove(path.size() - 1);

        }
    }

    /**
     * Palindrome Partitioning II
     *  给出一个字符串s，将s分割为一些子串， 使每个子串都是回文
     *  返回s符合要求的最小分割次数.
     *  given a string s,cut s into some subStrings such that every
     *  subString is a palindrome.
     *  return the minimum cuts needed for a palindrome partitioning
     *  of s.
     *  TODO: don't understand.
     * @param s : a string.
     * @return : an integer.
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //preparation
        boolean[][] isPalindrome = getIsPalindrome(s);
        //initialize
        int[] f = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            f[i] = i - 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++){
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[s.length()];
    }
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j;i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0;i < s.length();i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int length = 2; length < s.length();length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                        = isPalindrome[start + 1][start + length - 1]
                        && s.charAt(start) == s.charAt(start + length);
            }
        }
        return isPalindrome;
    }

}
