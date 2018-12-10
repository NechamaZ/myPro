package Geometries;

import Primitives.*;

import java.awt.Color;
import java.util.ArrayList; 

public class Sphere extends Geometry implements FlatGeometry
{
	private Point3D _center;
	private double _radius;
	
	// ***************** Constructors ********************** //
	
	public Sphere ()
	{
		super();
		_center = new Point3D();
		_radius=0;
	}
	
	public Sphere (Color color, Material material, Point3D c1, double r)
	{
		super(color,material);
		_center = new Point3D(c1);
		_radius=r;
	}
	
	public Sphere (Color color, Point3D c1, double r)
	{
		super(color);
		_center = new Point3D(c1);
		_radius=r;
	}
	
	public Sphere (Point3D c1, double r)
	{
		super();
		_center = new Point3D(c1);
		_radius=r;
	}
	
	public Sphere (Sphere s1)
	{
		super(s1.get_emmission(),s1.get_material());
		_center = new Point3D(s1.get_center());
		_radius=s1.get_radius();
	}
	
	// ***************** Getters/Setters ********************** // 
	public double get_radius() 
	{
		return _radius;
	}


	public void set_radius(double radius) 
	{
		this._radius = radius;
	}
	
	public Point3D get_center()
	{
		return _center;
	}

	public void set_center(Point3D _center)
	{
		this._center = _center;
	}
	
	// ***************** Administration  ******************** // 
	
	@Override
	public String toString() {
		return "Sphere [_center=" + _center + ", _radius=" + _radius + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
	
	// ***************** Operations ******************** //

	@Override
	public Vector GetNormal(Point3D p)
	{
		Vector v = new Vector(p.Substrct(_center));
		return v.Normalization();
	}
	

	@Override
	public ArrayList<Point3D> findIntersections(Ray ray)
	{
		ArrayList<Point3D> Intersections = new ArrayList<Point3D>();
		Vector V = ray.getDirection().Normalization();
		Vector L = new Vector (_center.Substrct(ray.get_POO()));
		double tm = L.DotProduct(V);
		double d = Math.sqrt((Math.pow(L.Length(),2)- Math.pow(tm, 2)));
		
		if (d > get_radius())
			return Intersections;
		
		double th = Math.pow(Math.pow(get_radius(), 2)- Math.pow(d, 2),0.5);
		double t1 = tm - th;
		double t2 = tm + th;
		
		if (t1 >0)
			Intersections.add(new Point3D(ray.get_POO().Add(V.Scaling((float)t1).get_head())));
		
		if (t2 >0)
			Intersections.add(new Point3D(ray.get_POO().Add(V.Scaling((float)t2).get_head())));
		
		return Intersections;
	}
}
