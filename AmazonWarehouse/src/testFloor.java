
public class testFloor {
	public static void main(String[] args) {
		Floor fl = new Floor();
		Point cur = Floor.Charging_Station;
		Point dest = Floor.Picker;
		fl.getPath(cur, dest);
	}
}
