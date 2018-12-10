//Nechama Zeff 31273201,Michal Mattayev 206089781


package Scene;
import java.util.List;
import Geometries.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import Elements.*;

import Elements.Camera;

public class Scene 
{
	 String _sceneNamep;
	 Color _background;
	 AmbientLight _ambientLight;
	 ArrayList<Geometry> _geometries;
	 Camera _camera;
	 double _screenDistance;
	 List<Light> _lights;
	 
		// ***************** Constructors ********************** //

	 public Scene()
		{
			this._sceneNamep = new String();
			this._background = Color.black;
			this._ambientLight=new AmbientLight();
			this._geometries = new ArrayList<Geometry>();
			this._camera = new Camera();
			this._screenDistance = 100;
			this._lights = new ArrayList<Light>();
		}
	 
	 public Scene(String _sceneName, Color _background, Camera _camera, double _screenDistance, ArrayList<Light> _lights, ArrayList<Geometry> geometries, AmbientLight _ambientLight) 
		{
			this._sceneNamep = _sceneName;
			this._background = _background;
			this._camera = _camera;
			this._screenDistance = _screenDistance;
			this._lights = _lights;
			this._geometries = geometries;
			this._ambientLight = _ambientLight;
		}
		
		public Scene(Scene scene)
		{
			this._sceneNamep = scene._sceneNamep;
			this._background = scene._background;
			this._ambientLight = new AmbientLight(scene._ambientLight);
			this._geometries = new ArrayList<Geometry>(scene._geometries);
			this._camera = new Camera(scene._camera);
			this._screenDistance = scene._screenDistance;
			this._lights = new ArrayList<Light>(scene._lights);
		}
	
	// ***************** Getters/Setters ********************** // 

	public AmbientLight get_ambientLight() {
		return _ambientLight;
	}
	
	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}
	
	public List<Light> get_lights() {
		return _lights;
	}
	
	public void set_lights(List<Light> _lights) {
		this._lights = _lights;
	}
	
	public String get_sceneNamep() {
		return _sceneNamep;
	}
	
	public void set_sceneNamep(String _sceneNamep) {
		this._sceneNamep = _sceneNamep;
	}
	
	public Color get_background() {
		return _background;
	}
	
	public void set_background(Color _background) {
		this._background = _background;
	}
	
	public ArrayList<Geometry> get_geometries() {
		return _geometries;
	}
	
	public void set_geometries(ArrayList<Geometry> _geometries) {
		this._geometries = _geometries;
	}
	
	public Camera get_camera() {
		return _camera;
	}
	
	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}
	
	public double get_screenDistance() {
		return _screenDistance;
	}
	
	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}
	
	// ***************** Administration  ******************** // 

    @Override
	public String toString() {
		return "Scene [_sceneNamep=" + _sceneNamep + ", _background=" + _background + ", _ambientLight=" + _ambientLight
				+ ", _geometries=" + _geometries + ", _camera=" + _camera + ", _screenDistance=" + _screenDistance
				+ ", _lights=" + _lights + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scene other = (Scene) obj;
		if (_ambientLight == null) {
			if (other._ambientLight != null)
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_background == null) {
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null) {
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_lights == null) {
			if (other._lights != null)
				return false;
		} else if (!_lights.equals(other._lights))
			return false;
		if (_sceneNamep == null) {
			if (other._sceneNamep != null)
				return false;
		} else if (!_sceneNamep.equals(other._sceneNamep))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}

	
	// ***************** Operations ******************** //
	
	public void addGeometry (Geometry geometry)
	{
		this._geometries.add(geometry);
	}
	

	public Iterator<Geometry>getGeometriesIterator()
	{
		return _geometries.iterator();

	}

	public Iterator<Light> getLightsIterator()
	{
		return _lights.iterator();
	}
	
	public void addLight(Light light) 
	{
		_lights.add(light);
	} 
}
