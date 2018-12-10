//Nechama Zeff 312732019,Michal Mattayev 206089781

package UnitTest;


import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import Geometries.*;
import Primitives.*;

public class TriangleTest
{

	@Test
	public void getNormalTests()
	{
		Triangle T=new Triangle(new Color(0), new Point3D(0.0,0.0,0.0), new Point3D(1.0,0.0,1.0), new Point3D(1.0,0.0,0.0) );
		Vector v1 = T.GetNormal(new Point3D(0,0,0));
	
		System.out.println(v1);
		
		assertTrue(v1.equals(new Vector(0.0,1.0,-0.0)));
	}
	@Test
	public void IntersectionTest()
	{
		// no intersections
				Triangle t=new Triangle(new Point3D(100,-100,-200),new Point3D(-100,-100,-200),new Point3D(0,100,-200));
				Ray ray =new Ray(new Point3D(0,0,0),new Vector(2,2,2));
				ArrayList<Point3D> intersections = t.findIntersections(ray);
				assertEquals(intersections.isEmpty(),true);
		
       // exist intersection
				Ray ray2 =new Ray(new Point3D(0,0,0),new Vector(0,0,-1));
				ArrayList<Point3D> intersections2 = t.findIntersections(ray2);
				assertEquals(intersections2.isEmpty(),false);
				
				Ray ray3 =new Ray(new Point3D(0,0,0),new Vector(2,-2,-5));
				ArrayList<Point3D> intersections3 = t.findIntersections(ray3);
				ArrayList<Point3D> temp2 = new ArrayList<Point3D>();
				temp2.add(new Point3D(80.00000369670303,-80.00000369670303,-200.00000924175754));
				assertEquals(intersections3,temp2);
				
				
				//Triangle t2=new Triangle(new Point3D(-2,2,6),new Point3D(2,2,6),new Point3D(0,-4,6));
				//Ray ray4 =new Ray(new Point3D(1,0,0),new Vector(-0.2,0,1));
				//ArrayList<Point3D> intersections4 = t2.findIntersections(ray4);
				ArrayList<Point3D> temp3 = new ArrayList<Point3D>();
				temp3.add(new Point3D(-0.2,0,6));
				//assertEquals(intersections4,temp3);
		
	}
	
}