package Primitives;

public class Ray {

	Point3D _POO;
	Vector direction;
	
	// ***************** Constructors ********************** //
	
	public Ray()
	{
		this._POO = new Point3D(0,0,0);
		this.direction = new Vector();
	}
	
	public Ray(Point3D poo, Vector direction)
	{
		this._POO = new Point3D(poo);
		this.direction = new Vector(direction);
	}
	
	public Ray(Ray ray)
	{
		this._POO = new Point3D(ray.get_POO());
		this.direction = new Vector(ray.getDirection());
	}
	
	
	// ***************** Getters/Setters ********************** // 

	public Point3D get_POO() 
	{
		return new Point3D(_POO);
	}

	public void set_POO(Point3D _POO)
	{
		this._POO = _POO;
	}

	public Vector getDirection() 
	{
		return new Vector(direction);
	}

	public void setDirection(Vector direction)
	{
		this.direction = direction;
	}
	
	// ***************** Administration  ******************** // 

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (_POO == null) {
			if (other._POO != null)
				return false;
		} else if (!_POO.equals(other._POO))
			return false;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}

	
	public String toString() {
		return "Ray [_POO=" + _POO + ", direction=" + direction + "]";
	}



}
