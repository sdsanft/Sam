
public class Child1 extends Parent1 {
	int z;
	
	Child1 (int argX, int argY, int argZ) {
		super (argX, argY);
		z = argZ;
	}
	
	Child1 (int argX1, int argX2, int argX3, int argY1, int argY2, int argZ) {
		super(argX1, argX2, argY1);
		getParentValues();
		this.x = argX3;
		this.y = argY2;
		z = argZ;
		getValues();
		getParentValues();
	}
	
	public void getValues () {
		System.out.println("X: " + x + "  Y: " + y + "  Z:" + z);
	}
	
	public void getParentValues () {
		System.out.println("X: " + super.x + "  Y: " + super.y);
	}
	
	public void getGrandParentValue () {
		System.out.println();
	}
	
	public void sayHello(int i) {
		if (i == 1)
			System.out.println("Hi");
		else if (i == 2)
			super.sayHello();
		else {
			sayHello();
		}
	}
}
