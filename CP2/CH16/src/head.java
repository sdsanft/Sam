
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Automobile myBmw = new Automobile(24);
		myBmw.fillUp(20);
		myBmw.takeTrip(100);
		double fuel_left = myBmw.reportFuel( );
		System.out.println(fuel_left); //prints gallons left, 15.833333333333332
	}

}
