package tanchishe;

public class Node {
	public static final int WIDTH=20,HEIGHT=20;
	private int x,y;
	public Node() {
		
	}
	
	public Node(int x, int y) {
		super();
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
	
}
