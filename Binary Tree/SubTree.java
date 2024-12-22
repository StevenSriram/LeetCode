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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        // Root is NULL - not SubTree
        if(root == null)
            return false;

        // SubRoot is NULL - subTree
        if(subRoot == null)
            return true;
        
        // root, subRoot - SameTree
        if(isSameTree(root, subRoot))
            return true;

        // check (LeftTree, subRoot) OR (RightTree, subRoot)
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        // Both NULL - Same Tree
        if(p == null && q == null)
            return true;

        // one is Null OR Val different - Not Same Tree
        if(p == null || q == null || p.val != q.val)
        {
            return false;
        }

        // check (pLeft, qLeft) AND (pRight, qRight)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}