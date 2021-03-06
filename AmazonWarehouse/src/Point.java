/*
 * @author Yifan He
 */
/*
 * This gives the coordinates of each place. 
 * Basically print out the layout of floor
 */

public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "X is " + x + " Y is " + y + "\n" ;
	}
	
	
	public Point north() {
		int yNorth = y + 1;
		Point newPt = new Point(x, yNorth); 
		//if yNorth > Floor.Width, stay at the old place
		if (yNorth > Floor.Width) {
			return new Point(x, y);
		}
		else {
			return newPt;
		}
	}

	public Point south() {
		int ySou = y - 1;
		Point newPt = new Point(x, ySou);
		//if ySou < 0, stay at the old place
		if (ySou < 0) {
			return new Point(x, y);
		}
		else {
			return newPt;
		}
	}
	
	public Point west() {
		int xWest = x - 1;
		Point newPt = new Point(xWest, y);
		//if xWest < 0, stay at the old place
		if (xWest < 0) {
			return new Point(x, y);
		}
		else {
			return newPt;
		}
	}
	
	public Point east() {
		int xEast = x + 1;
		Point newPt = new Point(xEast, y);
		//if xEest > Floor.Length, stay at the old place
		if (xEast > Floor.Length) {
			return new Point(x, y);
		}
		else {
			return newPt;
		}
	}

}
