package Primitives;

public class Point3D extends Point2D  {
	
private Coordinate _z;
	
	// ***************** Constructors ********************** //

	public Point3D()
	{
		super();
		this._z = new Coordinate();
	}

	public Point3D(Coordinate x, Coordinate y, Coordinate z) 
	{
		super(x,y);
		this._z = new Coordinate(z);
	}
	
	public Point3D(double x, double y, double z)
	{
		super(x,y);
		this._z = new Coordinate(z);
	}
	
	public Point3D (Point3D p1)
	{
		super(p1);
		this._z = new Coordinate(p1._z);
	}
	
	// ***************** Getters/Setters ********************** // 
	
	public Coordinate get_z()
	{
		return new Coordinate(_z);
	}

	public void set_z(Coordinate z)
	{
		this._z = z;
	}
	// ***************** Administration  ******************** // 

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (_z == null) {
			if (other._z != null)
				return false;
		} else if (!_z.equals(other._z))
			return false;
		return true;
	}

	
	public String toString() {
		return "Point3D [_z=" + _z + "]";
	}
	
	// ***************** Operations ******************** //
	
	public double Distance3P (Point3D p1) 
	{
		return Math.abs(Math.sqrt( Math.pow(this.get_x().get_coordinate() - p1.get_x().get_coordinate(),2)) +Math.pow(this.get_y().get_coordinate() - p1.get_y().get_coordinate(),2) + Math.pow(this.get_z().get_coordinate() - p1.get_z().get_coordinate(),2));
	}
	
	public Point3D Add (Vector p1)
	{
		return new Point3D(this.get_x().Add(p1.get_head().get_x()), 
				this.get_y().Add(p1.get_head().get_y()),
				this.get_z().Add(p1.get_head().get_z()));
	}
	
	public Point3D Substrct (Vector p1)
	{
		return new Point3D(this.get_x().Substrct(p1.get_head().get_x()),
				this.get_y().Substrct(p1.get_head().get_y()),
				this.get_z().Substrct(p1.get_head().get_z()));
	}
	
	public Point3D Add (Point3D p1)
	{
		return new Point3D(this.get_x().Add(p1.get_x()), 
				this.get_y().Add(p1.get_y()),
				this.get_z().Add(p1.get_z()));
	}
	
	public Point3D Substrct (Point3D p1)
	{
		return new Point3D(this.get_x().Substrct(p1.get_x()),
				this.get_y().Substrct(p1.get_y()),
				this.get_z().Substrct(p1.get_z()));
	}


	public Point3D Scaling(double a) 
	{
		return new Point3D (this.get_x().get_coordinate() * a,
				this.get_y().get_coordinate() * a,
				this.get_z().get_coordinate() * a);
	}


}

