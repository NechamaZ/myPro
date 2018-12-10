package Primitives;

//import Renderer.ImageWriter;
//import Renderer.Render;
//import Scene.Scene;

public class Material 
{

	private double _Kd; // Diffusion attenuation coefficient -pizur haor
	private double _Ks; // Specular attenuation coefficient-hachzarat haor
	private int _n;  // Refraction index (nShininess)
	private double _Kr; // Reflection
	private double _Kt; //Refraction
	
	//***************** Constructors ********************** // 

	public Material(double kd, double ks, int n) 
	{
		this._Kt = 0;
		this._Kr = 0;
		this._Kd = kd;
		this._Ks = ks;
		this._n = n;
	}
	
	public Material(double kd, double ks, int n, double kt, double kr)
	{
		this._Kt = kt;
		this._Kr = kr;
		this._Kd = kd;
		this._Ks = ks;
		this._n = n;
	}

	public Material()
	{
		super();
		this._Kd = 1; 
		this._Ks = 1;
		this._Kr = 0; // מראתיות  Perfect mirror has a KR of 1 and matt surface has a KR of 0
		this._Kt = 0; //שקיפות
		this._n = 1;
	}
	
	public Material(Material material)
	{
		this._Kd=material.get_Kd();
		this._Ks=material.get_Ks();
		this._Kr=this.get_Kr();
		this._Kt=this.get_Kt();
		this._n=material.get_n();
	}
	

	// ***************** Getters/Setters ********************** // 

	public double get_Kr() {
		return _Kr;
	}

	public void set_Kr(double _Kr) {
		this._Kr = _Kr;
	}

	public double get_Kt() {
		return _Kt;
	}

	public void set_Kt(double _Kt) {
		this._Kt = _Kt;
	}

	public double get_Kd() {
		return _Kd;
	}

	public void set_Kd(double _Kd) {
		this._Kd = _Kd;
	}

	public double get_Ks() {
		return _Ks;
	}

	public void set_Ks(double _Ks) {
		this._Ks = _Ks;
	}

	public int get_n() {
		return _n;
	}

	public void set_n(int n) 
	{
		if (_n<0)
			_n=0;
		this._n = n;
	}

	
	
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Material [_Kd=" + _Kd + ", _Ks=" + _Ks + ", _n=" + _n + ", _Kr=" + _Kr + ", _Kt=" + _Kt + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_Kd) != Double.doubleToLongBits(other._Kd))
			return false;
		if (Double.doubleToLongBits(_Kr) != Double.doubleToLongBits(other._Kr))
			return false;
		if (Double.doubleToLongBits(_Ks) != Double.doubleToLongBits(other._Ks))
			return false;
		if (Double.doubleToLongBits(_Kt) != Double.doubleToLongBits(other._Kt))
			return false;
		if (_n != other._n)
			return false;
		return true;
	}
	



  

}

