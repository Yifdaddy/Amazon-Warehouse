import java.util.LinkedList;
/*
 * @author Yifan He
 */
/*
 * has the most intuitive task, charging, moving, carrying shelf. Robot needs to keep 
 * track of location, tell Floor at each tick where it is, call Floor to find a path, 
 * and then at each tick move one square along a path. Robot needs to simulation "carrying" 
 * a shelf (sometimes a shelf is not on the floor, it is above the floor being carried). 
 * When a robot puts a shelf down in a shelving area, the robot has to tell Floor about this. 
 * The Robot part gets really tricky when there are two or more robots. Ideally, a robot does 
 * not carry a shelf where it would bump into another shelf, but that might be hard to plan for 
 * depending on the Floor layout.
 */

public class Robot implements Runnable {
	private int battery;
	private Belt belt = new Belt();
	private Thread threadBelt = new Thread(belt);
	private Floor floor = new Floor();
	private boolean charged;
	//Point ori_Place;
	private boolean isIdle;
	private Point current;
	private Order ord = new Order();
	Point next;  //the next point where the robot goes to
	LinkedList<Point> path = new LinkedList<Point>();
	public Robot(Floor floor, int battery, boolean charged, boolean isIdle, Point current) {
		this.floor = floor;
		this.battery = battery;
		this.charged = charged;
		this.isIdle = isIdle;
		this.current = current;
	}
	
	public void battery_Use() {
		if (isIdle == false) {
			battery--;
		}
	}
	
	public Point getCurrent() {
		return current;
	}
	
	public void reCharge() {
		battery = 500;
		charged = true;
		isIdle = true;
		if (floor.get_isAtChargingStation() == true) {
			System.out.println(Thread.currentThread().getName() + " Arrived at Charging Station...");
			try {
				System.out.println("Recharging...");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			floor.set_isAtChargingStation(false);
			System.out.println(Thread.currentThread().getName() + " Recharged, the battery now is " + battery);

		} else if (floor.get_isAtChargingStation() == false){
			//floor.set_isAtChargingStation(true);
			System.out.println(Thread.currentThread().getName() + " Arrived at Charging Station...");
			try {
				System.out.println("Recharging...");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Recharged, the battery now is " + battery);
		}
	}
	
	
	/*
	 * This method will help robot to find the place to go.
	 * We first check the battrty of the robot to see if it
	 * needs to be charged or no; The next step is to check 
	 * the order queue, if there is any order in the order queue, 
	 * the robot will finish its job and empty the queue. Otherwise
	 * if there is a returned order, the robot will go pick up the 
	 * returned order and put it back to the shelf.
	 */
	public void find_Place() {
		// recharge
		if (this.battery < 100) {
			if (this.battery < 0) {
				System.out.println("Activating the backup power...");
				this.battery = Math.abs(this.battery);
				System.out.println("After activated the backup power for " + Thread.currentThread().getName() + ", now the battery is " + this.battery);
			}
			System.out.println(Thread.currentThread().getName() + " needs to get charged, the current battery is " + battery);
			isIdle = false;
			if (floor.get_isAtChargingStation() == true) {
				this.path = floor.getPath(current, floor.getCharging_Station());
				goTo(this.path);
				reCharge();
				floor.set_isAtChargingStation(false);
			} else {
				//floor.set_isAtChargingStation(true);
				this.path = floor.getPath(current, floor.getCharging_Station_1());
				goTo(this.path);
				reCharge();
				floor.set_isAtChargingStation(false);
			}
		}
		// Order shows up
		//System.out.println("size of queue is " + ord.order_queue.size());
		if (ord.order_Showup() == true) {
			
			while (ord.queue_size() != 0) {
				System.out.println("Order_queue size is " + ord.queue_size());

				System.out.println("Order shows up...");
				isIdle = false;
				this.path = floor.getPath(current, ord.find_Shelf());
				//System.out.println("Path " + path);
				//System.out.println("Path size " + path.size());
				goTo(this.path);
				this.path = floor.getPath(ord.find_Shelf(), floor.getShipping_Dock());
				goTo(this.path);
				/*
				 *  need to new Thread(belt) is because Thread can only call start() once,
				 *  if we need to call start() more than one time, we need to new Thread(xx).start()
				 */
				//belt.Shipped();
				new Thread(belt).start();
				System.out.println("Order is shipped!");
				ord.getOrderqueue().remove();
				System.out.println("size of queue is " + ord.getOrderqueue().size());
				System.out.println("The battery for " + Thread.currentThread().getName() + " is " + this.battery);

				if (this.battery < 100) {
					if (this.battery < 0) {
						System.out.println("Activating the backup power...");
						this.battery = Math.abs(this.battery);
						System.out.println("After activated the backup power for " + Thread.currentThread().getName() + ", now the battery is " + this.battery);
					}
					System.out.println(Thread.currentThread().getName() + " needs to get charged, the current battery is " + battery);
					isIdle = false;
					if (floor.get_isAtChargingStation() == true) {
						this.path = floor.getPath(current, floor.getCharging_Station_1());
						goTo(this.path);
						reCharge();
					}
					else {
						floor.set_isAtChargingStation(true);
						this.path = floor.getPath(current, floor.getCharging_Station());
						goTo(this.path);
						reCharge();
						floor.set_isAtChargingStation(false);
					}
				}
			}
		}
		if (ord.get_is_Returned() == true) {
			System.out.println("There is a returned order...");
			isIdle = false;
			this.path = floor.getPath(current, floor.getRcving_Dock());
			goTo(this.path);
			/*
			 * Belt
			 */
			threadBelt.start();
			
			//belt.Rcvd();
			System.out.println("Received a returned order...");
			System.out.println("Putting it back to the shelf" + ord.random_Shelf());
			this.path = floor.getPath(current, ord.random_Shelf());
			goTo(this.path);
			System.out.println("The returned order has been put back...");
			System.out.println("The battery for " + Thread.currentThread().getName() + " is " + this.battery);
			if (this.battery < 100) {
				if (this.battery < 0) {
					System.out.println("Activating the backup power...");
					this.battery = Math.abs(this.battery);
					System.out.println("After activated the backup power for " + Thread.currentThread().getName() + ", now the battery is " + this.battery);
				}
				System.out.println(Thread.currentThread().getName() + " needs to get charged, the current battery is " + battery);
				isIdle = false;
				if (floor.get_isAtChargingStation() == true) {
					this.path = floor.getPath(current, floor.getCharging_Station_1());
					goTo(this.path);
					reCharge();
				}
				else {
					floor.set_isAtChargingStation(true);
					this.path = floor.getPath(current, floor.getCharging_Station());
					goTo(this.path);
					reCharge();
					floor.set_isAtChargingStation(false);
				}
			}
			}
	}
	
	
	/*
	 *  point next is popped out of the path, so that we update 
	 *  current to next point to show the path that robot is moving.
	 */
	public void goTo(LinkedList<Point> path) {
		for (Point i : path) {
			//System.out.println("Path " + path);
			//System.out.println("Path size " + path.size());
			//System.out.println("i is " + i);
			this.next = i;
			this.current = next;
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			battery_Use();
			System.out.println(Thread.currentThread().getName() + " is moving to " + "(" + next.getX() + ", " + next.getY() + ")");
		}
	}
	public void run() {
		synchronized(this) {
		find_Place();
		}
		
	}

	
}
