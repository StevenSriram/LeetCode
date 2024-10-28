class Solution {
    // all Parentheses of n
    List<String> res;

    public List<String> generateParenthesis(int n) 
    {
        res = new ArrayList<>();

        // generate parentheses (open, close, no.Pairs, parentheses)
        backTrack(0, 0, n, new StringBuilder());

        return res;
    }

    public void backTrack(int open, int close, int n, StringBuilder sb)
    {
        // Parenthesis generated { ( + ) = 2 * No.Pairs }
        if(sb.length() == 2 * n)
        {
            /* .toString create new String Object  
                    doesn't affected by append, delete int StringBuilder */
            res.add(sb.toString());
            return;
        }

        // only Open Parentheses upto n times {open < n}
        if(open < n)
        {
            // add '(' increase open count
            sb.append('(');
            backTrack(open+1, close, n, sb);

            // BackTrack : remove '(' parentheses
            sb.deleteCharAt(sb.length() - 1);
        }

        // add Closing Parentheses to Match Open Parentheses {open > close}
        if(open > close)
        {
            // add ')' increase close count
            sb.append(')');
            backTrack(open, close+1, n, sb);

            // BackTrack : remove ')' parentheses
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}