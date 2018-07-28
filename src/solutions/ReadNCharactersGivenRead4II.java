package solutions;

import java.util.Arrays;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function may be called multiple times.
 * 
 * Example 1:
 * 
 * Given buf = "abc" 
 * read("abc", 1) // returns "a" 
 * read("abc", 2); // returns "bc" 
 * read("abc", 1); // returns ""
 * 
 * Example 2:
 * 
 * Given buf = "abc" 
 * read("abc", 4) // returns "abc" 
 * read("abc", 1); // returns ""
 * 
 * 
 * @author Ellinx
 *
 */

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */
public class ReadNCharactersGivenRead4II extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    private char[] temp = new char[4];
    private int tempIndex = 0;
    private int tempLength = 0;
    
    public int read(char[] buf, int n) {
        if (n==0) {
            return 0;
        }
        int index = 0;
        if (tempIndex==tempLength) {
            tempLength = read4(temp);
            tempIndex = 0;
        }
        while (index<n && tempIndex<tempLength) {
            while (index<n && tempIndex<tempLength) {
                buf[index] = temp[tempIndex];
                index++;
                tempIndex++;
            }
            if (index==n) {
                return n;
            }
            tempLength = read4(temp);
            tempIndex = 0;
        }
        return index;
    }
    
    //test
    public ReadNCharactersGivenRead4II(String s) {
    	super(s);
    }
    
    public static void main(String[] args) {
    	String src = "abc";
    	int[] readlength = {4,1};
    	ReadNCharactersGivenRead4II dummy = new ReadNCharactersGivenRead4II(src);
    	for (int each:readlength) {
    		char[] buf = new char[10];
        	int size = dummy.read(buf,each);
        	System.out.println(Arrays.toString(Arrays.copyOfRange(buf, 0, size)));
    	}
	}
}
