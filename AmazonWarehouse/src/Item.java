/*
 * @author Yifan He
 */
/*
 * Item class will provide the basic information of each item,
 * such as name, number, where it is(Which shelf it is on), 
 * and stock of the item.
 */

public class Item {
	private int num;
	private String name;
	private Point place;
	private int Stock;
	
	public Item(String name, int num, Point place, int Stock) {
		this.name = name;
		this.num = num;
		this.place = place;
		this.Stock = Stock;
	}
	
	

	public void setStock(int stock) {
		this.Stock = stock;
	}

	public int stock_Count(String name) {
		return this.Stock;
	}
	
	public String getName() {
		return name;
	}



	public Point getPlace() {
		return place;
	}



	public void setPlace(Point place) {
		this.place = place;
	}
	
	public int minusOneStock() {
		return this.Stock--;
	}



	
}
