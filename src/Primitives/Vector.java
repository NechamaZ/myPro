package Primitives;

public class Vector {
	
private Point3D _head;
	
	// ***************** Constructors ********************** //

	public Vector() 
	{
		this._head = new Point3D();
	}
	
	public Vector (Point3D p1)
	{
		this._head = new Point3D(p1);
	}
	
	public Vector (double xHead,  double yHead, double zHead)
	{
		this._head = new Point3D(xHead, yHead, zHead);
	}	
	
	public Vector (Vector v1)
	{
		this._head = new Point3D(v1._head);
	}
	
	// ***************** Getters/Setters ********************** // 
	
	public Point3D get_head()
	{
		return new Point3D(_head);
	}

	public void set_head(Point3D head)
	{
		this._head = head;
	}
	// ***************** Administration  ******************** // 
	
	
		public boolean equals(Object obj) 
		{
			
			if (this.getClass() != obj.getClass())
				return false;
			Vector other = (Vector) obj;
			return (this._head.equals(other._head));
		}
		
		
		public String toString() {
			return "Vector [head=" + _head + "]";
		}

		// ***************** Operations ******************** //
		
		public Vector AddV (Vector v1)
		{
			return new Vector (this._head.Add(v1));
		}
		
		public Vector SubstrctV (Vector v1)
		{
			return new Vector (this._head.Substrct(v1));
		}
		
		public Vector Scaling (double a)
		{
			return new Vector (this._head.get_x().get_coordinate() * a,
					this._head.get_y().get_coordinate() * a,
					this._head.get_z().get_coordinate() * a);
		}
		public double DotProduct (Vector v1)
		{		
			return (this._head.get_x().get_coordinate() * v1._head.get_x().get_coordinate()) +
					(this._head.get_y().get_coordinate() * v1._head.get_y().get_coordinate()) +
					(this._head.get_z().get_coordinate() * v1._head.get_z().get_coordinate());
		}
		
		public Vector CrossProduct (Vector v1)
		{	
			return new Vector(this._head.get_y().get_coordinate() * v1._head.get_z().get_coordinate() - 
					this._head.get_z().get_coordinate() * v1._head.get_y().get_coordinate(),
					this._head.get_z().get_coordinate() * v1._head.get_x().get_coordinate() - 
					this._head.get_x().get_coordinate() * v1._head.get_z().get_coordinate(),
					this._head.get_x().get_coordinate() * v1._head.get_y().get_coordinate() -
					this._head.get_y().get_coordinate() * v1._head.get_x().get_coordinate());
		}

		public double Length ()
		{
			return Math.abs(Math.sqrt( Math.pow(this._head.get_x().get_coordinate(),2) +  
					Math.pow(this._head.get_y().get_coordinate(),2) +
					Math.pow(this._head.get_z().get_coordinate(),2)));
		}
		
		public Vector Normalization()
		{
			if(Length() != 0)
			{
				return this.Scaling(1/(this.Length()));
			}
			return this;
		}



}
