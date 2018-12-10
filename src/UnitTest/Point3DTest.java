//Nechama Zeff 312732019,Michal Mattayev 206089781

package UnitTest;


import org.junit.Assert;
import org.junit.Test;

import Primitives.*;

public class Point3DTest {

	@Test
	public void testEquals1()
	{
		Point3D v = new Point3D(1,0,0);
		Point3D z = new Point3D(1,2,7);
		Assert.assertFalse(v.equals(z));
	}

	@Test
	public void testEquals2()
	{
		Point3D v = new Point3D(3,10,10);
		Point3D z = new Point3D(3,10,10);
		Assert.assertTrue(v.equals(z));
	}
	
	@Test
	public void testAdd1()
	{
		Point3D p = new Point3D(1.0,0.0,0.0);
		Vector v = new Vector(3.0,0.0,0.0);
		Point3D p2 = new Point3D(p.Add(v));
		Point3D p3 = new Point3D(4,0,0);
		Assert.assertTrue(p2.equals(p3));

	}
	
	@Test
	public void testAdd2()
	{
		Point3D p1 = new Point3D(1,0,0);
		Vector v = new Vector(6,0,0);
		Point3D p2 = new Point3D(p1.Add(v));
		Point3D p3 = new Point3D(4,0,0);
		Assert.assertFalse(p2.equals(p3));

	}
	@Test
	public void testSubtruct()
	{
		Point3D p1 = new Point3D(4,0,0);
		Vector v = new Vector(1,0,0);
		Point3D p2 = new Point3D(p1.Substrct(v));
		Point3D p3 = new Point3D(3,0,0);
		Assert.assertTrue(p2.equals(p3));

	}

}
