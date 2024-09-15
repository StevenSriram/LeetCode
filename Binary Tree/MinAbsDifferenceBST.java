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
    // Minimum Absolute Difference
    int res = Integer.MAX_VALUE;
    // Previous Node
    TreeNode prev = null;

    public int minAbsoluteDifference(TreeNode root) {
        // Inorder Traversal 
        inorder(root);
        return res;
    }

    void inorder(TreeNode cur)
    {
        if(cur == null)
            return;

        // left SubTree
        inorder(cur.left);

        // find differnce between cur - prev
        if(prev != null)
        {
            // Current is always greater than Previous
            res = Math.min(res, cur.val - prev.val);
        }
        // update prev to cur
        prev = cur;

        // right SubTree
        inorder(cur.right);
    }
}