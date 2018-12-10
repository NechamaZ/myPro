package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import java.awt.Color;
import java.util.ArrayList; 

public class Plane extends Geometry implements FlatGeometry
{
	private Vector N;
	private Point3D _Q; 

	
	// ***************** Constructors ********************** //

	public Plane ()
	{
		super();
		this._Q = new Point3D();
		this.N = new Vector(1,0,0);
	}
	
	public Plane(Color color, Vector v, Point3D q) {
		super(color);
		this.N = v;
		this._Q = q;
	}
	
	public Plane (Color color, Material material, Vector v, Point3D q)
	{
		super(color,material);
		this._Q = new Point3D(q);
		this.N = new Vector(v);
	}
	
	public Plane (Plane t1)
	{
		super(t1.get_emmission(),t1.get_material());
		this._Q = new Point3D(t1._Q);
		this.N = new Vector(t1.N);
	}

	// ***************** Getters/Setters ********************** // 

	public Point3D get_Q()
	{
		return this._Q;
	}

	public void set_Q(Point3D q) 
	{
		this._Q = q;
	}
	
	public Vector getN() 
	{
		return this.N;
	}

	public void setN(Vector v)
	{
		this.N = v;
	}
	
	// ***************** Administration  ******************** // 

	@Override
	public boolean equals(Object arg) 
	{
		if(!super.equals(arg))
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Plane p = (Plane)arg;
		if (this.N.equals(p.getN()) && this._Q.equals(p.get_Q()))
			return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+" Point p: "+this._Q+" Vertical: "+this.N;
	}
	
	// ***************** Operations ******************** //

	@Override
	public Vector GetNormal(Point3D p)
	{
		return N.Normalization();
	}
	
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) 
	{
		ArrayList<Point3D> Intersections = new ArrayList<Point3D>();
		Vector V = ray.getDirection().Normalization();
		Vector _N = N.Scaling(-1);
		Point3D temp = ray.get_POO().Substrct(_Q);
		float scaler = (float)N.DotProduct(V);
		
		if (scaler == 0)
			return Intersections;
		
		double t = _N.DotProduct(new Vector(temp).Scaling(1/scaler));
		Intersections.add(new Point3D(ray.get_POO().Add(V.Scaling((float)t).get_head())));
		return Intersections;	 
	}
	
}


