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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both are null
        if(p == null && q == null)
            return true;

        // one is null
        if(p == null || q == null || p.val != q.val)
            return false;

        // left and right both are Same
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}