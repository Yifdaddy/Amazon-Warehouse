import java.util.LinkedList;

/*
 * perhaps randomly, orders will be generated by the Orders part of the simulation. 
 * Each order will have an address and a few desired items. We can think of orders 
 * being in a queue at the picker station. A picker is working on one order at a time. 
 * The Orders part is doing the work of the picker. Orders has to ask Inventory which 
 * shelf has a desired item, then ask Floor where is that shelf, then as Robot to bring 
 * that shelf to the picker location, tell Inventory to remove the item from the shelf, 
 * then tell a robot to take the shelf back to the shelving area.
 */
public class Order {
	private Address addr = new Address();
	private int random; // for generating order;
	private int random_0; // for generating random shelf;
	private int random_1; // for generating random returned order
	private int limit = 5;
	private Floor floor;
	private Inventory inventory;
	private Item item;
	private boolean is_returned;
	LinkedList<Item> order_queue = new LinkedList<Item>();
	private Robot robot;
	private boolean order_showup;
	private Point shelf;
	public Order() {
		this.inventory = new Inventory();
		this.floor = new Floor();
	}
	public Order(Inventory inventory, Floor floor) {
		this.inventory = inventory;
		this.floor = floor;
	}
	
	/*
	 * (int)(Math.random() * 20) create chances that might not have orders,
	 * since num is 0-9 inclusive.
	 */
	private int random_number() {
		this.random = (int)(Math.random() * 20);
		//System.out.println("random number is " + random);
		return random;
		
	}
	private int random_returned_num() {
		this.random_0 = (int)(Math.random());
		return random_0;
	}
	//give a random shelf to put the item
	public Point random_Shelf() {
		if (random_returned_num() == 0) {
			return floor.getShelf_0();
		}
		else {
			return floor.getShelf_1();
		}
	}
	//use random_number method(above) to produce a ramdom order(below)
	public void make_Order() {
		//Item item;
		int rand = random_number();
		if (random > 10) {
			System.out.println("=======================================");
			order_showup = false;
			System.out.println("No order comes up yet...");
			System.out.println("=======================================");
			return;
		}
		while (queue_size() < limit) {
			order_showup = true;
			if (rand == 0) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[0];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[0].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");

			}
			else if (rand == 1) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[1];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[1].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 2) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[3];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);					
				inventory.item_arr[3].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 3) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[2];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[2].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 4) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[4];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[4].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 5) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[5];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[5].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 6) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[6];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);	
				inventory.item_arr[6].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 7) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[7];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[7].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 8) {
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[8];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[8].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
			else if (rand == 9) {	
				System.out.println("=======================================");
				//order_showup = true;
				item = inventory.item_arr[9];
				shelf = item.getPlace();
				System.out.println("Order is on the shelf " + item.getPlace());
				order_queue.add(item);
				inventory.item_arr[9].minusOneStock();
				System.out.println("The receiver's name is " + addr.get_randname());
				System.out.println("The state is " + addr.get_randSt());
				System.out.println("The zip code is " + addr.get_randZip());
				inventory.stock_Warning();
				System.out.println("=======================================");
			}
		}
	}
	
	// Robot will use this method to detect which shelf should it go.
	public boolean order_Showup() {
		make_Order();
		return this.order_showup;
	}
	
	public Point find_Shelf() {
		System.out.println(this.shelf);
		return this.shelf;
	}
	

	// generate a random number to determine 
	// whether there is a return
	public boolean get_is_Returned() {
		// if random is less than 10, then there will not be a return
		// else there is a return
		random_1 = (int)(Math.random() * 20);
		//System.out.println("random_1 is " + random_1);

		if (random_1 < 10) {  
			System.out.println("=======================================");
			System.out.println("No returned order received..");

			System.out.println("=======================================");

			is_returned = false; 
			return is_returned;
		}
		else {
			System.out.println("=======================================");
			System.out.println("Returned order is from " + addr.get_randname() + "， " + addr.get_randSt() + "， " + addr.get_randZip());
			is_returned = true;
			System.out.println("=======================================");
			return is_returned;
		}
	}
	public Point find_Rcvdock() {
		return floor.getRcving_Dock();
	}
	public int queue_size() {
		return order_queue.size();
	}
	
}

/*
 * This is the class that will produce the random address.
 * Including name of the person, street, state, zip code.
 */
class Address {
	private String[] name = new String[] {"Ivan", "Link", "Java", "Python", "Haskell", "Prolog", "Agda", "Mips"};
	private String[] state = new String[] {"IA", "WI", "CA", "AL", "AK", "GA", "KS", "NJ", "NC", "ND"};
	private String[] zip_code = new String[] {"10086", "52240", "53959", "10010", "10020", "54228", "52910"};
//	private int random_Name = (int)Math.random() * 8;
//	private int random_State = (int)Math.random() * 10;
//	private int random_Zip = (int)Math.random() * 7;
	
	public String get_randname() {
		int random_Name = (int)(Math.random() * 8);
		System.out.println(random_Name);
		return name[random_Name];
	}
	
	public String get_randSt() {
		int random_State = (int)(Math.random() * 10);
		return state[random_State];
	}
	
	public String get_randZip() {
		int  random_Zip = (int)(Math.random() * 7);
		return zip_code[random_Zip];
	}
}
