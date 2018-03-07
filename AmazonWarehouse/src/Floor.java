import java.util.*;

/*
 * this class is in charge of representing the static layout of the simulated warehouse. 
 * The warehouse is a grid of squares with some squares having special purposes. These are 
 * squares for picker(s), packer(s), belt areas, shipping dock, receiving dock, shelf areas, 
 * and chargers. In addition to all this static knowledge, the Floor provides a service to 
 * keep track of the location of each Shelf object, each Robot object, and path calculation 
 * (what path to take going from one place to other). When Floor initializes, it makes Shelf 
 * objects and puts them in the shelf areas. The size of each shelf is one square in warehouse 
 * floor; a robot is also one square. Locations of picker(s), packer(s), and docks are also 
 * one square. The only things that are not single squares are shelf areas and the belt area. 
 * The floor provides some nice methods so that Belt can know what is the size of the Belt 
 * (how many squares, where is picker, where is packer) and so that Visualizer can know the 
 * width/length of shelf areas, the length of the belt area, location of docks; 
 * Visualizer will also be able to ask Floor about locations of robots and shelves.
 */

public class Floor {
	final static int Length = 60;  // related to x coordinate
	final static int Width = 40;   //related to y coordinate
	
	public static final Point Charging_Station = new Point(0, 40);
	public static final Point Picker = new Point(0, 0);
	public static final Point Packer = new Point(30,20);
	public static final Point Belt_Area = new Point(60, 0);
	public static final Point Shipping_Dock = new Point(60, 20);
	public static final Point Rcving_Dock = new Point(60, 40);
	
	
}
