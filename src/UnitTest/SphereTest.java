package UnitTest;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;


import org.junit.Test;

import Geometries.Sphere;
import Primitives.*;

public class SphereTest
{
	@Test
	public void getNormalTest()
	{
		Sphere s = new Sphere(new Color(1,0,0), new Point3D(2,8,2), 4);
		Vector v = s.GetNormal(new Point3D(-1,2,0));
		assertEquals(v,new Vector(-3/7d,-6/7d,-2/7d));
		Vector v1 = s.GetNormal(new Point3D(6,4,0));
		assertEquals(v1,new Vector(4/6d,-4/6d,-1/3d));
	}

	@Test
	public void IntersectionTest1()
	{
		Sphere s = new Sphere(new Color(1,0,0), new Point3D(0,0,-400), 200);
		//Vector l = new Vector (0,0,-400);
		double h = Math.pow(3, -0.5);
		Ray r = new Ray(new Point3D(0,0,0),new Vector(h,-h,-h));
		ArrayList<Point3D> intersections=s.findIntersections(r);
		assertEquals(intersections.isEmpty(),true); //no intersection
	}
	@Test
	public void IntersectionTest2()
	{
		Sphere s = new Sphere(new Color(1,0,0), new Point3D(0,0,-400), 400);
		//Vector l = new Vector (0,0,-400);
		double h = Math.pow(3, -0.5);
		Ray r = new Ray(new Point3D(0,0,0),new Vector(h,-h,-h));
		ArrayList<Point3D> intersections=s.findIntersections(r);
		assertEquals(intersections.isEmpty(),false); //two intersection
		
	}
	@Test
	public void IntersectionTest3()
	{
		Sphere s = new Sphere(new Color(1,0,0), new Point3D(0,0,-400), 326.6);
		//Vector l = new Vector (0,0,-400);
		double h = Math.pow(3, -0.5);
		Ray r = new Ray(new Point3D(0,0,0),new Vector(h,-h,-h));
		ArrayList<Point3D> intersections=s.findIntersections(r);
		assertEquals(intersections.isEmpty(),false); //one intersection
		
	}
}
