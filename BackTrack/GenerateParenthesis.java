class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        // parenthesis, no. pair, open, close, result
        backTrack("", n, 0, 0, res);

        return res;
    }

    void backTrack(String s, int n, int open, int close, List<String> res)
    {
        // Parenthesis generated
        if(s.length() == n*2)
        {
            res.add(s);
            return;
        }

        // open '('  <  no. pair
        if(open < n)
        {
            backTrack(s+"(", n, open+1, close, res);
        }

        // open '('  <  close ')'
        if(close < open)
        {
            backTrack(s+")", n, open, close+1, res);
        }
    }
}