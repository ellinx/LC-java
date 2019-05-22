package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        for (String word:words) {
            if (isMatch(word, pattern)) {
                ret.add(word);
            }
        }
        return ret;
    }
    private boolean isMatch(String word, String pattern) {
        if (word.length()!=pattern.length()) {
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        for (int i=0;i<word.length();i++) {
            char a = word.charAt(i);
            char b = pattern.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a)!=b) {
                    return false;
                }
                continue;
            }
            if (map.values().contains(b)) {
                return false;
            }
            map.put(a,b);
        }
        return true;
    }
}
