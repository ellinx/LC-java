package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Design a search autocomplete system for a search engine. Users may input a sentence 
(at least one word and end with a special character '#'). 

For each character they type except '#', you need to return the top 3 historical hot sentences 
that have prefix the same as the part of sentence already typed. Here are the specific rules:

1. The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
2. The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). 
	If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
3. If less than 3 hot sentences exist, then just return as many as you can.
4. When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.

Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): 
This is the constructor. The input is historical data. 
Sentences is a string array consists of previously typed sentences. 
Times is the corresponding times a sentence has been typed. 
Your system should record these historical data.

Now, the user wants to input a new sentence. 
The following function will provide the next character the user types:

List<String> input(char c): 
The input c is the next character typed by the user. 
The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). 
Also, the previously typed sentence should be recorded in your system. 
The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.


Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
The system have already tracked down the following sentences and their corresponding times: 
"i love you" : 5 times 
"island" : 3 times 
"ironman" : 2 times 
"i love leetcode" : 2 times 
Now, the user begins another search: 

Operation: input('i') 
Output: ["i love you", "island","i love leetcode"] 
Explanation: 
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. 
Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". 
Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 

Operation: input(' ') 
Output: ["i love you","i love leetcode"] 
Explanation: 
There are only two sentences that have prefix "i ". 

Operation: input('a') 
Output: [] 
Explanation: 
There are no sentences that have prefix "i a". 

Operation: input('#') 
Output: [] 
Explanation: 
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. 
And the following input will be counted as a new search. 

Note:
1. The input sentence will always start with a letter and end with '#', 
	and only one blank space will exist between two words.
2. The number of complete sentences that to be searched won't exceed 100. 
	The length of each sentence including those in the historical data won't exceed 100.
3. Please use double-quote instead of single-quote when you write test cases even for a character input.
4. Please remember to RESET your class variables declared in class AutocompleteSystem, 
	as static/class variables are persisted across multiple test cases. Please see here for more details.
 */

class TrieNode {
    public boolean isWord;
    public Map<Character,TrieNode> children;
    
    public TrieNode() {
        isWord = false;
        children = new HashMap<Character,TrieNode>();
    }
}

class Pair {
    public String k;
    public TrieNode v;
    
    public Pair(String s, TrieNode node) {
        k = s;
        v = node;
    }
}

public class DesignSearchAutocompleteSystem {
    
    private Map<String, Integer> counter;
    private TrieNode root;
    private String prefix; 
    private TrieNode pre;

    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        counter = new HashMap<String, Integer>();
        root = new TrieNode();
        for (int i=0;i<sentences.length;i++) {
            counter.put(sentences[i], times[i]);
            insert(sentences[i]);
        }
        pre = root;
        prefix = "";
    }
    private void insert(String s) {
        TrieNode cur = root;
        for (char c:s.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    public List<String> input(char c) {
        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>(){
            public int compare(String[] a, String[] b) {
                int cnt1 = Integer.parseInt(a[1]);
                int cnt2 = Integer.parseInt(b[1]);
                if (cnt1==cnt2) {
                    return a[0].compareTo(b[0]);
                }
                return cnt2-cnt1;
            }
        });
        if (c=='#') {
            insert(prefix);
            counter.put(prefix, counter.getOrDefault(prefix, 0)+1);
            prefix = "";
            pre = root;
            return new ArrayList<>();
        }
        prefix += c;
        if (pre==null) {
            return new ArrayList<>();
        }
        if (!pre.children.containsKey(c)) {
            pre = null;
            return new ArrayList<>();
        }
        pre = pre.children.get(c);
        List<String> words = getAllWords(prefix,pre);
        for (String s:words) {
            pq.offer(new String[]{s, Integer.toString(counter.get(s))});
        }
        List<String> ret = new ArrayList<>();
        for (int i=0;i<3;i++) {
            if (pq.isEmpty()) {
                break;
            }
            ret.add(pq.poll()[0]);
        }
        return ret;
    }
    private List<String> getAllWords(String s, TrieNode node) {
        List<String> ret = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(s,node));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.v.isWord) {
                ret.add(cur.k);
            }
            for (char c:cur.v.children.keySet()) {
                q.offer(new Pair(cur.k+c, cur.v.children.get(c)));
            }
        }
        return ret;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
