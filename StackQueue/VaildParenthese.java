class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
        {
            // open bracket
            if(c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                //empty invalid - (case for only close)
                if(stack.isEmpty())
                    return false;

                int top = stack.peek();

                // close bracket
                if( (top == '(' && c == ')') ||
                    (top == '[' && c == ']') ||
                    (top == '{' && c == '}') )
                {
                    stack.pop();
                }
                else
                {
                    // Invalid - (case for mismatch)
                    return false;
                }
            }
        }
        // empty Vaild - (case for only open)
        return stack.isEmpty();
    }
}