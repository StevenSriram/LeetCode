class Solution {
    // Result Letter Combinations
    List<String> res;

    // Phone Number Table
    Map<Character, String> phNo;

    public List<String> letterCombinations(String digits) {
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
        if(digits.length() != 0)
            backTrack(0, "", digits);

        return res;
    }

    void backTrack(int i, String curStr, String digits)
    {
        // CurString length = Digits length
        if(curStr.length() == digits.length())
        {
            // add letter
            res.add(curStr);
            return;
        }

        // for each char Phone Number
        for(char c : phNo.get(digits.charAt(i)).toCharArray())
        {
            // BackTrack( nextIndex, curStr + char ) 
            backTrack(i + 1, curStr + c, digits);
        }
    }
}