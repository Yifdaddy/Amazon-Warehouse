/*
 * the items of the simulated warehouse come from a catalog of names and item numbers. 
 * When Inventory initializes, it makes some number of each item and distributes these 
 * on the Shelf objects (it can ask Floor for a list of all Shelf objects). It's the job 
 * of Inventory to watch, as the simulation ticks, how many items are on shelves. If stock 
 * gets low, Inventory should cause a later arrival of new items to the receiving dock, 
 * then ask for a robot to bring a shelf to the receiving dock, put items on the shelf, 
 * and send the robot back to put the shelf in the shelf area of the warehouse. Inventory 
 * should have a method which finds some shelf containing a needed item.

 */
public class Inventory {
	public Item[] item_arr = new Item[] {new Item("Coke", 1, Floor.Shelf_0, 9999),
										new Item("Coffee", 2, Floor.Shelf_0, 8999),
										new Item("Candy", 3, Floor.Shelf_0, 10000),
										new Item("TV", 4, Floor.Shelf_0, 4000),
										new Item("Tea", 5, Floor.Shelf_1, 1243),
										new Item("Microwave", 6, Floor.Shelf_0, 4938),
										new Item("Bread", 7, Floor.Shelf_1, 3958),
										new Item("Vitamin",8, Floor.Shelf_1, 9483),
										new Item("Tissue", 9, Floor.Shelf_0, 9394),
										new Item("MP3", 10, Floor.Shelf_1, 3404)};

	public Inventory() {
		
	}
	public void stock_Warning() {
		for (Item i : item_arr) {
			if (i.Stock < 500) {
				System.out.println("Need to Restock This Item " + i.name);
				i.Stock += 1000;
			}
		}
	}
}



