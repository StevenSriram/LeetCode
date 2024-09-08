class Solution {
    public int evalRPN(String[] tokens) {
        // Postfix to Infix Conversion
        Stack<Integer> s = new Stack<>();

        // pop t2 [+-*/] pop t1 = push to Stack
        for(String c : tokens)
        {
            int t1, t2;
            switch(c)
            {
                case "+":
                    t1 = s.pop();
                    t2 = s.pop();

                    s.push(t2 + t1);
                    break;
                 case "-":
                    t1 = s.pop();
                    t2 = s.pop();

                    s.push(t2 - t1);
                    break;
                 case "*":
                    t1 = s.pop();
                    t2 = s.pop();

                    s.push(t2 * t1);
                    break;
                 case "/":
                    t1 = s.pop();
                    t2 = s.pop();

                    s.push(t2 / t1);
                    break;
                default:
                    s.push(Integer.parseInt(c));
            }
        }
        return s.pop();
    }
}