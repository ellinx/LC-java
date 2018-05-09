package ellinx.solutions;


/**
 * Given three words and check if the third one is mix of the first two in correct order.
 * 
 * Example 1:
 * input: ebay, awesome, ebayawesome
 * output: true
 * 
 * Example 2:
 * input: ebay, awesome, ebaweaysome
 * output: true
 * 
 * Example 3:
 * intput: ebay, awesome, ebsomeayawe
 * output: false
 * 
 * @author Ellinx
 *
 */
public class CheckMixWords {
	public boolean isMixInOrder(String a, String b, String c) {
		boolean res = false;
		System.out.println("a="+a+", b="+b+", c="+c);
		if (a.length()+b.length()!=c.length()) {
			return false;
		}
		if (a.length()==0) {
			return b.equals(c);
		}
		
		char tmp = a.charAt(0);
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<c.length();i++) {
			
			if (tmp == c.charAt(i)) {
				String s = sb.toString();
				if (s.equals(b.substring(0, s.length()))) {
					res = isMixInOrder(a.substring(1), b.substring(s.length()), c.substring(i+1));
				}
				if (res) return true;
			}
			sb.append(c.charAt(i));
			System.out.println(sb.toString());
		}
		return false;
	}
	
	//test
	public static void main(String[] args) {
		CheckMixWords tmp = new CheckMixWords();
		boolean result = tmp.isMixInOrder("ebay", "awesome", "ebawesomeay");
		System.out.println(result);
	}
}
