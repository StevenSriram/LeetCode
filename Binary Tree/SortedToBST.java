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
    public TreeNode sortedArrayToBST(int[] nums)
    {
        // to Balanced Binary Search Tree
        return toBalanced(nums, 0, nums.length - 1);
    }

    public TreeNode toBalanced(int[] nums, int l, int r)
    {
        /* Two Pointers - L and R */

        // cross Over - Null
        if(l > r)
            return null;

        // calculate Mid make as Root
        int mid = (l + r) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // mid on Left sorted Array - add to root.ledt
        root.left = toBalanced(nums, l, mid - 1);

        // mid on Right sorted Array - add to root.right
        root.right = toBalanced(nums, mid + 1, r);

        // return root of Balanced BST
        return root;
    }
}