package ellinx.solutions;

/**
 * You are given two jugs with capacities x and y litres. There is an infinite
 * amount of water supply available. You need to determine whether it is
 * possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have z liters of water contained
 * within one or both buckets by the end.
 * 
 * Operations allowed:
 * 
 * 1.Fill any of the jugs completely with water. 
 * 2.Empty any of the jugs. 
 * 3.Pour water from one jug into another till the other jug is completely full or the first
 * jug itself is empty. 
 * 
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4 Output: True 
 * 
 * Example 2:
 * Input: x = 2, y = 6, z = 5 Output: False
 * 
 * @author Ellinx
 *
 */
public class WaterAndJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
        if (x+y<z) return false;
        if (x==z || y==z || x+y==z) return true;
        
        return z%GCD(x,y)==0;
    }
	
	private int GCD(int x, int y) {
		while (y!=0) {
			int tmp = y;
			y = x%y;
			x = tmp;
		}
		return x;
	}
	
	public static void main(String[] args) {
		WaterAndJugProblem tmp = new WaterAndJugProblem();
		boolean result = tmp.canMeasureWater(3, 5, 4);
		System.out.println(result);
	}
}
