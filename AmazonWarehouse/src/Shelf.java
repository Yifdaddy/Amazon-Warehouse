/*
 * @author Yifan He
 */
public class Shelf {
	Point home_Shelf;
	Boolean being_Carried;
	//int random = (int) Math.rint(Math.random());
	//Shelf_0 = new Point(20, 60);
	//Shelf_1 = new Point(40, 60);
	public Shelf(Point home_Shelf) {
		this.home_Shelf = home_Shelf;
		this.being_Carried = false;
	}
	
	public boolean carried() {
		return being_Carried = true;
	}
	
	public boolean not_Carried() {
		return being_Carried = false;
	}
}
