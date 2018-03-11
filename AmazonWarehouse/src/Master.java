
/*
 * this is the main class, which drives the simulation by 
 * (1) creating initialial instances of all other parts, 
 * (2) then looping to generate tick events for each simulated time unit, 
 * (3) providing a "scheduled event" service that other parts can use to 
 *     have an event occur at a specified simulated time
 */
public final class Master {
	private static Floor fl;
	private Robot rt;
	private Order ord;
	private static int tick = 10000;
	public Master(Floor fl, Robot rt, Order ord) {
		this.fl = fl;
		this.rt = rt;
		this.ord = ord;
	}
	
	//Not implemented yet
	public static void run() {
		for (int i = 0; i < tick; i++) {
			
		}
	}
}
