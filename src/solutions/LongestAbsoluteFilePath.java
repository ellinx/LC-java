package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Suppose we abstract our file system by a string in the following manner:
 * 
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * 
 * dir 
 * 		subdir1 
 * 		subdir2 
 * 			file.ext 
 * 
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 * 
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * 
 * dir 
 * 		subdir1 
 * 			file1.ext 
 * 			subsubdir1 
 * 		subdir2 
 * 			subsubdir2 
 * 				file2.ext 
 * 
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext 
 * and an empty second-level sub-directory subsubdir1. 
 * subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 * 
 * We are interested in finding the longest (number of characters) absolute path
 * to a file within our file system. For example, in the second example above,
 * the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its
 * length is 32 (not including the double quotes).
 * 
 * Given a string representing the file system in the above format, return the
 * length of the longest absolute path to file in the abstracted file system. If
 * there is no file in the system, return 0.
 * 
 * Note: The name of a file contains at least a . and an extension. The name of
 * a directory or sub-directory will not contain a .. Time complexity required:
 * O(n) where n is the size of the input string.
 * 
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is
 * another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 * 
 * @author Ellinx
 *
 */
public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
		if (input.isEmpty()) return 0;
        Stack<String> path = new Stack<>();
        Stack<Integer> pathLength = new Stack<>();
        int index = 0;
        int maxLength = 0;
        while (index<input.length()) {
        	if (input.charAt(index)=='\n') {
        		int tab = 0;
        		int i = 0;
        		//find how many tabs
        		for (i=1;input.charAt(index+i)=='\t';i++) {
        			tab++;
        		}
        		index += i;
        		
        		int end = index+1;
        		boolean isFile = false;
        		while (end<input.length()) {
        			if (input.charAt(end)=='.') 
        				isFile = true;
        			if (input.charAt(end)=='\n')
        				break;

        			end++;
        		}
        		
        		//adjust path to add current dir or file
        		while (tab!=path.size()) {
        			path.pop();
        			pathLength.pop();
        		}
        		
        		String s = input.substring(index,end);
        		int length = pathLength.peek()+1+s.length();
        		path.push(s);
        		pathLength.push(length);
        		if (isFile) {
        			maxLength = Math.max(maxLength, length);
        		}
        		index = end;
        		
        	} else {
        		if (input.charAt(index)=='.') {
        			//only one file in the file system
        			return input.length();
        		}
        		index++;
        		if (index<input.length() && input.charAt(index)=='\n') {
        			String s = input.substring(0, index);
        			path.push(s);
        			pathLength.push(s.length());
        		}
        	}
        }
        return maxLength;
    }
	
	
	//test
	public static void main(String[] args) {
		LongestAbsoluteFilePath tmp = new LongestAbsoluteFilePath();
		String input = "dir\n\tfile.txt";
		String input2 = "dir\n    file.txt";
		int result = tmp.lengthLongestPath(input);
		System.out.println(result);
	}
}
