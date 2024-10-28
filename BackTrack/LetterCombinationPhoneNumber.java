class Solution {
    /* Time Complexity : O(4^n) {phone Numbers - 4 char}*/
    // all Letter Combination of Phone Numbers
    List<String> res;

    // Phone Number Table
    Map<Character, String> phNo;

    public List<String> letterCombinations(String digits) 
    {
        res = new ArrayList<>();

        phNo = new HashMap<>();
        phNo.put('2', "abc");
        phNo.put('3', "def");
        phNo.put('4', "ghi");
        phNo.put('5', "jkl");
        phNo.put('6', "mno");
        phNo.put('7', "pqrs");
        phNo.put('8', "tuv");
        phNo.put('9', "wxyz");

        // check for empty Digits
        if(!digits.isEmpty())
            backTrack(0, digits, new StringBuilder());

        return res;
    }

    void backTrack(int i, String digits, StringBuilder sb)
    {
        // i equals length of digits - One Combination
       if(i == digits.length())
       {
            res.add(sb.toString());
            return;
       }

       // take char for PhoneNumber 
       for(char c : phNo.get(digits.charAt(i)).toCharArray())
       {
            // use cur Char
            sb.append(c);

            // use next Char
            backTrack(i+1, digits, sb);

            // BackTrack : remove lastly used Char
            sb.deleteCharAt(sb.length() - 1);
       }
    }
}