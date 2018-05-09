package ellinx.solutions;

/**
 * Two Threads run currently printing number from 1 to 100
 * @author Ellinx
 *
 */
public class OddEvenMonitor {
	public static final boolean ODD_TURN = true;
	public static final boolean EVEN_TURN = false;
	private boolean turn = ODD_TURN;
	
	public synchronized void waitTurn (boolean oldTurn) {
		while(turn != oldTurn) {
			try{
				wait();
			} catch(Exception e){
			}
		}
	}
	
	public synchronized void toogleTurn(){
		turn ^= true;
		notify();
	}
	
	static class OddThread extends Thread {
		private final OddEvenMonitor monitor;
		
		public OddThread (OddEvenMonitor monitor) {
			this.monitor = monitor;
		}
		
		public void run(){
			for (int i=1;i<=100;i+=2) {
				monitor.waitTurn(OddEvenMonitor.ODD_TURN);
				System.out.println(i);
				monitor.toogleTurn();
			}
		}
	}
	
	static class EvenThread extends Thread {
		private final OddEvenMonitor monitor;
		
		public EvenThread (OddEvenMonitor monitor) {
			this.monitor = monitor;
		}
		
		public void run(){
			for (int i=2;i<=100;i+=2) {
				monitor.waitTurn(OddEvenMonitor.EVEN_TURN);
				System.out.println(i);
				monitor.toogleTurn();
			}
		}
	}
	
	//test
	public static void main(String[] args) {
		OddEvenMonitor monitor = new OddEvenMonitor();
		OddThread oddT = new OddThread(monitor);
		EvenThread evenT = new EvenThread(monitor);
		oddT.start();
		evenT.start();
		
	}
}
