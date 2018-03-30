
public class Automobile {
	public double gasMileage;
	public double gallons;
	
	Automobile (double gm) {
		gasMileage = gm;
		gallons = 0;
	}
	
	void fillUp (double g) {
		gallons += g;
	}
	
	void takeTrip (double m) {
		gallons -= (m / gasMileage);
	}
	
	double reportFuel () {
		return (gallons);
	}
}
