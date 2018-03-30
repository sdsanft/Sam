
public class Circle
{
	public double radius;
	
	public Circle(double r)
	{
		radius = r;
	}
	
	public double area( ) //area method
	{
		double a = Math.PI * radius * radius;
		return a;
	}
	public double circumference( ) //circumference method
	{
		double c = 2 * Math.PI * radius;
		return c;
	}
	public double diameter( ) {
		double d = 2 * radius;
		return d;
	}
}