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
    // result Diameter of Binary Tree
    private int resDiameter = 0;

    public int dfs(TreeNode root)
    {
        // null Node have -1 Height
        if(root == null)
            return -1;
        
        // Height of left and right subTree
        int left = dfs(root.left);
        int right = dfs(root.right);

        // Diameter = left Height + right Height + 2 (childern)
        resDiameter = Math.max(resDiameter, 2 + left + right);

        // Height = 1 (cur Node) + max left / right
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Bottom - Up approach using DFS
        dfs(root);

        return resDiameter;
    }
}