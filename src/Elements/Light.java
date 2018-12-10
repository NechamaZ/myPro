package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public abstract class Light
{
	Color _color;
	
	// ***************** Constructors ********************** //

	public Light()
	{
		_color = new Color(255,255,255);
	}

	public Light(int r, int g, int b)
	{
		this._color = new Color(r,g,b);
	}
	
	public Light (Color c)
	{
		_color = c;
	}
	
	public Light(Light l)
	{
		this._color = new Color (l.get_color().getRed(),l.get_color().getGreen(),l.get_color().getBlue());
	}
	
	// ***************** Getters/Setters ********************** // 

	public Color get_color() 
	{
		return _color;
	}
	public void set_color(Color _color)
	{
		this._color = _color;
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
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Light [_color=" + _color + "]";
	}
	
	// ***************** Operations ******************** //

	public abstract Color getIntensity(Point3D point); 


	  public abstract Vector getL(Point3D point);
	
}
