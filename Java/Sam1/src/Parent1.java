
public class Parent1 extends GrandParent1 {
	int y;
	
	Parent1 (int argX, int argY) {
		super(argX);
		y = argY;
	}
	
	Parent1 (int argX1, int argX2, int argY) {
		super(argX1);
		this.x = argX2;
		y = argY;
	}
	
	public void sayHello () {
		System.out.println("Hello");
	}
}
