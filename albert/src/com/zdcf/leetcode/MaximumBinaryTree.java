package com.zdcf.leetcode;
//654. Maximum Binary Tree
//        Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//
//        The root is the maximum number in the array.
//        The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//        The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//        Construct the maximum tree by the given array and output the root node of this tree.
//
//        Example 1:
//        Input: [3,2,1,6,0,5]
//        Output: return the tree root node representing the following tree:
//
//        6
//        /   \
//        3     5
//        \    /
//        2  0
//        \
//        1
//        Note:
//        The size of the given array will be in the range [1,1000].
public class MaximumBinaryTree {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constract(nums,0,nums.length);
    }
    private TreeNode constract(int[] nums,int l,int r){
        if(l>=r){
            return null;
        }
        int maxi = l;
        for(int i=l+1;i<r;i++){
            if(nums[i]>nums[maxi]){
                maxi = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxi]);
        node.left = constract(nums,l,maxi);
        node.right = constract(nums,maxi+1,r);
        return node;
    }

}