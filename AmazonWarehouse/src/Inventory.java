import java.lang.reflect.Array;

/*
 * the items of the simulated warehouse come from a catalog of names and item numbers. 
 * When Inventory initializes, it makes some number of each item and distributes these 
 * on the Shelf objects (it can ask Floor for a list of all Shelf objects).  If stock 
 * gets low, Inventory should cause a later arrival of new items to the receiving dock.
 */
public class Inventory {
	public Item[] item_arr;
	Floor floor = new Floor();
	public Inventory() {
		this.item_arr = new Item[] {new Item("Coke", 1, floor.getShelf_0(), 9999),
					 	new Item("Coffee", 2, floor.getShelf_0(), 8999),
					 	new Item("Candy", 3, floor.getShelf_0(), 10000),
					 	new Item("TV", 4, floor.getShelf_0(), 4000),
					 	new Item("Tea", 5, floor.getShelf_1(), 1243),
					 	new Item("Microwave", 6, floor.getShelf_0(), 4938),
					 	new Item("Bread", 7, floor.getShelf_1(), 3958),
					 	new Item("Vitamin",8, floor.getShelf_1(), 9483),
					 	new Item("Tissue", 9, floor.getShelf_0(), 9394),
					 	new Item("MP3", 10, floor.getShelf_1(), 3404)};

		
	}
	//Check if stock is lower than 500, if it is, restock.
	public void stock_Warning() {
		for (Item i : item_arr) {
			if (i.stock_Count(i.getName()) < 500) {
				System.out.println("Need to Restock This Item " + i.getName());
				i.setStock(1000);;
				System.out.println("Restock complete!" );
			}
		}
		System.out.println("No need to restock yet.");

	}
	
	
}



