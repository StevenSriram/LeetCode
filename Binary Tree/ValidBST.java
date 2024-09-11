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
    public boolean isValidBST(TreeNode root) {
        /*
            node's all Left val < Node val
            node's all Right val > Node val
        */
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode root, long min, long max)
    {
        // NULL node True
        if(root == null)
            return true;

        // check Violation of BST property
        if(!(min < root.val && max > root.val))
            return false;

        // check Left and Right SubTree
        return (
            // min - Min and max - Root.val
            valid(root.left, min, root.val) &&
            valid(root.right, root.val, max)
            // min - Root.val and max - max
        );
    }
}