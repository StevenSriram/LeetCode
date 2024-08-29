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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // empty return []
        if(root == null)
            return res;

        // Queue for BFS traversal on each level
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            // count number of node at this level
            int qLen = q.size();

            // current level traversal
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<qLen; i++)
            {
                TreeNode cur = q.poll();

                // add to current level
                level.add(cur.val);

                // add children to Queue
                if(cur.left != null)
                {
                    q.offer(cur.left);
                }
                if(cur.right != null)
                {
                    q.offer(cur.right);
                }
            }

            // if odd level reverse - current level
            if(res.size() % 2 != 0)
            {
                Collections.reverse(level);
            }
            // add to level order traversal
            res.add(level);
        }
        return res;
    }
}