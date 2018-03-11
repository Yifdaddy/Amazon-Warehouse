
public class testFloor {
	public static void main(String[] args) {
		Floor fl = new Floor();
		Point cur = fl.getCharging_Station();
		Point dest = fl.getPicker();
		fl.getPath(cur, dest);
	}
}
