package UnitTest;

import java.awt.Color;

import org.junit.Test;

import Elements.AmbientLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Coordinate;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class RecursiveTest {

	
	@Test
	public void recursiveTest(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Point3D(0.0, 0.0, -1000), 500);
		Material m=new Material();
		m.set_n(20);
		m.set_Kt(0.5);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20), new Point3D(0.0, 0.0, -1000), 250);
		Material m2=new Material();
		m2.set_n(20);
		m2.set_Kt(0);
		sphere2.set_material(m2);
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
	
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Point3D(-550, -500, -1000), 300);
		Material m=new Material();
		m.set_n(20);
		m.set_Kt(0.5);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20), new Point3D(-550, -500, -1000), 150);
		Material m2=new Material();
		m2.set_n(20);
		m2.set_Kt(0);
		sphere2.set_material(m2);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Color(20, 20, 20),
				                         new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375));
		
		Triangle triangle2 = new Triangle(new Color(20, 20, 20),
				                          new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500));
		
		Material m3=new Material();
		Material m4=new Material();
		m3.set_Kr(1);
		m4.set_Kr(0.5);
		triangle.set_material(m3);
		triangle2.set_material(m4);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
	
	@Test
public void testReflectionRefraction()  
{
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		Sphere c= new Sphere(new Color(0, 0, 100),new Material(1,1,20,0,0.5), new Point3D(-550, -500, -1000),300);
		scene.addGeometry(c);
		Sphere c2= new Sphere(new Color(100, 20, 20),new Material(1,1,20,0,0), new Point3D(-550, -500, -1000),150);
		scene.addGeometry(c2);

		Triangle triangle = new Triangle(new Color (20, 20, 20),new Material(1,1,20,1,0),new Point3D(1500, -1500, -1500),
				new Point3D(-1500, 1500, -1500),
				new Point3D( 200,  200, -375));	
		scene.addGeometry(triangle);
		
		Triangle triangle1 = new Triangle(new Color (20, 20, 20),new Material(1,1,20,0.5,0),new Point3D(1500, -1500, -1500),
				new Point3D(-1500, 1500, -1500),
				new Point3D(-1500, -1500, -1500));
		scene.addGeometry(triangle1);
		
		
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150),new Vector(new Point3D(-2, -2, -3)),0, 0.00001, 0.000005));
		
		ImageWriter imageWriter = new ImageWriter("Reflection Refraction", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		imageWriter.writeToimage();
	}
	
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Point3D(0, 0, -1000), 300);
		Material m=new Material();
		m.set_n(20);
		m.set_Kt(0.5);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20), new Point3D(0, 0, -1000), 150);
		Material m1=new Material();
		m1.set_n(20);
		m1.set_Kt(0);
		sphere2.set_material(m1);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Color(20, 20, 20),
				                         new Point3D(  2000, -1000, -1500),
				 						 new Point3D( -1000,  2000, -1500),
				 						 new Point3D(  700,  700, -375));
		
		Triangle triangle2 = new Triangle(new Color(20, 20, 20),
				                          new Point3D(  2000, -1000, -1500),
										  new Point3D( -1000,  2000, -1500),
										  new Point3D( -1000, -1000, -1500));
		
		Material m2=new Material();
		m2.set_Kr(1);
		triangle.set_material(m2);

		Material m3=new Material();
		m3.set_Kr(0.5);
		triangle2.set_material(m3);
		
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
	////////////////////////////////////////////////////////////////
	/*@Test
	public void recursiveTest4b()
	{
		
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		
	//	Triangle triangle = new Triangle(new Point3D(-125, -225, -260)
	//			,new Point3D(-225, -125, -260),new Point3D(-225, -225, -270));
		
	//	Triangle triangle = new Triangle(new Point3D(75, -25, -260)
	//			,new Point3D(-25, 75, -260),new Point3D(-25, -25, -270));
		
		Triangle triangle = new Triangle(new Point3D(-75, -175, -260)
			,new Point3D(-175, -75, -260),new Point3D(-175, -175, -270));
		
	
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 600);
		sphere.get_material().set_n(20);
		sphere.set_emmission(new Color(0, 0, 255));
		sphere.get_material().set_Kt(1);
		scene.addGeometry(sphere);
	
		Sphere sphere2 = new Sphere(new Point3D(0.0, 0.0, -1000), 100);
		sphere2.get_material().set_n(1000);
		sphere2.set_emmission(new Color(0, 0, 0));
		sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere2);
		
		Sphere sphere3 = new Sphere(new Point3D(0.0, 0.0, -1000), 300);
		sphere3.get_material().set_n(20);
		sphere3.set_emmission(new Color(225, 20, 20));
		sphere3.get_material().set_Kt(0.5);
		scene.addGeometry(sphere3);
		
		triangle.get_material().set_n(20);
		triangle.set_emmission(new Color(102, 0, 102));
		triangle.get_material().set_Kt(0);
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 4b", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
		
	}*/
	
	/*@Test
	public void recursiveTest4a()
	{
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
	//	Triangle triangle = new Triangle(new Point3D(-125, -225, -260)
	//			,new Point3D(-225, -125, -260),new Point3D(-225, -225, -270));
		
	//	Triangle triangle = new Triangle(new Point3D(75, -25, -260)
	//			,new Point3D(-25, 75, -260),new Point3D(-25, -25, -270));
		
		Triangle triangle = new Triangle(new Point3D(-75, -175, -260)
			,new Point3D(-175, -75, -260),new Point3D(-175, -175, -270));
		
	
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 600);
		sphere.get_material().set_n(20);
		sphere.set_emmission(new Color(0, 0, 255));
		sphere.get_material().set_Kt(1);
		scene.addGeometry(sphere);
	
		Sphere sphere2 = new Sphere(new Point3D(0.0, 0.0, -1000), 100);
		sphere2.get_material().set_n(1000);
		sphere2.set_emmission(new Color(0, 0, 0));
		sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere2);
		
		Sphere sphere3 = new Sphere(new Point3D(0.0, 0.0, -1000), 300);
		sphere3.get_material().set_n(20);
		sphere3.set_emmission(new Color(225, 20, 20));
		sphere3.get_material().set_Kt(0.5);
		scene.addGeometry(sphere3);
		
		triangle.get_material().set_n(20);
		triangle.set_emmission(new Color(102, 0, 102));
		triangle.get_material().set_Kt(0);
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 4a", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
	}*/
	
	@Test
	public void recursiveTestBeforeSupersampling()
	{
		
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		
		Triangle triangle2 = new Triangle(new Point3D(-125, -225, -260)
				,new Point3D(-225, -125, -260),new Point3D(-225, -225, -270));
		
		
		Triangle triangle = new Triangle(new Point3D(-100, -200, -260)
				,new Point3D(-200, -100, -260),new Point3D(-200, -200, -270));
		
	//	Triangle triangle = new Triangle(new Point3D(-75, -175, -260)
	//		,new Point3D(-175, -75, -260),new Point3D(-175, -175, -270));
		
	
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 400);
		sphere.get_material().set_n(20);
		sphere.set_emmission(new Color(0, 0, 255));
		sphere.get_material().set_Kt(1);
		scene.addGeometry(sphere);
	
		Sphere sphere2 = new Sphere(new Point3D(0.0, 0.0, -1000), 100);
		sphere2.get_material().set_n(1000);
		sphere2.set_emmission(new Color(0, 0, 0));
		sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere2);
		
		Sphere sphere3 = new Sphere(new Point3D(0.0, 0.0, -1000), 300);
		sphere3.get_material().set_n(20);
		sphere3.set_emmission(new Color(225, 20, 20));
		sphere3.get_material().set_Kt(0.5);
		scene.addGeometry(sphere3);
		
		triangle.get_material().set_n(20);
		triangle.set_emmission(new Color(149, 3, 62));
		triangle.get_material().set_Kt(0);
		scene.addGeometry(triangle);
		
		triangle2.get_material().set_n(20);
		triangle2.set_emmission(new Color(149, 3, 62));
		triangle2.get_material().set_Kt(0);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test before supersamplimg", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
		
	}
	@Test
	public void recursiveTestAfterSupersampling()
	{
		
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		
		Triangle triangle2 = new Triangle(new Point3D(-125, -225, -260)
				,new Point3D(-225, -125, -260),new Point3D(-225, -225, -270));
		
		
		Triangle triangle = new Triangle(new Point3D(-100, -200, -260)
				,new Point3D(-200, -100, -260),new Point3D(-200, -200, -270));
		
	//	Triangle triangle = new Triangle(new Point3D(-75, -175, -260)
	//		,new Point3D(-175, -75, -260),new Point3D(-175, -175, -270));
		
	
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 400);
		sphere.get_material().set_n(20);
		sphere.set_emmission(new Color(0, 0, 255));
		sphere.get_material().set_Kt(1);
		scene.addGeometry(sphere);
	
		Sphere sphere2 = new Sphere(new Point3D(0.0, 0.0, -1000), 100);
		sphere2.get_material().set_n(1000);
		sphere2.set_emmission(new Color(0, 0, 0));
		sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere2);
		
		Sphere sphere3 = new Sphere(new Point3D(0.0, 0.0, -1000), 300);
		sphere3.get_material().set_n(20);
		sphere3.set_emmission(new Color(225, 20, 20));
		sphere3.get_material().set_Kt(0.5);
		scene.addGeometry(sphere3);
		
		triangle.get_material().set_n(20);
		triangle.set_emmission(new Color(149, 3, 62));
		triangle.get_material().set_Kt(0);
		scene.addGeometry(triangle);
		
		triangle2.get_material().set_n(20);
		triangle2.set_emmission(new Color(149, 3, 62));
		triangle2.get_material().set_Kt(0);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test after supersampling", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.supersampling();
		render.writeToImage();
		
	}
	
	/*@Test
	public void recursiveTest6()
	{
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		scene.set_background(new Color(10,20,100));
		
		Sphere s1= new Sphere (new Color(0, 0, 0), new Point3D(-250,0,-300), 200); // purple
		s1.get_material().set_Kt(1);
		s1.get_material().set_n(1);
		Sphere s2= new Sphere (new Color(255, 51, 0), new Point3D(100,100,-300), 70); // orange
		s2.get_material().set_n(50);
		Sphere s3= new Sphere (new Color(200, 0, 102), new Point3D(100,100,-300), 100); //pink
		s3.get_material().set_Kr(1);
		s3.get_material().set_Kt(0.5);
		s3.get_material().set_n(50);
//		Sphere s4= new Sphere (new Color(10, 200, 0), new Point3D(100,-100,-300), 90); // green
//		s4.get_material().set_nShininess(20);
//		s4.get_material().set_Kr(1);
//		Sphere s5 = new Sphere(new Color(0,0,200), new Point3D(100,100,-300), 50);
//		s5.get_material().set_nShininess(10);
		Sphere s6 = new Sphere();
		s6.set_emmission(new Color(50,40,30));
		s6.get_material().set_Kr(0);
		s6.set_center(new Point3D(0,-200,0));
		s6.set_radius(200);

		scene.addGeometry(s1);
		scene.addGeometry(s2);
		scene.addGeometry(s3);
//		scene.addGeometry(s4);
//		scene.addGeometry(s5);
		scene.addGeometry(s6);

//		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
//				   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		scene.addLight(new SpotLight(new Color(200, 150, 100), new Point3D(-300,0,-300), 
				   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		
       ImageWriter imageWriter = new ImageWriter("Recursive Test 6", 500, 500, 500, 500);
       Sphere testSphere = new Sphere((new Color(20, 30,200)), new Point3D(200,200,200), 180);
       scene.addGeometry(testSphere);
//       scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
//			   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
	}*/
	
	/*@Test
	public void testRefractionRays() {
		
		Scene scene = new Scene();
		scene.set_ambientLight(new AmbientLight(new Color(255,255,255),0.1));
		scene.addGeometry(new Sphere(new Color(0, 0, 0),new Material(1,1,20,0,0.4), new Point3D(500,500, -1000),800));
		scene.addGeometry(new Sphere(new Color(100, 50, 0),new Material(1,1,20,0,0), new Point3D(0.0,0.0,-1000),500));
		
		scene.addLight(new SpotLight(new Color(0, 0, 0),new Point3D(200, 200,0),new Vector(2,2,-3), 0, 0.000001, 0.000005 ));
		
		ImageWriter imageWriter = new ImageWriter("SpotSRayTest", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();

		imageWriter.writeToimage();
		
	}*/
	
	@Test
	public void recursiveTestButy()
	{
	    Scene scene = new Scene();
		scene.set_screenDistance(400);
		
		
		Sphere s1= new Sphere (new Color(255,0,0), new Point3D(0.0,-7.0, -152),14); // 
		s1.get_material().set_Kr(1);
		s1.get_material().set_n(20);
		Sphere s2= new Sphere (new Color(255,128,0), new Point3D(18.0,15, -152),14); // 
		s2.get_material().set_Kr(1);
		s2.get_material().set_n(20);
		Sphere s3= new Sphere (new Color(255,255,0), new Point3D(50.0,20, -152),15); // 
		s3.get_material().set_Kr(1);
		s3.get_material().set_n(20);
		Sphere s4= new Sphere (new Color(0,204,0), new Point3D(60.0,-10, -152),16); // 
		s4.get_material().set_Kr(1);
		s4.get_material().set_n(20);
		Sphere s5= new Sphere (new Color(0,204,204), new Point3D(45.0,-40, -152),18); // 
		s5.get_material().set_Kr(1);
		s5.get_material().set_n(20);
		Sphere s6= new Sphere (new Color(0,0,255), new Point3D(13,-60, -152),19); // 
		s6.get_material().set_Kr(1);
		s6.get_material().set_n(10);
		Sphere s7= new Sphere (new Color(127,0,255), new Point3D(-29,-50, -152),23); // 
		s7.get_material().set_Kr(1);
		s7.get_material().set_n(10);
		Sphere s8= new Sphere (new Color(204,0,204), new Point3D(-55,-1, -152),30); // 
		s8.get_material().set_Kr(1);
		s8.get_material().set_n(100);
		Sphere s9= new Sphere (new Color(255,153,204), new Point3D(-19,53,-152),34); // 
		s9.get_material().set_Kr(1);
		//s9.get_material().set_Kt(1);
		s9.get_material().set_n(100);
		
		
		scene.addLight(new SpotLight(new Color(255, 102, 178), new Point3D(-200, -200, -50), 
                         new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		//scene.addLight(new SpotLight(new Color(160, 160, 160), new Point3D(-300,0,-300), 
		//		   new Vector(2, 2, -3), 0.1, 0.000001, 0.000005));
		scene.addLight(new SpotLight(new Color(255, 102, 178), new Point3D(-300,0,-300), 
				   new Vector(30, -5, -10), 0.1, 0.00001, 0.000005));
			
		Triangle triangle = new Triangle(new Color(100,255,0),
              	 new Point3D( 100, -100, -150), 
                new Point3D(  -100, 100, -150), 
                new Point3D( 100, 100,-150));		
		scene.addGeometry(s1);
		scene.addGeometry(s2);
		scene.addGeometry(s3);
		scene.addGeometry(s4);
		scene.addGeometry(s5);
		scene.addGeometry(s6);
		scene.addGeometry(s7);
		scene.addGeometry(s8);
		scene.addGeometry(s9);
		
		scene.addGeometry(triangle);

		 ImageWriter imageWriter = new ImageWriter("Recursive & Shadow & Light TestButy", 500, 500, 500, 500);
			//Color color=new Color(64,64,64);
			Render render = new Render(imageWriter, scene);
			//scene.set_background(color);
			render.renderImage();
			render.writeToImage();
		}
	
	@Test
	public void recursiveTestButy2()
	{
	    Scene scene = new Scene();
		scene.set_screenDistance(400);
		
		
		Sphere s1= new Sphere (new Color(255,0,0), new Point3D(0.0,-7.0, -152),14); // 
		s1.get_material().set_Kr(1);
		s1.get_material().set_n(20);
		Sphere s2= new Sphere (new Color(255,128,0), new Point3D(18.0,15, -152),14); // 
		s2.get_material().set_Kr(1);
		s2.get_material().set_n(20);
		Sphere s3= new Sphere (new Color(255,255,0), new Point3D(50.0,20, -152),15); // 
		s3.get_material().set_Kr(1);
		s3.get_material().set_n(20);
		Sphere s4= new Sphere (new Color(0,204,0), new Point3D(60.0,-10, -152),16); // 
		s4.get_material().set_Kr(1);
		s4.get_material().set_n(20);
		Sphere s5= new Sphere (new Color(0,204,204), new Point3D(45.0,-40, -152),18); // 
		s5.get_material().set_Kr(1);
		s5.get_material().set_n(20);
		Sphere s6= new Sphere (new Color(0,0,255), new Point3D(13,-60, -152),19); // 
		s6.get_material().set_Kr(1);
		s6.get_material().set_n(10);
		Sphere s7= new Sphere (new Color(127,0,255), new Point3D(-29,-50, -152),23); // 
		s7.get_material().set_Kr(1);
		s7.get_material().set_n(10);
		Sphere s8= new Sphere (new Color(204,0,204), new Point3D(-55,-1, -152),30); // 
		s8.get_material().set_Kr(1);
		s8.get_material().set_n(100);
		Sphere s9= new Sphere (new Color(255,153,204), new Point3D(-19,53,-152),34); // 
		s9.get_material().set_Kr(1);
		s9.get_material().set_n(100);
		
		
		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
                         new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		scene.addLight(new SpotLight(new Color(200, 150, 100), new Point3D(-300,0,-300), 
				   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
		scene.addLight(new SpotLight(new Color(0, 102, 204), new Point3D(-300,0,-300), 
				   new Vector(30, -5, -10), 0.1, 0.00001, 0.000005));
			
		Triangle triangle = new Triangle(new Color(100,255,0),
              	 new Point3D( 100, 0, -150), 
                new Point3D(  0, 100, -150), 
                new Point3D( 100, 100,-150));		
		scene.addGeometry(s1);
		scene.addGeometry(s2);
		scene.addGeometry(s3);
		scene.addGeometry(s4);
		scene.addGeometry(s5);
		scene.addGeometry(s6);
		scene.addGeometry(s7);
		scene.addGeometry(s8);
		scene.addGeometry(s9);
		
		scene.addGeometry(triangle);

		 ImageWriter imageWriter = new ImageWriter("Recursive & Shadow & Light TestButy2", 500, 500, 500, 500);
			//Color color=new Color(64,64,64);
			Render render = new Render(imageWriter, scene);
			//scene.set_background(color);
			render.renderImage();
			render.writeToImage();
		}
	
	

	

}
	
