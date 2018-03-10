
public class testOrder {
	public static void main(String[] args) {
		Floor fl = new Floor();
		Inventory inventory = new Inventory();

		Order ord = new Order(inventory, fl);
		//System.out.println(inventory.item_arr);
		ord.make_Order();
		//System.out.println(ord.random_number());
	}
}
