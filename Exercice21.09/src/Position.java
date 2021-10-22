
public class Position {
	private float x;
	private float y;
	public Position(float nx,float ny) {
		this.x = nx;
		this.y = ny;
	}
	public Position() {
		this.x=0;
		this.y=0;
	}
	public float getx() {
		return x;
	}
	public float gety() {
		return y;
	}
	public void setx(float nx)	{
		this.x=nx;
	}
	public void sety(float ny) {
		this.y = ny;
	}
	public void affichage() {
		System.out.println();
		System.out.println(x);
		System.out.println(y);
	}
	/*
	public static void main(String[] args) {
		Position position = new Position(3,2);
		System.out.println("x="+position.getx()+" y="+position.gety());
		position.setx(5);
		System.out.println("x="+position.getx()+" y="+position.gety());
		
	}*/
}
