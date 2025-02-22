class SBStack
{
    StringBuilder sb; 
    SBStack()
    {
        // use StringBuilder as Stack
        sb = new StringBuilder();
    }

    // Push : append to SB
    public void push(char ch)
    {
        sb.append(ch);
    }

    // Pop : delete last char SB
    public void pop()
    {
        sb.deleteCharAt(sb.length() - 1);
    }

    // return SB toString
    public String toString()
    {
        return sb.toString();
    }
}

class Solution {
    public String removeStars(String s) {
        SBStack stack = new SBStack();

        for(char ch : s.toCharArray())
        {
            // Encounters '*' remove lastly added Char
            if(ch == '*')
                stack.pop();
            
            // add Char as it is
            else
                stack.push(ch);
        }

        // return Stars Removed String
        return stack.toString();
    }
}