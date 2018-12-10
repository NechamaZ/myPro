package Elements;

import java.awt.Color;

import Primitives.*;


public class PointLight extends Light 
{
	private Point3D _position;
	private double _Kc, _Ki, _Kq;
	
	// ***************** Constructors ********************** //

	public PointLight()
	{
		super();
		this._position = new Point3D();
		this._Kc = 0.01;
		this._Ki = 0.01;
		this._Kq = 0.01;
	}
	
	public PointLight(Color color, Point3D position, double Kc, double Ki, double Kq)
	{
		super(color);
		this._position = new Point3D(position);
		this._Kc = Kc;
		this._Ki = Ki;
		this._Kq = Kq;
	}
	public PointLight(Light l, Point3D position, double Kc, double Ki, double Kq)
	{
		super(l.get_color());
		this._position = new Point3D(position);
		this._Kc = Kc;
		this._Ki = Ki;
		this._Kq = Kq;
	}
	public PointLight(Point3D _position, double _Kc, double _Ki, double _Kq)
	{
		super();
		this._position = _position;
		this._Kc = _Kc;
		this._Ki = _Ki;
		this._Kq = _Kq;
	}
	
	public PointLight(PointLight LP)
	{
		super(LP.get_color());
		this._position = new Point3D(LP.get_position());
		this._Kc = LP.get_Kc();
		this._Ki = LP.get_Ki();
		this._Kq = LP.get_Kq();
	}

	// ***************** Getters/Setters ********************** // 


	public Point3D get_position() 
	{
		return _position;
	}

	public void set_position(Point3D position)
	{
		this._position = position;
	}

	public double get_Kc() 
	{
		return _Kc;
	}

	public void set_Kc(double _Kc)
	{
		this._Kc = _Kc;
	}

	public double get_Ki()
	{
		return _Ki;
	}

	public void set_Ki(double _Ki)
	{
		this._Ki = _Ki;
	}

	public double get_Kq()
	{
		return _Kq;
	}

	public void set_Kq(double _Kq)
	{
		this._Kq = _Kq;
	}

	// ***************** Administration  ******************** // 

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_Kc) != Double.doubleToLongBits(other._Kc))
			return false;
		if (Double.doubleToLongBits(_Ki) != Double.doubleToLongBits(other._Ki))
			return false;
		if (Double.doubleToLongBits(_Kq) != Double.doubleToLongBits(other._Kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "PointLight [_position=" + _position + ", _Kc=" + _Kc + ", _Ki=" + _Ki + ", _Kq=" + _Kq + "]";
	}
	
	// ***************** Operations ******************** //

	@Override
	public Color getIntensity(Point3D point)
	{
		double distance = point.Distance3P(_position);
		Color color = new Color(this.get_color().getRGB());
		
		double K = 1/(_Kc + _Ki * distance +_Kq * Math.pow(distance, 2));
		
		if(K<1) 
			K=1;
		
		int red = (int)(color.getRed() * K);
		int green = (int)(color.getGreen() * K);
		int blue = (int)(color.getBlue() * K);
		
		if (red<0)		
			red=0;
		if (green<0)
			green=0;
		if (blue<0)		
			blue=0;
		if (red>255)	
			red=255;
		if (green>255)
			green=255;
		if (blue>255)	
			blue=255;
		
		return new Color(red,green,blue);
	}

	@Override
	public Vector getL(Point3D p)
	{
		//return new Vector(p.Substrct(_position)).Normalization();
		
		Point3D p1=new Point3D(p);
		Vector v=new Vector(p1.Substrct(this._position));
	    v.Normalization();
	    return v;
	}
	
}

