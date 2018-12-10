package Primitives;

public class Point2D {
	
	private Coordinate _x;
	private Coordinate _y;
	
	// ***************** Constructors ********************** //
	
	public Point2D()
	{
		this._x = new Coordinate(0);
		this._y = new Coordinate(0);
	}
	
	public Point2D(Coordinate x, Coordinate y) 
	{
		this._x = new Coordinate(x);
		this._y = new Coordinate(y);
	}
	
	public Point2D (double x, double y)
	{
		this._x = new Coordinate(x);
		this._y = new Coordinate(y);
	}
	
	public Point2D (Point2D p1)
	{
		this._x = new Coordinate(p1._x);
		this._y = new Coordinate(p1._y);
	}
	
	// ***************** Getters/Setters ********************** // 

	public Coordinate get_x() 
	{
		return new Coordinate(_x);
	}

	public void set_x(Coordinate _x)
	{
		this._x = _x;
	}

	public Coordinate get_y()
	{
		return new Coordinate(_y);
	}

	public void set_y(Coordinate _y)
	{
		this._y = _y;
	}

	public String toString()
	{
		return "Point2D (" + this._x + "," + this._y + ")";
	}
	
	// ***************** Administration  ******************** // 
	
	
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (_x == null) {
			if (other._x != null)
				return false;
		} else if (!_x.equals(other._x))
			return false;
		if (_y == null) {
			if (other._y != null)
				return false;
		} else if (!_y.equals(other._y))
			return false;
		return true;
	}

	
	

}
