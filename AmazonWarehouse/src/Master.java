import java.util.ArrayList;

/*
 * this is the main class, which drives the simulation by 
 * (1) creating initialial instances of all other parts, 
 * (2) then looping to generate tick events for each simulated time unit, 
 * (3) providing a "scheduled event" service that other parts can use to 
 *     have an event occur at a specified simulated time
 */
public final class Master {
	private static Floor fl;
	private static Robot rt1;
	private static Robot rt2;
	private static Order ord;
	private static Inventory inventory;
	private static int tick = 10000;
//	public Master(Floor fl, Robot rt, Order ord) {
//		this.fl = fl;
//		this.rt = rt;
//		this.ord = ord;
//	}
	
	// main method that integrates all the classes togethoer and run
	public static void run() {
		fl = new Floor();
		inventory = new Inventory();
		rt1 = new Robot(fl, 1000, true, true, fl.getCharging_Station());
		rt2 = new Robot(fl, 1000, true, true, fl.getCharging_Station());
		ArrayList<Robot> robot_arr = new ArrayList<Robot>();
		robot_arr.add(rt1);
		robot_arr.add(rt2);
		Thread thread1 = new Thread(rt1, "Robot1");
		Thread thread2 = new Thread(rt2, "Robot2");
		thread1.start();
		thread2.start();
		//System.out.println(inventory.item_arr);
		//ord.make_Order();
		//System.out.println(ord.order_Showup());
		//System.out.println(ord.find_Shelf());
		
		//rt2.find_Place();
		//System.out.println("Order queue in master is " + ord.getOrderqueue());
		
		
	}
}
