package Geometries;
import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;

public class Triangle extends Geometry implements FlatGeometry
{
	private Point3D _p1; 
	private Point3D _p2; 
	private Point3D _p3; 
	
	// ***************** Constructors ********************** //

	public Triangle ()
	{
		super();
		this._p1 = new Point3D();
		this._p2 = new Point3D();
		this._p3 = new Point3D();
	}
	

	
	public Triangle (Color color, Material material, Point3D p1, Point3D p2, Point3D p3)
	{
		super(color, material);
		this._p1 = new Point3D(p1);
		this._p2 = new Point3D(p2);
		this._p3 = new Point3D(p3);
	}
	
	public Triangle (Color color, Point3D p1, Point3D p2, Point3D p3)
	{
		super(color);
		this._p1 = new Point3D(p1);
		this._p2 = new Point3D(p2);
		this._p3 = new Point3D(p3);
	}
	
	public Triangle (Point3D p1, Point3D p2, Point3D p3)
	{
		super();
		this._p1 = new Point3D(p1);
		this._p2 = new Point3D(p2);
		this._p3 = new Point3D(p3);
	}
	
	public Triangle (Triangle t1)
	{
		
		super(t1.get_emmission(),t1.get_material());

		this._p1 = new Point3D(t1._p1);
		this._p2 = new Point3D(t1._p2);
		this._p3 = new Point3D(t1._p3);
	}
	
	// ***************** Getters/Setters ********************** // 

	public Point3D get_p1()
	{
		return _p1;
	}

	public void set_p1(Point3D _p1)
	{
		this._p1 = _p1;
	}

	public Point3D get_p2()
	{
		return _p2;
	}

	public void set_p2(Point3D _p2)
	{
		this._p2 = _p2;
	}

	public Point3D get_p3()
	{
		return _p3;
	}

	public void set_p3(Point3D _p3)
	{
		this._p3 = _p3;
	}
	
	// ***************** Administration  ******************** // 

	@Override
	public boolean equals(Object arg) {
		if (arg.getClass() != this.getClass())
			return false;
		Triangle t = (Triangle)arg;			
		return ((_p1.equals(t.get_p1()) && (_p2.equals(t.get_p2()) 
				&& (_p3.equals(t.get_p3())))));
	}
	
	@Override
	public String toString() 
	{
		return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
	}

	// ***************** Operations ******************** //
	
	public Vector GetNormal(Point3D p)
	{
		Vector v1 = new Vector(_p1.Substrct(_p3));
		Vector v2 = new Vector(_p2.Substrct(_p3));
		return v1.CrossProduct((v2).Normalization());
	}
	
	public ArrayList<Point3D> findIntersections(Ray r)
{
		ArrayList<Point3D> Intersections = new ArrayList<Point3D>();
		Vector v1 = new Vector (_p1.Substrct(r.get_POO())); //V1=_p1-p0
		Vector v2 = new Vector (_p2.Substrct(r.get_POO())); //V2=_p2-p0
		Vector v3 = new Vector (_p3.Substrct(r.get_POO())); //V3=_p3-p0
	
		Vector nr1=new Vector (_p1.Substrct(_p2));
		Vector nr2=new Vector (_p1.Substrct(_p3));
		Vector Normal=new Vector (nr1.CrossProduct(nr2));		
		Plane pl=new Plane(this.get_emmission(),Normal.Normalization(), _p1);
		
		ArrayList<Point3D> tempIntersection= pl.findIntersections(r);
		
		if(tempIntersection.isEmpty())
			return Intersections;
			
		Vector N1 = new Vector(v2.CrossProduct(v1).Normalization());
		Vector N2 = new Vector(v3.CrossProduct(v2).Normalization());
		Vector N3 = new Vector(v1.CrossProduct(v3).Normalization());
		
		for (int i =0; i<tempIntersection.size(); i++ )
		{
			Point3D p_tmp = tempIntersection.get(i);
			Vector v = new Vector(p_tmp.Substrct(r.get_POO()));

			double s1 = v.DotProduct(N1);
			double s2 = v.DotProduct(N2);
			double s3 = v.DotProduct(N3);

			if (Math.signum(s2)==Math.signum(s3)&&Math.signum(s1)==Math.signum(s3)&& Math.signum(s2)!=0)
				Intersections.add(p_tmp);
		}
		return Intersections;

}
	
}
	

