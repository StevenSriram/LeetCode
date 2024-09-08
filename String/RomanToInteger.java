class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        
        // Roman Numeral Table
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        // Roman to Integer
        int num = 0;

        int i=0;
        while(i < n)
        {
            /*
                Roman Numerals has property that 
                    First char is less than Second char Subract them
                ( IV - 4 {V:5, I:1} = 5-1)
            */
            if(i < n-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
            {
                num += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i += 2;
            }
            else
            {
                num += map.get(s.charAt(i));
                i++;
            }
        }
        return num;
    }
}