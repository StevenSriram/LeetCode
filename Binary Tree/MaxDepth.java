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
    // Level Order Traversal - BFS
    public int maxDepth(TreeNode root) 
    {
        // Empty Tree - 0 Height
        if(root == null)
            return 0;

        // Maximum Depth of Binary Tree
        int maxDepth = 0;

        // Queue for BFS - add root
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        // Queue is not Empty
        while(! q.isEmpty())
        {
            // Width of cur Level
            int qLen = q.size();

            for(int i = 0; i < qLen; i++)
            {
                // remove from Queue
                TreeNode cur = q.poll();

                // check Left and Right Not Null - add to Queue
                if(cur.left != null)
                    q.offer(cur.left);

                if(cur.right != null)
                    q.offer(cur.right);
            }

            // move to Next Level
            maxDepth++;
        }

        // No. Levels equals to Max Depth
        return maxDepth;
    }
}