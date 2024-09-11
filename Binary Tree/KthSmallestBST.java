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
    // count of node
    int count = 0;

    public void inorder(TreeNode root, int k, int[] res)
    {
        // NULL or count exceeds K
        if(root == null || count >= k)
            return;

        // inorder left subTree
        inorder(root.left, k, res);

        // increment Count
        count++;
        // check for Kth element
        if(count == k)
        {
            res[0] = root.val;
            return;
        }

        // inorder right subTree
        inorder(root.right, k, res);
    }

    public int kthSmallest(TreeNode root, int k) {
        // create Array result to pass Reference
        int[] res = new int[]{Integer.MIN_VALUE};

        /*
            Kth Smallest - inorder() : Left - Right
            Kth largest - reverseInorder() : Right - Left
        */

        // perform inorder Traversal K' times
        inorder(root, k, res);

        // return kth Smallest Element
        return res[0];
    }
}