package ellinx.solutions;

public class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(Integer.toString(start));
		sb.append(',');
		sb.append(Integer.toString(end));
		sb.append(']');
		return sb.toString();
	}
}
