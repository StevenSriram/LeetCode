/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
            Lowest Common Ancestor - Time : O( log n )
                / Node itself be descendant \
        */
        TreeNode cur = root;

        while(cur != null)
        {
            // p and q both are Greater than cur - Search on Right
            if (p.val > cur.val && q.val > cur.val)
            {
                cur = cur.right;
            }
            // p and q both are Lesser than cur - Search on Left
            else if (p.val < cur.val && q.val < cur.val)
            {
                cur = cur.left;
            }
            // Split occurs return cur (LCA)
            else
            {
                break;
            }
        }
        return cur;
    }
}