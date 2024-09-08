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
    public boolean isSymmetry(TreeNode p, TreeNode q)
    {
        // both are null
        if(p == null && q == null)
            return true;

        // one is null
        if(p == null || q == null || p.val != q.val)
            return false;

        // Symmetry - (left = right) and (rigth = left)
        return (isSymmetry(p.left, q.right) && isSymmetry(p.right, q.left));
    }

    public boolean isSymmetric(TreeNode root) {
        // isSymmetry root, root

        return isSymmetry(root, root);
    }
}