package Elements;

import java.awt.Color;

import Primitives.*;

public class DirectionalLight  extends Light 
{
	private Vector direction;
	
	// ***************** Constructors ********************** //

	public DirectionalLight()
	{
		super();
		this.direction = new Vector();
	}
	
	public DirectionalLight(int r, int g, int b, Vector v)
	{
		super(r,g,b);
		this.direction = new Vector(v);
	}
	
	public DirectionalLight(Color _color,Vector _direction) 
	{
		super(_color);
		this.direction = _direction;
	}
	
	public DirectionalLight(DirectionalLight DL)
	{
		this.direction = new Vector(DL.getDirection());
	}

	// ***************** Getters/Setters ********************** // 

	public Vector getDirection() 
	{
		return direction;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
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
		return "DiretionalLight [direction=" + direction + "]";
	}
	
	// ***************** Operations ******************** //
	
	@Override
	public Color getIntensity(Point3D point)
	{
		return this.get_color();
	}

	@Override
	public Vector getL(Point3D point)
	{
		return new Vector(point.Substrct(direction.get_head())).Normalization();
	}
}


