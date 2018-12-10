package Geometries;

import java.awt.Color;
import java.util.ArrayList;

import Primitives.*;
public abstract class Geometry 
{
	private Material _material;
	private Color _emmission;

	// ***************** Constructors ********************** //
	public Geometry()
	{
		this._material = new Material();
		this._emmission = new Color(0,0,0);
	}
	
	public Geometry(Color color, Material material)
	{
		this._material = new Material(material);
		this._emmission = color;
	}
	
	public Geometry(Color color)
	{
		this._emmission = color;
		this._material = new Material();
	}
	

	

	// ***************** Getters/Setters ********************** // 

	public Material get_material()
	{
		return _material;
	}

	public void set_material(Material _material)
	{
		this._material = _material;
	}

	public Color get_emmission() 
	{
		return _emmission;
	}

	public void set_emmission(Color color) 
	{
		this._emmission = color;
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
		Geometry other = (Geometry) obj;
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		if (_emmission == null) {
			if (other._emmission != null)
				return false;
		} else if (!_emmission.equals(other._emmission))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Geometry [_material=" + _material + ", gcolor=" + _emmission + "]";
	} 
	
	// ***************** Operations ******************** //

	public abstract Vector GetNormal(Point3D p);
	public abstract ArrayList<Point3D> findIntersections(Ray ray);
	
}

