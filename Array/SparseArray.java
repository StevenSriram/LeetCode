class Solution{
     public List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // result Sparse Array
        List<Integer> res = new ArrayList<>();
        
        // count str in stringList
        Map<String, Integer> count = new HashMap<>();
        for(String str : stringList)
        {
            count.put(str, count.getOrDefault(str, 0) + 1);
        }
        
        // check queries count add to sparse Array
        for(String q : queries)
        {
            res.add(count.getOrDefault(q, 0));
        }
        return res;
    }
}