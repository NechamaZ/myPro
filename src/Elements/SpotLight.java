package Elements;

import java.awt.Color;

// import java.awt.Color;

import Primitives.*;

public class SpotLight extends PointLight
{
	public Vector direction;
	
	// ***************** Constructors ********************** //


	public SpotLight(Color color, Point3D position, Vector d, double Kc, double Ki, double Kq)
	{
		super(color,position,Kc,Ki,Kq);
		this.direction = new Vector(d);
	}
	

	
	public SpotLight(SpotLight spotL)
	{
		super(spotL.get_color(),spotL.get_position(), spotL.get_Kc(), spotL.get_Ki(), spotL.get_Kq());
		this.direction = new Vector(spotL.direction);
	}

	// ***************** Getters/Setters ********************** // 


	public Vector getDirection() 
	{
		return this.direction;
	}

	public void setDirection(Vector direction)
	{
		this.direction = direction;
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
		SpotLight other = (SpotLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "SpotLight [direction=" + direction + "]";
	}
	
	// ***************** Operations ******************** //

	public Color getIntensity(Point3D point)
	{
		int r = this.get_color().getRed();
		int g = this.get_color().getGreen();
		int b = this.get_color().getBlue();
		
		double distance = get_position().Distance3P(point);
		double k = (this.get_Kc() + this.get_Ki()*distance + this.get_Kq()*Math.pow(distance, 2));
		
		if (k > 1)
			k=1;

		Color color = new Color((int)(Math.abs(r / k)), (int)((Math.abs(g / k))), (int)((Math.abs(b / k))));
		Vector l = getL(point);
		l.Normalization();
		double kk = Math.abs(this.direction.DotProduct(l));
		
		if(kk > 1)
			kk = 1;
		
		Color IO = new Color((int)(color.getRed() * kk), 
				(int)(color.getGreen() * kk), 
				(int)(color.getBlue() * kk));
		
		return IO;
	}
}
