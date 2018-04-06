import java.util.LinkedList;

/*
 * Belt area is from (100,0) --- (100,80), when return order is detected, the order will be transfered to
 * Rcving dock(99,80) <from (100,0) to (100,40)>, when need to ship the order, it will transfer the order from shipping dock to out side  
 */
public class Belt implements Runnable{
	private static LinkedList<Point> BeltArea = new LinkedList<Point>();
	private static Order order = new Order();
	public Belt() {
		for (int i = 0; i < 81; i++) {
			BeltArea.add(new Point(100,i));
		}
	}
	
	public void Rcvd() {
		//if (order.get_is_Returned() == true) {
			System.out.println("Returned order is on the Belt...");
			for (int i = 40; i < BeltArea.size(); i++) {
				System.out.println("Belt area is moving the Returned order to Point" + "(" +	BeltArea.get(i).getX() + "," + BeltArea.get(i).getY() + ")");
				// make sure it arrives at (100,80)
				if (BeltArea.get(i).getY() == 80) {
					System.out.println("The order has been transfered to Receiving Dock...");
				}
			}
		}
	//}
	
	public void Shipped() {
		//if (this.order.order_Showup() == true) {
			for (int i = 40; i > 0; i--) {
				System.out.println("Belt area is moving the shipping order to Point" + "(" +	BeltArea.get(i).getX() + "," + BeltArea.get(i).getY() + ")");
				System.out.println("The order is going through thr Belt...");
				if (BeltArea.get(i).getY() == 1) {
					System.out.println("Ready to ship the Order...");
				}
			
			}
		//}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (order.get_is_Returned() == true) {
			Rcvd();
		} else {
			Shipped();
		}
	}
	
}

