package UnitTest;

import java.awt.Color;


import org.junit.Test;

import Elements.AmbientLight;
import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class LightingTest 
{
	
	@Test 
	public void emmissionTest()
	{
		
		Scene scene = new Scene();
		scene.set_screenDistance(150);
		scene.addGeometry(new Sphere(new Color(255,0,0), new Point3D(0.0, 0.0, -152), 50));
		
		Triangle triangle = new Triangle(new Color(0,255,0), //green
			                           	 new Point3D( 100, 0, -150), 
				                         new Point3D(  0, 100, -150), 
				                         new Point3D( 100, 100,-150));
		
		Triangle triangle2 = new Triangle(new Color(0,0,255), //blue
				                          new Point3D( 100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(new Color(255,255,0), //yellow
				                          new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(new Color(255,0,255),//pink
				                          new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		//scene.addLight(new SpotLight(new Color(255,0,0), new Point3D(0.0, 0.0, -149), 
		//		   new Vector(2, 2, -3), 0.1, 0.01, 0.05));
		
		ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		imageWriter.writeToimage();
	}
	
	
	
	@Test
	public void spotLightTest2b()
	{
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 500);
		sphere.set_emmission(new Color(0, 0, 100));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		//sphere.get_material().set_n(20);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
				                         new Point3D(-225, -125, -260),
			                          	 new Point3D(-225, -225, -270));
			                          	 
		triangle.set_emmission(new Color (0, 0, 100));
		Material m1=new Material();
		m1.set_n(4);
		triangle.set_material(m1);
		//triangle.get_material().set_n(4);
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Spot test 2b", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
	
	
	
	@Test
	public void spotLightTest2a()
	{
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 500);
		sphere.set_emmission(new Color(0, 0, 100));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		//sphere.get_material().set_n(20);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
				                         new Point3D(-225, -125, -260),
			                          	 new Point3D(-225, -225, -270));
			                          	 
		triangle.set_emmission(new Color (0, 0, 100));
		Material m1=new Material();
		m1.set_n(4);
		triangle.set_material(m1);
		//triangle.get_material().set_n(4);
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Spot test 2 after Supersampling", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.supersampling();
		imageWriter.writeToimage();
		
	}

	
	
	@Test
	public void spotLightTest()
	{
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 800);
		sphere.set_emmission(new Color(0, 0, 100));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
					   new Vector(2, 2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
	}

	@Test
	public void ambientLightTest1()
	{
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 800);
		sphere.set_emmission(new Color(0, 0, 100));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		//scene.addLight(new AmbientLight(new Color(255, 100, 100),0.000005));
		scene.set_ambientLight(new AmbientLight(new Color(247, 247, 247),0.2));
	
		ImageWriter imageWriter = new ImageWriter("Ambient test k=0.2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
	}
	
	@Test
	public void ambientLightTest2()
	{
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 800);
		sphere.set_emmission(new Color(0, 0, 100));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		//scene.addLight(new AmbientLight(new Color(255, 100, 100),0.000005));
		scene.set_ambientLight(new AmbientLight(new Color(247, 247, 247),0.7));
	
		ImageWriter imageWriter = new ImageWriter("Ambient test k=0.7", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
	}
	 
	@Test
	public void pointLightTest()
	{
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere (new Point3D(0.0, 0.0, -1000), 800);
		sphere.set_emmission(new Color(0, 0, 100));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
		
	}
	
	@Test
	public void NoLight()
	{
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere (new Point3D(0.0, 0.0, -1000), 800);
		sphere.set_emmission(new Color(0, 0, 100));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		//scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("with no light", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
		
	}
	
	
	@Test
	public void spotLightTest3(){
		
		Scene scene = new Scene();
		
		Triangle triangle = new Triangle(new Color(0,0,0),new Material(1,1,1),
				                         new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0),new Material(1,1,1),
				                          new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
	
	
	@Test
	public void pointLightTest2Before(){ 
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Point3D(0.0, 0.0, -1000), 800);
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color(0,0,0),
				                         new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0),
				                          new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test 2b", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
		
	}
	
	@Test
	public void pointLightTest2after(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Point3D(0.0, 0.0, -1000), 800);
		Material m=new Material(1,1,1);
		m.set_n(20);
		sphere.set_material(m);
		
		Triangle triangle = new Triangle(new Color(0,0,0),new Material(1,1,1),
				                         new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));
				 						 

		Triangle triangle2 = new Triangle(new Color(0,0,0),new Material(1,1,1),
				                          new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test 2a", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		imageWriter.writeToimage();
	}

	
	
	@Test
	public void pointLightTest3(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 200), new Point3D(0.0, 0.0, -200), 100);
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		Triangle triangle = new Triangle(new Color(0,0,0),
				                         new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0),
				                          new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test 33", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
		
	}
	
	/*@Test
	public void shadowTest() { //take off occluded code
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere( new Point3D(0.0, 0.0, -1000),500);
		sphere.get_material().set_n(20);
		sphere.set_emmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),new Vector(-2, -2, -3), 
				0, 0.000001, 0.0000005));
		
		//scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005));	
		
		ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
		Render render = new Render( imageWriter, scene);
		render.renderImage();
		render.writeToImage();	
	}*/
	
	

	@Test
	public void NoShadowTest() {
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere( new Point3D(0.0, 0.0, -1000),500);
		sphere.get_material().set_n(20);
		sphere.set_emmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),new Vector(-2, -2, -3), 
				0, 0.000001, 0.0000005));
		
		//scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005));	
		
		ImageWriter imageWriter = new ImageWriter("no shadow", 500, 500, 500, 500);
		Render render = new Render( imageWriter, scene);
		render.renderImage();
		render.writeToImage();	
	}

	


}