class TrieNode
{
    boolean isLeaf;
    TrieNode[] children;
    public TrieNode()
    {
        isLeaf = false;
        children = new TrieNode[26];
    }
}
public class WordDictionary
{
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary()
    {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word)
    {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word)
    {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int k, TrieNode node)
    {
        if(node == null)
            return false;
        else if(k == word.length())
            return node.isLeaf;
        
        char c = word.charAt(k);
        if(c == '.')
        {
            for(int i = 0; i < node.children.length; i++)
            {
                if(node.children[i] != null)
                    if(search(word, k + 1, node.children[i]))
                        return true;
            }
            return false;
        }
        else
        {
            if(node.children[c - 'a'] != null)
                return search(word, k + 1, node.children[c - 'a']);
            else
                return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
