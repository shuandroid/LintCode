package com.chen.algorihm.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chen
 * Date : 15-11-12
 * Name : Algorihm
 * 二叉树
 */
public class BinaryTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    /**
     * 先序遍历 : preorderTraversal
     * @param root
     * @return
     */

    /**
     * non-Recursion (Recommend)
     */
    public List<Integer> preorderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null) {
            return preorder;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preorder;
    }

    /**
     * Traverse.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    //把root 为跟的preorder加入到result 里面。
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    /**
     * 分治算法 ： divide and conquer.
     */
    public ArrayList<Integer> preorderTraversalDivide(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //TODO: null and leaf
        if (root == null) {
            return result;
        }
        // TODO: Divide
        ArrayList<Integer> left = preorderTraversalDivide(root.left);
        ArrayList<Integer> right = preorderTraversalDivide(root.right);
        //TODO: Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }


    /**
     * 中序遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null  || !stack.empty()) {
            // get the root.
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            //peek() 查看当前栈元素
            curt = stack.peek();
            stack.pop();//出栈
            result.add(curt.val);
            curt = curt.right;
        }
        return  result;

    }

    /**
     * 后序遍历
     * divide and conquer.
     */
    public ArrayList<Integer> postorderTraversal (TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;

    }

    public ArrayList<Integer> postorderTraversalTwo (TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode previous = null;
        TreeNode current = root;

        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.empty()) {
            current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == previous) {      //traverse up the tree from the left.
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {    //traverse up the tree from the right
                result.add(current.val);
                stack.pop();
            }
            previous = current;
        }

        return result;
    }




}
