/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
        // InOrder Traversal 
        //      - check all path from Root - Leaf for TargetSum 
        return inorder(root, 0, targetSum);
    }

    public boolean inorder(TreeNode root, int curSum, int targetSum)
    {
        // Null false - no Sum Found
        if(root == null)
        {
           return false;
        }

        // add Value to CurSum
        curSum += root.val;

        // reached Leaf Node
        if(root.left == null && root.right == null)
        {
            // target Sum achived
            return curSum == targetSum;
        }

        // Inorder(left) or Inorder(right)
        return (
            inorder(root.left, curSum, targetSum) || 
            inorder(root.right, curSum, targetSum)
        );
    }
}