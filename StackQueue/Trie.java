class Trie {
    // Each node has 26 children [a - z]
    private Trie[] chars;

    // Represents End of a Word
    private String word;

    public Trie() 
    {
        this.chars = new Trie[26];
        this.word = null;
    }

    public void insert(String word) 
    {
        // Start from root of Trie
        Trie cur = this;

        // Traverse each character in word
        for (char ch : word.toCharArray()) 
        {
            int idx = ch - 'a'; 

            // If no Child exists, create new Trie node
            if (cur.chars[idx] == null)
                cur.chars[idx] = new Trie();

            // Move to the Child node
            cur = cur.chars[idx];
        }

        // Mark end of the word by storing it
        cur.word = word;

        /* Java : Class can access Private fields and methods
                     of any other Object of the Same Class. */
    }

    public boolean search(String word) 
    {
        Trie cur = this;

        for (char ch : word.toCharArray()) 
        {
            int idx = ch - 'a';

            // If no Child exists, the Word doesn't Exist
            if (cur.chars[idx] == null)
                return false;

            cur = cur.chars[idx];
        }

        // curNode marks end ? TRUE : FALSE
        return cur.word != null;
    }

    // Trie (Prefix) : Efficient for Searching Prefixes
    public boolean startsWith(String prefix) 
    {
        /* Same as Seach Word */
        Trie cur = this;

        for (char ch : prefix.toCharArray()) 
        {
            int idx = ch - 'a';

            if (cur.chars[idx] == null)
                return false;

            cur = cur.chars[idx];
        }

        // All prefix characters matched
        return true;
    }

    // Print all stored words
    public void print() 
    {
        print(this);
    }

    // Recursive DFS to print all words in the Trie
    private void print(Trie node) 
    {
        // Base case: if node is null, return
        if (node == null)
            return;

        // If a complete word is stored at this node, print it
        if (node.word != null) 
        {
            System.out.println(node.word);
        }

        // Print all non-null children
        for (int i = 0; i < 26; i++) 
        {
            if (node.chars[i] != null)
                print(node.chars[i]);
        }
    }
}
