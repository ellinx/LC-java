package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, 
 * words: ["This", "is", "an", "example", "of", "text", "justification."] 
 * L: 16.
 * 
 * Return the formatted lines as: 
 * [ 	"This is an", 
 * 		"example of text",
 * 		"justification. " ] 
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * 
 * Corner Cases: A line other than the last line might contain only one word.
 * What should you do in this case? In this case, that line should be
 * left-justified.
 * 
 *
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (maxWidth==0) {
            res.add(new String());
            return res;
        }  
        
        int start = 0;
        int end = 0;
        while (start < words.length) {
            int curLength = -1;
            for (end=start;end<words.length;end++) {
                curLength += words[end].length()+1;
                if (curLength > maxWidth) {
                    end--;
                    break;
                }
            }
            if (end==words.length)
                end--;
            //System.out.println("start="+start+",end="+end);
            res.add(helper(words, maxWidth, start, end, (end==words.length-1)));
            start = end+1;
        }
        return res;
    }
    
    private String helper(String[] words, int maxWidth, int start, int end, boolean isLast) {
        StringBuilder sb = new StringBuilder(words[start]);
        int space = maxWidth-words[start].length();
        if (isLast || start==end) {
            for (int i=start+1;i<=end;i++) {
                sb.append(" ").append(words[i]);
                space -= 1+words[i].length();
            }
            for (int i=0;i<space;i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        
        for (int i=start+1;i<=end;i++) {
            space -= words[i].length();
        }
        int extraSpace = space%(end-start);
        space /= (end-start);
        StringBuilder sb1 = new StringBuilder();
        for (int i=0;i<space;i++) {
            sb1.append(" ");
        }
        String sep = sb1.toString();
        for (int i=start+1;i<=end;i++) {
            if (extraSpace>0) {
                sb.append(" ").append(sep).append(words[i]);
                extraSpace--;
            } else {
                sb.append(sep).append(words[i]);
            }
        }
        return sb.toString();
    }
    
    //test
    public static void main(String[] args) {
    	TextJustification tj = new TextJustification();
    	String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    	List<String> result = tj.fullJustify(words, 16);
    	System.out.println(result.toString());
	}
}
