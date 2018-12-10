package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class AmbientLight extends Light
{
	private double Ka;
	
	// ***************** Constructors ********************** //

	public AmbientLight()
	{
		super();
		this.Ka = 0.1;
	}
	
	public AmbientLight(Color color, double ka)
	{
		super(color);
		this.Ka = ka;
	}
	
	public AmbientLight(int C1, int C2, int C3)
	{
		super(C1,C2,C3);
		this.Ka = 0.1;
	}
	
	public AmbientLight(AmbientLight AL)
	{
		super(AL.get_color());
		this.Ka = AL.getKa();
	}
	
	// ***************** Getters/Setters ********************** // 

	public double getKa()
	{
		return Ka;
	}

	public void setKa(double ka)
	{
		this.Ka = ka;
	}
	
	// ***************** Administration  ******************** // 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(Ka) != Double.doubleToLongBits(other.Ka))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "AmbientLight [Ka=" + Ka + "]";
	}
	
	// ***************** Operations ******************** //
	
	@Override
	public Color getIntensity(Point3D point)	
	{
		int red = (int)(this.get_color().getRed() * Ka);
		int green = (int)(this.get_color().getGreen() * Ka);
		int blue = (int)(this.get_color().getBlue() * Ka);
		
		return new Color(red,green,blue);
	}





@Override
public Vector getL(Point3D point) 
{
	Vector v = new Vector();
	return v;
}






}
