package com.chen.algorihm.other;

/**
 * Created by chen
 * Date : 15-11-14
 * Name : Algorihm
 */
public class Binary {


    /**
     * 排序列表转化为二分查找树：
     * 给出一个所有元素以升序排序的单链表，
     * 将它转换为一棵高度平衡的二分查找树(BST)
     *
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        //计算链表的长度
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;
        current = head;
        size = getListLength(head);
        return sortedListToBSTHelper(size);
    }

    /**
     *BST 排序
     * 递归
     */
    //TODO： how to dandle it has not understand.
    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;

    }


    /**
     *  Given a binary tree, find its minimum depth.
     *  二叉树的最小深度: 从root到叶子节点的最小路径。
     *      1
     *    /   \
     *   2    3
     *       / \
     *      4   5
     *  the minimum depth is 2. the maximum is depth is 3.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    /**]
     * 依次求每个子树的最大深度。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


}
