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
    // check Binary Tree Balanced
    boolean balanced = true;

    public boolean isBalanced(TreeNode root)
    {
        // Depth Of Each Node
        depthBalanced(root);

        // return Tree is Balanced
        return balanced;
    }

    public int depthBalanced(TreeNode root)
    {
        // Tree is Not Balanced - return itself
        if(!balanced)
            return 0;

        // Null node - return 0
        if(root == null)
            return 0;

        // Left Node height
        int left = depthBalanced(root.left);

        // Right Node height
        int right = depthBalanced(root.right);

        // calculate Balance factor of each Node
        int bF = (left - right);

        /*  Tree is said to Balanced, if balance factor
                is eithier [-1, 0, 1]

                    N(-1)      N(0)        N(1)
                /            /    \          \
                N           N       N           N
        */
        if(bF != -1 && bF != 0 && bF != 1)
        {
            balanced = false;
            return 0;
        }

        // return cur Height
        return 1 + Math.max(left, right);
    }
}