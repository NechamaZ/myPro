package Elements;

import java.util.ArrayList;

import Primitives.*;

public class Camera 
{
	private Point3D _P0;
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;

	
	// ***************** Constructors ********************** //
	
	public Camera ()
	{
		this._P0 = new Point3D(0,0,0);
		this._vUp = new Vector(0,1,0);
		this._vTo = new Vector(0,0,-1);
		this._vRight = new Vector(1,0,0);
	}
	
	public Camera (Point3D p1, Vector v1, Vector v2, Vector v3)
	{
		this._P0 = p1;
		this._vUp = v1;
		this._vTo = v2;
		this._vRight = v3;
	}
	
	public Camera (Camera camera)
	{
		this._P0 = new Point3D(camera.get_P0());
		this._vUp = new Vector(camera.get_vUp());
		this._vTo = new Vector(camera.get_vTo());
		this._vRight = new Vector(camera.get_vRight());
	}

	// ***************** Getters/Setters ********************** // 

	public Point3D get_P0()
	{
		return this._P0;
	}

	public void set_P0(Point3D _P0) 
	{
		this._P0 = _P0;
	}

	public Vector get_vUp()
	{
		return this._vUp;
	}

	public void set_vUp(Vector _vUp)
	{
		this._vUp = _vUp;
	}

	public Vector get_vTo() 
	{
		return this._vTo;
	}

	public void set_vTo(Vector _vTo) 
	{
		this._vTo = _vTo;
	}

	public Vector get_vRight()
	{
		return this._vRight;
	}

	public void set_vRight(Vector _vRight) 
	{
		this._vRight = _vRight;
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
		Camera other = (Camera) obj;
		if (_P0 == null) {
			if (other._P0 != null)
				return false;
		} else if (!_P0.equals(other._P0))
			return false;
		if (_vRight == null) {
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vTo == null) {
			if (other._vTo != null)
				return false;
		} else if (!_vTo.equals(other._vTo))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Camera [_P0=" + _P0 + ", _vUp=" + _vUp + ", _vTo=" + _vTo + ", _vRight=" + _vRight + "]";
	}
	
	// ***************** Operations ******************** //
	
	
	public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight) 	    	//P=Pc+[[(X-(Nx/2)*Rx+(Rx/2)]*Vright-[(Y-(Ny/2)*Ry+(Ry/2)]*Vup]

	{

		Vector v1 = new Vector(_vTo.Scaling(screenDist));
		Point3D Pc = new Point3D(_P0.Add(v1.get_head()));
		Vector v_r = new Vector(_vTo.CrossProduct(_vUp).Normalization());
		
		_vTo.Normalization();
		_vUp.Normalization();
		
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		double Nx2 = Nx/2.0;
		double Ny2 = Ny/2.0;
		
		double Rx2 = screenWidth/(Nx*2.0);
		double Ry2 = screenHeight/(Ny*2.0);
		
		double Sx = (x - Nx2)*Rx + Rx2;
		double Sy = (y - Ny2)*Ry + Ry2;
		
		Vector v = new Vector(v_r.Scaling(Sx).SubstrctV(_vUp.Scaling(Sy)));
		Point3D p = new Point3D(Pc.Add(v.get_head()));
		Vector direction = new Vector(p.Substrct(_P0));
		
		return new Ray(_P0,direction);	
	}
	
	
	
	public ArrayList<Ray> constructRayThroughPixel2  (int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight)
	{

		Vector v1 = new Vector(_vTo.Scaling(screenDist));
		Point3D Pc = new Point3D(_P0.Add(v1.get_head()));
		Vector v_r = new Vector(_vTo.CrossProduct(_vUp).Normalization());
		
		_vTo = _vTo.Normalization();
		_vUp = _vUp.Normalization();
		
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		double Nx2 = Nx/2.0;
		double Ny2 = Ny/2.0;
		
		ArrayList<Ray> Rays = new ArrayList<Ray>();
		double Sx = (x - Nx2)*Rx;
		double Sy = (y - Ny2)*Ry;
		
		for (int i = 0; i < 3 ; i++)
		{
			Sx += Rx*0.25;
			
			for (int j = 0; j < 3; j++)
			{
				Sy += Ry*0.25;
				Vector v = v_r.Scaling(Sx).SubstrctV(_vUp.Scaling(Sy));
				Point3D p = Pc.Add(v);
				Vector direction = new Vector(p.Substrct(_P0));
				Rays.add(new Ray(_P0,direction));
			}
		}
		
		return Rays;
	}
}