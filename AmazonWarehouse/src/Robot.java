import java.util.LinkedList;

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
public class Robot extends Thread{
	private int battery;
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
		battery = 1000;
		charged = true;
		isIdle = true;
		System.out.println("Arrived at Charging Station...");
		System.out.println("Recharged, the battery now is " + battery);
	}
	
	public void find_Place() {
		// recharge
		if (this.battery < 100) {
			System.out.println("Robot needs to get charged, the current battert is " + battery);
			isIdle = false;
			this.path = floor.getPath(current, floor.getCharging_Station());
			goTo(this.path);
			reCharge();
		}
		// Order shows up
		else if (ord.order_Showup() == true) {
			System.out.println("Order shows up...");
			isIdle = false;
			this.path = floor.getPath(current, ord.find_Shelf());
			//System.out.println("Path " + path);
			//System.out.println("Path size " + path.size());

			goTo(this.path);
			this.path = floor.getPath(ord.find_Shelf(), floor.getShipping_Dock());
			goTo(this.path);
		}
	}
	
	
	// point next is popped out of the path, so the we update current to next to show the robot is moving.
	public void goTo(LinkedList<Point> path) {
		for (Point i : path) {
			//System.out.println("Path " + path);
			//System.out.println("Path size " + path.size());
			//System.out.println("i is " + i);
			this.next = i;
			this.current = next;
			System.out.println("Current point is " + "(" + this.current.getX() + ", " + this.current.getY() + ")");
			
			battery_Use();
			System.out.println("Robot is moving to " + "(" + next.getX() + ", " + next.getY() + ")");
		}
	}

	public void run() {
		
	}
}
