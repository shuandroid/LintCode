package com.chen.algorihm.DP;

import com.chen.algorihm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Set;

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


    /**
     * Word Break
     * given s = "lintcode" , dictionary = ["lint", "code"]
     * return true because "lintcode" can be break as "lint code"
     * 思想 ：
     * @param s : a string s
     * @param dictionary : a dictionary of words dictionary.
     * @return : true or false
     */
    public boolean wordBreak(String s, Set<String> dictionary) {

        //Set<> 为同种对象的集合, Set<String> 是指是String对象的集合
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLength = getMaxLength(dictionary);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i;
                    lastWordLength++) {
                //TODO :  在动态规划中， 考虑的都是到i这个位置时，前面所形成的 A 是否符合要求，
                //todo: 而不是从i 到后面的一些位置所形成的 B 是否符合要求
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dictionary.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
    }
    /**
     *  to get the longest string in dictionary.
     */
    private int getMaxLength(Set<String> dictionary) {
        int maxLength = 0;
        for (String word : dictionary) {
            maxLength = Math.max(maxLength, word.length());
        }

        return maxLength;
    }

    /**
     *  Lowest Common Ancestor
     *  求两个节点(nodes)的最近公共祖先, 父节点.
     * @param root : the root of the binary search tree
     * @param A & B : two nodes in a binary.
     * @return : return the least common ancestor(LCA) of the two nodes.
     */
    //TODO : divide and conquer 分治
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {

        if (root == null || root == A || root == B) {
            return root;
        }
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        //conquer
        if (left != null && right != null ) {
            return root;
        }
        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }



}
