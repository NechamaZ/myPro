//Nechama Zeff 31273201,Michal Mattayev 206089781


package UnitTest;

import org.junit.Test;
import Primitives.*;
import org.junit.Assert;

public class VectorTest 
{
	
	@Test
	public void testEquals1()
	{
		Vector v = new Vector(1,0,0);
		Vector z = new Vector(1,0,0);
		
		Assert.assertTrue(v.equals(z));
		
	}
	
	@Test
	public void testEquals2()
	{
		Vector v = new Vector(9.5,-6,3);
		Vector z = new Vector(9.5,-6,3);
		
		Assert.assertTrue(v.equals(z));
		
	}
	
	@Test
	public void testAdd1()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(-1,-3,-5);
		Vector v3 = new Vector(-2,-6,-11);
		
		Assert.assertFalse(v3.equals(v1.AddV(v2)));
		
	}
	
	@Test
	public void testAdd2()
	{
		Vector v1 = new Vector(1,-3,-5);
		Vector v2 = new Vector(-1,-3,-5);
		Vector v3 = new Vector(0,-6,-10);
		
		Assert.assertTrue(v3.equals(v1.AddV(v2)));
		
	}
	
	@Test
	public void testSubstruct1()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(-1,-3,-5);
		Vector v3 = new Vector(0,0,0);
		
		Assert.assertTrue(v3.equals(v1.SubstrctV(v2)));
		
	}
	
	@Test
	public void testScaling1()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(-1,-3,-5);
		
		Assert.assertFalse(v2.equals(v1.Scaling(2)));
		
	}
	
	@Test
	public void testScaling2()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(-2,-6,-10);
		
		Assert.assertTrue(v2.equals(v1.Scaling(2)));
		
	}
	
	@Test
	public void testScaling3()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(-1,-3,-5);
		
		Assert.assertFalse(v2.equals(v1.Scaling(-2)));
		
	}
	
	@Test
	public void testScaling4()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(2,6,10);
		
		Assert.assertTrue(v2.equals(v1.Scaling(-2)));
		
	}
	
	@Test
	public void testDotProduct1()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(2,6,10);
		double x = -70;
		Assert.assertTrue(x ==(v1.DotProduct(v2)));
		
	}

	@Test
	public void testDotProduct2()
	{
		Vector v1 = new Vector(-1,-3,-5);
		Vector v2 = new Vector(2,6,10);
		double x = 40;
		Assert.assertFalse(x ==(v1.DotProduct(v2)));
		
	}
	
	@Test
	public void testLength1()
	{
		Vector v1 = new Vector(1,-2,-2);
		double x = 3;
		Assert.assertTrue(x ==(v1.Length()));
		
	}
	
	@Test
	public void testLength2()
	{
		Vector v1 = new Vector(1,-2,-2);
		double x = -3;
		Assert.assertFalse(x ==(v1.Length()));
		
	}
	
	@Test
	public void testCrossProduct1()
	{
		Vector v1 = new Vector(1,-2,-2);
		Vector v2 = new Vector(1,-2,-2);
		Vector v3 = new Vector(0,0,0);

		Assert.assertTrue(v3.equals(v1.CrossProduct(v2)));
		
	}
	
	@Test
	public void Normalization1()
	{
		Vector v1 = new Vector(1,2,2);
		Vector v2 = new Vector(1.0/3.0,2.0/3.0,2.0/3.0);
		
		Assert.assertTrue(v2.equals(v1.Normalization()));
	}
	
}
