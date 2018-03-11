
public class testOrder {
	public static void main(String[] args) {
		Floor fl = new Floor();
		Inventory inventory = new Inventory();
		Robot rt = new Robot(fl, 1000, true, true, fl.getCharging_Station());
		Order ord = new Order(inventory, fl);
		//System.out.println(inventory.item_arr);
		//ord.make_Order();
		//System.out.println(ord.order_Showup());
		//System.out.println(ord.find_Shelf());
		rt.find_Place();
		
	}
}
