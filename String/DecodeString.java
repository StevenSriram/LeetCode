class Solution {
    public String decodeString(String s) 
    {
        // Stack of Characters
        Deque<Character> stack = new ArrayDeque<>();

        // Traverse through each char
        for (char ch : s.toCharArray()) 
        {
            if (ch != ']') 
            {
                // push any char other than ']'
                stack.push(ch); 
            }
            else 
            {
                StringBuilder cur = new StringBuilder();

                // pop curString until '[' 
                while (!stack.isEmpty() && stack.peek() != '[') 
                {
                    // add to beginning of String
                    cur.insert(0, stack.pop()); 
                }
                // pop '[' character
                stack.pop(); 

                int num = 0;
                int mul = 1;  // Multiplier for (ones, Tens, Hundreds)

                // pop curNumber until Digits
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) 
                {
                    /*
                        Stack Number is reversed Form,
                            Peek * Multiplier + Number 
                    */
                    num = (stack.pop() - '0') * mul + num;

                    // move to next Pos
                    mul *= 10; 
                }

                // Repeat String N times - add to Stack
                String repeated = cur.toString().repeat(num);

                for (char c : repeated.toCharArray()) 
                    stack.push(c);
            }
        }

        // construct Decoded String
        StringBuilder decoded = new StringBuilder();
        while (!stack.isEmpty()) 
        {
            decoded.insert(0, stack.pop());
        }

        return decoded.toString(); 
    }
}
