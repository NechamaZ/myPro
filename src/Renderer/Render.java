package Renderer;

import java.awt.Color;
import java.awt.List;
import java.util.Map;
import java.util.Map.Entry;

import Elements.Light;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Geometries.FlatGeometry;

import Geometries.Geometry;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;

public class Render 
{

	  Scene _scene;
	  ImageWriter _imageWriter;
	  private static int RECURSION_LEVEL=3;

	  
	//***************** Constructors ********************** // 
	  public Render(ImageWriter _imageWriter,Scene _scene) 
	  {
			super();
			this._scene = _scene;
			this._imageWriter = _imageWriter;
		}
	  
	  public Render(Render render)
		{
			this._imageWriter = new ImageWriter(render._imageWriter);
			this._scene = new Scene(render._scene);
		}
	  
	//***************** Getters/Setters ********************** // 

		public ImageWriter get_imageWriter()
		{
				return _imageWriter;	
		}

		public void set_imageWriter(ImageWriter _imageWriter)	
		{
				this._imageWriter = _imageWriter;
		}

		public Scene get_scene() 
		{
				return _scene;
		}

		public void set_scene(Scene _scene) 
		{
				this._scene = _scene;
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
			Render other = (Render) obj;
			if (_imageWriter == null) {
				if (other._imageWriter != null)
					return false;
			} else if (!_imageWriter.equals(other._imageWriter))
				return false;
			if (_scene == null) {
				if (other._scene != null)
					return false;
			} else if (!_scene.equals(other._scene))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Render [_scene=" + _scene + ", _imageWriter=" + _imageWriter + "]";
		}
		
		// ***************** Operations ******************** //
		public void printGrid(int interval) 
		{
			for(int i=0; i<_imageWriter.getHeight(); i++)
			{
				for(int j=0; j<_imageWriter.getWidth(); j++)
				{
					if( (i % interval == 0) || (j % interval == 0) )
					{
						_imageWriter.writePixel(i, j, new Color(255,255,255));
					}
				}
				_imageWriter.writeToimage();
			}
		}
		
		
		public void renderImage()
		{
				for (int i=0; i< _imageWriter.getHeight(); i++)
					for (int j=0; j< _imageWriter.getWidth(); j++)
					{
						Ray ray =_scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(),
								_imageWriter.getNy(), j, i,_scene.get_screenDistance(), _imageWriter.getWidth(), 
								_imageWriter.getHeight());
						Map<Geometry,ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
						
						if (intersectionPoints.isEmpty())
							_imageWriter.writePixel(j, i, _scene.get_background());
						else
						{
							Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
							for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
					        _imageWriter.writePixel(j, i, calcColor(e.getKey(),e.getValue(), ray ));
								//_imageWriter.writePixel(j, i, calcColor(e.getKey(),e.getValue()));
						}
	
				}
		}
	
		
		// Supersampling
		public void supersampling()
		{
				for (int i=0; i< _imageWriter.getHeight(); i++)
					for (int j=0; j< _imageWriter.getWidth(); j++)
					{
						ArrayList<Ray> rays =_scene.get_camera().constructRayThroughPixel2(_imageWriter.getNx(),
								_imageWriter.getNy(), j, i,_scene.get_screenDistance(), _imageWriter.getWidth(), 
								_imageWriter.getHeight());
						
						int red = 0, blue = 0, green = 0;
						for (Ray ray : rays)
						{
							Map<Geometry,ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
							
							if (intersectionPoints.isEmpty())
							{
								Color back = _scene.get_background();
								red += back.getRed();
								green += back.getGreen();
								blue += back.getBlue();
							}
							else
							{
								Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
								for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
								{
									Color color = calcColor(e.getKey(), e.getValue(), ray);
									red += color.getRed();
									green += color.getGreen();
									blue += color.getBlue();
								}
							}
						}
						
						red /= 10;
						green /= 10;
						blue /= 10;
						_imageWriter.writePixel(j, i, new Color(red, green,blue));
					}
		}
		
		
		private Map<Geometry,ArrayList<Point3D>> getSceneRayIntersections(Ray ray) 
		{
				Iterator<Geometry> geometries = _scene.getGeometriesIterator();
				Map<Geometry,ArrayList<Point3D>> intersectionPoints = new HashMap<Geometry,ArrayList<Point3D>>();

				while (geometries.hasNext())
				{
					Geometry geometry = geometries.next();
					ArrayList<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
					
					if(!geometryIntersectionPoints.isEmpty())
						intersectionPoints.put(geometry, geometryIntersectionPoints);
				}
				return intersectionPoints;
		}
		 
		private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> intersectionPoints) 
		{
			double distance = Double.MAX_VALUE;
			Point3D P0 = _scene.get_camera().get_P0();
			Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
			
			for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
			{
				for (Point3D point : entry.getValue())
				{
					double pointDistance = P0.Distance3P(point);
					
					if (pointDistance < distance)
					{
						minDistancePoint.clear();
						minDistancePoint.put(entry.getKey(), new Point3D(point));
						distance = pointDistance;
					}
				}
			}
				return minDistancePoint;
		}
		
		
		  
		 /* private Color calcColor(Geometry geometry) 
		  {
			  Color c = geometry.get_emmission();
			   //return new Color(15,245,253);
			   return c;
		  }*/
		
		
		private Color calcColor(Geometry geometry, Point3D point, Ray inRay) //Shell function
		{
			return calcColor(geometry, point, inRay, 0);
		} 
		
		
		private Color calcColor(Geometry geometry,Point3D closestPoint,Ray inRay,int level) 
		{
			if (level == RECURSION_LEVEL) 
				return new Color(0, 0, 0);
			
			Color emissionLight = geometry.get_emmission();
			Color ambientLight = _scene.get_ambientLight().getIntensity(new Point3D(0,0,0));
			Iterator <Light> lights = _scene.getLightsIterator();
			int DiffRed = 0, DiffGreen = 0, DiffBlue = 0, SpecRed = 0, SpecGreen = 0, SpecBlue = 0;
			
			while (lights.hasNext())
			{
				Light current = lights.next();
				if ((!occluded(current, closestPoint, geometry)) && (current.getL(closestPoint).DotProduct(geometry.GetNormal(closestPoint)) < 0))
				{
					Color  diffuseLight = calcDiffusiveComp(geometry.get_material().get_Kd(),
													geometry.GetNormal(closestPoint),
													current.getL(closestPoint),
													current.getIntensity(closestPoint));
					
					Color specularLight = calcSpecularComp (geometry.get_material().get_Ks(),
														new Vector(closestPoint.Substrct(_scene.get_camera().get_P0())),						
														geometry.GetNormal(closestPoint),
														current.getL(closestPoint),
														geometry.get_material().get_n(),
														current.getIntensity(closestPoint));
					
					 DiffRed = DiffRed + diffuseLight.getRed();
					 DiffGreen = DiffGreen + diffuseLight.getGreen();
					 DiffBlue = DiffBlue + diffuseLight.getBlue();
					 SpecRed = SpecRed + specularLight.getRed();
					 SpecGreen = SpecGreen + specularLight.getGreen();
					 SpecBlue = SpecBlue + specularLight.getBlue();
				 
				}
			}
			// Recursive call for a reflected ray
			double kr = geometry.get_material().get_Kr();
			Color reflectedLight= new Color(0,0,0);
			if (kr != 0) //מראתיות
			{
				Color reflectedColor = new Color(0,0,0);
				Ray reflectedRay = constructReflectedRay(geometry.GetNormal(closestPoint), closestPoint, inRay);
				Map<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay);
				for(Entry<Geometry,Point3D> e: reflectedEntry.entrySet())
					reflectedColor = calcColor(e.getKey(), e.getValue(), reflectedRay,level+1);
				reflectedLight = new Color ((int)(kr * reflectedColor.getRed()),(int)(kr * reflectedColor.getGreen()),(int)(kr * reflectedColor.getBlue()));
			}
			
			// Recursive call for a retracted ray
			double kt = geometry.get_material().get_Kt();
			Color refractedLight = new Color(0,0,0);
			if (kt != 0) //שקיפות
			{
				Ray refractedRay = constructRefractedRay(geometry.GetNormal(closestPoint), closestPoint, inRay);
				Map<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
				Color refractedColor = new Color(0,0,0);
				for(Entry<Geometry,Point3D> e: refractedEntry.entrySet())
					refractedColor = calcColor(e.getKey(),e.getValue(), refractedRay ,level+1);		
				 refractedLight = new Color ((int)(kt * refractedColor.getRed()),(int)(kt * refractedColor.getGreen()),(int)(kt * refractedColor.getBlue()));
			}
			
			int red = ambientLight.getRed()+emissionLight.getRed()+DiffRed + SpecRed + reflectedLight.getRed() + refractedLight.getRed();
			int green = ambientLight.getGreen()+emissionLight.getGreen()+ DiffGreen+SpecGreen + reflectedLight.getGreen() + refractedLight.getGreen();
			int blue = ambientLight.getBlue()+emissionLight.getBlue()+ DiffBlue + SpecBlue + reflectedLight.getBlue() + refractedLight.getBlue();
			
			
			
			if (red>255)	red=255;
			if (green>255)	green=255;
			if (blue>255)	blue=255;
			return new Color(red,green,blue);
		}

		
	
		private Ray constructReflectedRay(Vector getNormal, Point3D closestPoint, Ray inRay)  //R = D - 2(D・N)N
		{
			Vector D=inRay.getDirection();
			D= D.Normalization();
			getNormal=getNormal.Scaling(-2*D.DotProduct(getNormal));
			D = D.AddV(getNormal);
			Vector R = new Vector(D);
			R = R.Normalization();
			closestPoint = closestPoint.Add(getNormal.get_head());
			Ray ReflectedRay= new Ray(closestPoint, R);
			return ReflectedRay;
		}
		
		private Ray constructRefractedRay(Vector getNormal, Point3D closestPoint, Ray inRay) //R=(n1/n2)(cosϴi-cosϴr)N-(n1/n2)D
		{
			//Vector D=inRay.getDirection();
			//D= D.Normalization();
			//Point3D n1= D.get_head();
			
			getNormal = getNormal.Scaling(-2);
			closestPoint = closestPoint.Add(getNormal.get_head());
			Ray RefractedRay= new Ray(closestPoint,inRay.getDirection());
			return RefractedRay;
			
			//Vector D= new Vector(inRay.getDirection());
			//Vector N= new Vector(getNormal);
			//Vector EpsVector = new Vector(N.Scaling(-2));
			//Point3D p = new Point3D(closestPoint.Add(EpsVector));
			//return new Ray(p,D);
			
		}
		
		private Map<Geometry, Point3D> findClosestIntersection(Ray reflectedRay) 
		{
			Map<Geometry, ArrayList<Point3D>> intersections = getSceneRayIntersections(reflectedRay);
			Map<Geometry, Point3D> ClosestPoint=  getClosestPoint(intersections);
			return ClosestPoint;
		}


		private Color calcDiffusiveComp(double kd, Vector normal , Vector L , Color lightIntensity)
		{
			L = L.Normalization();
			normal = normal.Normalization();
			double k = kd * normal.DotProduct(L);
			
			if(k>0) // If the direction of the normal point with the same sign with the direction of the vector coming out of the lamp
				return new Color(0,0,0);
			
			k = Math.abs(k);
			
			int red = (int)(lightIntensity.getRed() * k);
			int green = (int)(lightIntensity.getGreen() * k);
			int blue = (int)(lightIntensity.getBlue() * k);
			
			if (red<0)		
				red=0;
			if (green<0)	
				green=0;
			if (blue<0)		
				blue=0;
			if (red>255)	
				red=255;
			if (green>255)	
				green=255;
			if (blue>255)	
				blue=255;
			
			return new Color(red,green,blue);
		}
		
		private Color calcSpecularComp (double ks , Vector V , Vector normal , Vector L , int shininess , Color intensity)//j
		{	 
			L = L.Normalization();
			normal = normal.Normalization();
			V = V.Normalization();
			double x = (L.DotProduct(normal));//x=(d*N)
			if (x > 0) // If the direction of the normal point with the same sign with the direction of the vector coming out of the lamp
				return new Color(0,0,0);
			
			double d = x*2; // d = (x)*2
			Vector R = L.SubstrctV(normal.Scaling(d));//R=D*N-(d*N)*2	
			double temp = Math.abs(ks * Math.pow(V.DotProduct(R), shininess));
			
			int red = (int) (intensity.getRed()*temp);
			int green = (int) (intensity.getGreen()*temp);
			int blue = (int) (intensity.getBlue()*temp);
			
			if (red<0)		
				red=0;
			if (green<0)
				green=0;
			if (blue<0)	
				blue=0;
			if (red>255)
				red=255;
			if (green>255)
				green=255;
			if (blue>255)
				blue=255;
			
			return new Color(red,green,blue);	
		}
		
		   
		public void writeToImage() 
		{
			_imageWriter.writeToimage();
		}
		

		private boolean occluded(Light light, Point3D point, Geometry geometry) 
		{
				Vector lightDirection = light.getL(point);
				//lightDirection.Scaling(-1);
				lightDirection = lightDirection.Scaling(-1); 
				
				Point3D geometryPoint = new Point3D(point);  
				Vector epsVector = new Vector(geometry.GetNormal(point));
				epsVector.Scaling(2);
				geometryPoint.Add(epsVector);
				
				Ray lightRay = new Ray(geometryPoint, lightDirection); 
				Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
				
				// Flat geometry cannot self intersect  
				if (geometry instanceof FlatGeometry)
				{
					intersectionPoints.remove(geometry);
				}
				
				for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
				{
					if (entry.getKey().get_material().get_Kt() == 0)
					    return true;
					 return false;
                }
					
				intersectionPoints.remove(geometry); 

				return !intersectionPoints.isEmpty();
		}
}
