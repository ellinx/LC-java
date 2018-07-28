package solutions;

public class Reader4 {
	private char[] data;
	private int index;
	
	public Reader4(String s) {
		data = s.toCharArray();
		index = 0;
	}
	
	public int read4(char[] buf) {
		int total = 0;
		while (total<4 && index+total<data.length) {
			buf[total] = data[index+total];
			total++;
		}
		index += total;
		return total;
	}
}
