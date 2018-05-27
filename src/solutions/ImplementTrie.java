package solutions;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author Ellinx
 *
 */
class Trie {
    class TrieNode {
        public boolean isWord;
        public TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c-'a']==null)
                cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c-'a']==null)
                return false;
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c-'a']==null)
                return false;
            cur = cur.children[c-'a'];
        }
        if (cur.isWord)
            return true;
        for (int i=0;i<26;i++) {
            if (cur.children[i]!=null)
                return true;
        }
        return false;
    }
    
    //test
    public static void main(String[] args) {
    	Trie obj = new Trie();
    	obj.insert("abcd");
    	System.out.println(obj.search("abcd"));
    	System.out.println(obj.startsWith("abcd"));
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */