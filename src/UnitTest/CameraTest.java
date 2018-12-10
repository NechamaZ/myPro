package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Elements.Camera;
import Primitives.*;

public class CameraTest 
{

	@Test
	public void constructRayThroughPixelTest()
	{
		Camera camera = new Camera();
		Ray ray = new Ray(camera.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150));
		
		assertEquals(ray,new Ray(new Point3D(0,0,0), new Vector (100,-100,-100)));
		assertFalse(ray.equals(camera.constructRayThroughPixel(2, 3, 3, 3, 100, 150, 150)));
	}
}
