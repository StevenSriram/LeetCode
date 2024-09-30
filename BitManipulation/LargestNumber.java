class Solution {
    public String largestNumber(int[] nums) 
    {
        // return as String because Number is to Long
        List<String> str = new ArrayList<>();

        // turn each Number into String and add to List
        for(int n : nums)
        {
            str.add(String.valueOf(n));
        }
        // sort - Decesending order
        Collections.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // [0, 0, 0] => "0"
        if(str.get(0).equals("0"))  
            return "0";

        // Join List into String
        return String.join("", str);
    }
}