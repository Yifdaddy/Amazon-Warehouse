import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/*
 * @author Yifan He
 */
/*
 * this class is in charge of representing the static layout of the simulated warehouse. 
 * The warehouse is a grid of squares with some squares having special purposes. These are 
 * squares for picker(s), packer(s), belt areas, shipping dock, receiving dock, shelf areas, 
 * and chargers. In addition to all this static knowledge, the Floor provides a service to 
 * keep track of the location of each Shelf object, each Robot object, and path calculation 
 * (what path to take going from one place to other). When Floor initializes, it makes Shelf 
 * objects and puts them in the shelf areas. The size of each shelf is one square in warehouse 
 * floor; a robot is also one square. Locations of picker(s), packer(s), and docks are also 
 * one square.  
 */


/*
 * The logic of the coordinates this warehouse is quiet similar to Coordinate System of First Quadrant, 
 * not like what we always used in Java.
 */
public class Floor {
	final static int Length = 100;  // related to x coordinate
	final static int Width = 80;   //related to y coordinate
	
	private static final Point Charging_Station = new Point(0, 0);
	private static final Point Charging_Station_1 = new Point(0,20);
	private static final Point Picker = new Point(0, 80);
	private static final Point Packer = new Point(50,40);
	//private static final Point[] Belt = new Point[] {	};
	private static final Point Shipping_Dock = new Point(99, 0);
	private static final Point Rcving_Dock = new Point(99, 80);
	private static final Point Shelf_0 = new Point(20, 60);
	private static final Point Shelf_1 = new Point(40, 60);
	private static boolean isAtChargingStation;
	public Point[] Shelf_arr= new Point[]{Shelf_0, Shelf_1};
	
	//cell stores place and its location
	public HashMap<String, Point> cell = new HashMap<String, Point>();
	
	
	// Use for loop to create floor, and add location to cell. 
	public Floor() {
		for (int i = 0; i < Length; i++) {
			for (int j = 0; j < Width; j++) {
				Point pt = new Point(i,j);
			}
		}
		
	}
	public Point getCharging_Station() {
		return Charging_Station;
	}
	
	public Point getCharging_Station_1() {
		return Charging_Station_1;
	}
	
	public void set_isAtChargingStation(boolean isAtChargingStation) {
		this.isAtChargingStation = isAtChargingStation;
	}
	
	public boolean get_isAtChargingStation() {
		return isAtChargingStation;
	}
	
	
	
	public Point getPicker() {
		return Picker;
	}
	
	public Point getPacker() {
		return Packer;
	}
	
	//public Point[] getBelt() {
	//	return Belt;
	//}
	
	public Point getShipping_Dock() {
		//System.out.println("Order is arrived at shipping dock, and is ready to be shipped...");
		return Shipping_Dock;
	}
	public Point getRcving_Dock() {
		//System.out.println("At receiving dock...");
		return Rcving_Dock;
	}
	public Point getShelf_0() {
		return Shelf_0;
	}
	public Point getShelf_1() {
		return Shelf_1;
	}
	
	
	/*
	 * A method that can provide the path to a robot.
	 * The basic idea is to compare the absolute difference between points.
	 * In the coordinate system, x1Diff(int the code) refers to the difference 
	 * between destination and moving 1 point to the east of current point.
	 * x2Diff refers to the difference between destination and moving 1 point to 
	 * the west of current point.
	 * 
	 * Determine whether the robot should move to north or south used the same idea as above.
	 */
	
	public LinkedList<Point> getPath(Point curr, Point dest) {
		LinkedList<Point> path = new LinkedList<Point>();
		Point curLocation = new Point(curr.getX(), curr.getY());
		while (curLocation.getX() != dest.getX() || curLocation.getY() != dest.getY()) {
			if (curLocation.getX() != dest.getX()) {
				int x1Diff = Math.abs(dest.getX() - curLocation.east().getX());  //go east, x + 1
				int x2Diff = Math.abs(dest.getX() - curLocation.west().getX());  //go west, x - 1
				// go east
				if (x1Diff <= x2Diff) {
					Point newPt = new Point(curLocation.east().getX(), curLocation.getY());
					//update the curLocation to the new Point
					curLocation = newPt;
					//System.out.println("Go East by 1 point.");
					path.add(newPt);
				}
				// go west
				else {
					Point newPt = new Point(curLocation.west().getX(), curLocation.getY());
					//update the curLocation to the new Point
					curLocation = newPt;
					//System.out.println("Go West by 1 point.");
					path.add(newPt);
				}
			}
			else if (curLocation.getY() != dest.getY()) {
				int y1Diff = Math.abs(dest.getY() - curLocation.north().getY()); //go north, y + 1
				int y2Diff = Math.abs(dest.getY() - curLocation.south().getY()); //go south, y - 1
				if (y1Diff <= y2Diff) {
					Point newPt = new Point(curLocation.getX(), curLocation.north().getY());
					//update the curLocation to the new Point
					curLocation = newPt;
					//System.out.println("Go North by 1 point.");
					path.add(newPt);
				}
				else {
					Point newPt = new Point(curLocation.getX(), curLocation.south().getY());
					//update the curLocation to the new Point
					curLocation = newPt;
					//System.out.println("Go South by 1 point.");
					path.add(newPt);
				}
			}
		}
		//System.out.println("LinkedList " + path);
		return path;
	}
	
}
