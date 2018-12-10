package UnitTest;

import java.awt.Color;

import org.junit.Test;

import Geometries.*;
import Primitives.*;
import Renderer.ImageWriter;
import Renderer.Render;

import Scene.Scene;

public class RenderTest {

	@Test
	public void SceneTest()
	{
		Sphere s = new Sphere(new Color(64,64,64), new Point3D(0,0,-150), 50);
		
		Triangle t1=new Triangle(new Color(64,64,64), 
			     new Point3D(100,0,-149),
				 new Point3D(0,100,-149),
				 new Point3D(100,100,-149) );
		//right down
		Triangle t2=new Triangle(new Color(102,102,255),
				new Point3D(100,0,-149), 
				new Point3D(0,-100,-149),
				new Point3D(100,-100,-149) );
		//left below
		Triangle t3=new Triangle(new Color(50,200,50),
				new Point3D(-100,0,-149), 
				new Point3D(0,100,-149), 
				new Point3D(-100,100,-149) );
		
		Triangle t4=new Triangle(new Color(255,102,102),
				new Point3D(-100,0,-149),
				new Point3D(0,-100,-149), 
				new Point3D(-100,-100,-149) );
		
		
		
		
		Scene scene =new Scene();
		ImageWriter image = new ImageWriter("Scene",500,500,500,500); //500x500 picture size
		scene.addGeometry (s);
		scene.addGeometry (t1);
		scene.addGeometry (t2);
		scene.addGeometry (t3);
		scene.addGeometry (t4);
        Render r = new Render( image,scene);
        
       /*r.renderImage();    */ 
        r.printGrid(50);
        r.writeToImage();
		
		
	}

}
