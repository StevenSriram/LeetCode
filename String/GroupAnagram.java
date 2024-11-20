class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        // Streams.collect Terminal Operation
        //      - Collectors.GroupingBy (return Map)
        Map<String, List<String>> grouped = Arrays.stream(strs)
                    .collect( Collectors.groupingBy( str -> 
                        {
                            // letters to Count Characters
                            int[] letters = new int[26];

                            for(char c : str.toCharArray())
                            {
                                letters[c - 'a']++;
                            }
                            /* 
                                Turn CharacterArray into String - because 
                                Arrays are Not Hashable  

                                * To Store in HashMap KEY must be HASHABLE *
                            */
                            String key = Arrays.toString(letters);

                            // Grouping Anagram Based on Letters Counts
                            return key;
                        } 
                    ) );    
        
        // return only Grouped Values as List
        return grouped.values().stream().toList();

        /* Traditional Way using Map, String
            
            forEach( str -> 
                {
                    int[] letters = new int[26];

                    for(char c : str.toCharArray())
                    {
                        letters[c - 'a']++;
                    }

                    String key = Arrays.toString(letters);

                    // add to Key's Value if present 
                    // else create new List for Key add to it    
                    grouped.computeIfAbsent(key, new ArrayList<>()).add(str);
                } 
        */
    }
}