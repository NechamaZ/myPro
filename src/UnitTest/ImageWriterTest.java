package UnitTest;

import static org.junit.Assert.*;

import java.awt.Color;
import org.junit.Test;
import Renderer.ImageWriter;

public class ImageWriterTest
{
	@Test
	public void test1() 
	{
		ImageWriter imageWriter=new ImageWriter("image1", 500, 500, 100,100 );
		for (int i = 0; i < imageWriter.getHeight(); i++)
		{
			for (int j = 0; j < imageWriter.getWidth(); j++)
			{
				//if(i == 500 || j  == 500)
					imageWriter.writePixel(j, i, 255, 255,255); //white picture
			}
		}
		imageWriter.writeToimage();
	}
	
	@Test
	public void test2() 
	{
		ImageWriter imageWriter=new ImageWriter("image2", 500, 500, 100,100 );
		for (int i = 0; i < imageWriter.getHeight(); i++)
		{
			for (int j = 0; j < imageWriter.getWidth(); j++)
			{
				if(i == j || j % 50==0 || i==250)
					imageWriter.writePixel(j, i, 100, 150,255); 
			}
		}
		imageWriter.writeToimage();
	}
	
	@Test
	public void test3() 
	{
		int[] intArray = new int[] {255,255,255};
		
		ImageWriter imageWriter=new ImageWriter("image3", 500, 500, 100,100 );
		for (int i = 0; i < imageWriter.getHeight(); i++)
		{
			for (int j = 0; j < imageWriter.getWidth(); j++)
			{
				if(i % 50==0 || j  % 50==0 )
					imageWriter.writePixel(i,j,intArray);
			}
		}
		imageWriter.writeToimage();
	}

	@Test
	public void test4() 
	{
	    Color white = new Color(255, 255, 255);
		ImageWriter imageWriter=new ImageWriter("image4", 500, 500, 100,100 );
		for (int i = 0; i < imageWriter.getHeight(); i++)
		{
			for (int j = 0; j < imageWriter.getWidth(); j++)
			{
				if(i == j)
					imageWriter.writePixel(i,j,white );
			}
		}
		imageWriter.writeToimage();
	}
	
	@Test
	public void testCoolPicture1()
	{
		ImageWriter image = new ImageWriter("coolPicture1",500,500,500,500 ); //500x500 picture size
		printGrid(image);
		
		for(int i=256;i<300;i++)
			for(int j=256;j<300;j++)
				image.writePixel(i,j,255,0,0);
		
		Color c=new Color(255,255,0);
		for(int i=101;i<150;i++)
			for(int j=101;j<i;j++)
				image.writePixel(i,j,c);
		image.writeToimage();
		assertTrue(true);
		}
	
	@Test
	public void testCoolPicture2() //picture of Israel flag with number 70
	{
		ImageWriter image = new ImageWriter("coolPicture2",500,500,500,500 ); //500x500 picture size
		printGrid(image);
		
		for(int i=20;i<480;i++) //upper line
			for(int j=20;j<40;j++)
				image.writePixel(i,j,60,29,185); //blue color
		
		for(int i=20;i<480;i++) //lower line 
			for(int j=460;j<480;j++)
				image.writePixel(i,j,60,29,185);
		
		Color c=new Color(60,29,185); //blue color
		for(int i=240;i<260;i++)
			for(int j=140;j<160;j++)
				image.writePixel(i,j,c);
		
		for(int i=220;i<240;i++)
			for(int j=160;j<180;j++)
				image.writePixel(i,j,c);
		for(int i=260;i<280;i++)
			for(int j=160;j<180;j++)
				image.writePixel(i,j,c);
		for(int i=200;i<220;i++)
			for(int j=180;j<200;j++)
				image.writePixel(i,j,c);
		for(int i=280;i<300;i++)
			for(int j=180;j<200;j++)
				image.writePixel(i,j,c);
		
		for(int i=120;i<380;i++)
			for(int j=200;j<220;j++)
				image.writePixel(i,j,c);
		for(int i=120;i<380;i++)
			for(int j=280;j<300;j++)
				image.writePixel(i,j,c);
		
		for(int i=140;i<160;i++)
			for(int j=220;j<240;j++)
				image.writePixel(i,j,c);
		for(int i=180;i<200;i++)
			for(int j=220;j<240;j++)
				image.writePixel(i,j,c);
		for(int i=300;i<320;i++)
			for(int j=220;j<240;j++)
				image.writePixel(i,j,c);
		for(int i=340;i<360;i++)
			for(int j=220;j<240;j++)
				image.writePixel(i,j,c);
		
		for(int i=160;i<180;i++)
			for(int j=240;j<260;j++)
				image.writePixel(i,j,c);
		for(int i=320;i<340;i++)
			for(int j=240;j<260;j++)
				image.writePixel(i,j,c);
		
		for(int i=140;i<160;i++)
			for(int j=260;j<280;j++)
				image.writePixel(i,j,c);
		for(int i=180;i<200;i++)
			for(int j=260;j<280;j++)
				image.writePixel(i,j,c);
		for(int i=300;i<320;i++)
			for(int j=260;j<280;j++)
				image.writePixel(i,j,c);
		for(int i=340;i<360;i++)
			for(int j=260;j<280;j++)
				image.writePixel(i,j,c);
		
		for(int i=200;i<220;i++)
			for(int j=300;j<320;j++)
				image.writePixel(i,j,c);
		for(int i=280;i<300;i++)
			for(int j=300;j<320;j++)
				image.writePixel(i,j,c);
		for(int i=220;i<240;i++)
			for(int j=320;j<340;j++)
				image.writePixel(i,j,c);
		for(int i=260;i<280;i++)
			for(int j=320;j<340;j++)
				image.writePixel(i,j,c);
		for(int i=240;i<260;i++)
			for(int j=340;j<360;j++)
				image.writePixel(i,j,c);
		
		for(int i=320;i<400;i++) //number 70
			for(int j=360;j<380;j++)
				image.writePixel(i,j,c);
		for(int i=380;i<400;i++)
			for(int j=380;j<400;j++)
				image.writePixel(i,j,c);
		for(int i=360;i<380;i++)
			for(int j=400;j<420;j++)
				image.writePixel(i,j,c);
		for(int i=340;i<360;i++)
			for(int j=420;j<440;j++)
				image.writePixel(i,j,c);
		for(int i=420;i<440;i++)
			for(int j=360;j<440;j++)
				image.writePixel(i,j,c);
		for(int i=460;i<480;i++)
			for(int j=360;j<440;j++)
				image.writePixel(i,j,c);
		for(int i=440;i<460;i++)
			for(int j=360;j<380;j++)
				image.writePixel(i,j,c);
		for(int i=440;i<460;i++)
			for(int j=420;j<440;j++)
				image.writePixel(i,j,c);
		
		image.writeToimage();
		assertTrue(true);
		}
	
	public void printGrid(ImageWriter image) 
	{
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
				if(i%20==0 || j%20==0)
					image.writePixel(i, j, 0,0,0); //black color
				else
			image.writePixel(i, j, 255,255,255); //white color
	}
	
	
		@Test
		public void testCoolPicture3() //picture of heart 
		{
			ImageWriter image = new ImageWriter("coolPicture3",500,500,1,1 ); //500x500 picture size
			printGrid3(image);
			Color c=new Color(225,0,0); //red color
			
			for(int i=100;i<120;i++)
				for(int j=200;j<260;j++)
					image.writePixel(i,j,c);
			
			for(int i=120;i<140;i++)
				for(int j=180;j<280;j++)
					image.writePixel(i,j,c);
			
			for(int i=140;i<160;i++)
				for(int j=160;j<300;j++)
					image.writePixel(i,j,c);
			
			for(int i=160;i<200;i++)
				for(int j=160;j<320;j++)
					image.writePixel(i,j,c);
			
			for(int i=180;i<200;i++)
				for(int j=160;j<340;j++)
					image.writePixel(i,j,c);
			
			for(int i=200;i<220;i++)
				for(int j=160;j<360;j++)
					image.writePixel(i,j,c);
			
			for(int i=220;i<240;i++)
				for(int j=180;j<380;j++)
					image.writePixel(i,j,c);
			
			
			for(int i=240;i<260;i++)
				for(int j=200;j<400;j++)
					image.writePixel(i,j,c);
			
			for(int i=260;i<280;i++)
				for(int j=180;j<380;j++)
					image.writePixel(i,j,c);
			
			for(int i=280;i<300;i++)
				for(int j=160;j<360;j++)
					image.writePixel(i,j,c);
			
			for(int i=300;i<320;i++)
				for(int j=160;j<340;j++)
					image.writePixel(i,j,c);
			
			for(int i=320;i<340;i++)
				for(int j=160;j<320;j++)
					image.writePixel(i,j,c);
			
			for(int i=360;i<380;i++)
				for(int j=180;j<280;j++)
					image.writePixel(i,j,c);
			

			for(int i=380;i<400;i++)
				for(int j=200;j<260;j++)
					image.writePixel(i,j,c);
			
			for(int i=340;i<360;i++)
				for(int j=160;j<300;j++)
					image.writePixel(i,j,c);
	//WE:
			Color c2=new Color(0,0,0); //blue color
		
				for(int j=130;j<170;j++)
					for(int i=20;i<40;i++)
					image.writePixel(j,i,c2);
				for(int j=210;j<250;j++)
					for(int i=20;i<40;i++)
					image.writePixel(j,i,c2);
				
				for(int j=140;j<160;j++)
					for(int i=20;i<120;i++)
					image.writePixel(j,i,c2);
				for(int j=220;j<240;j++)
					for(int i=20;i<120;i++)
					image.writePixel(j,i,c2);
				for(int j=140;j<240;j++)
					for(int i=100;i<120;i++)
					image.writePixel(j,i,c2);
				for(int j=180;j<200;j++)
					for(int i=60;i<120;i++)
					image.writePixel(j,i,c2);
				for(int j=180;j<200;j++)
					for(int i=60;i<120;i++)
					image.writePixel(j,i,c2);
				for(int j=280;j<300;j++)
					for(int i=20;i<120;i++)
					image.writePixel(j,i,c2);
				for(int j=280;j<350;j++)
					for(int i=20;i<40;i++)
					image.writePixel(j,i,c2);
				for(int j=280;j<330;j++)
					for(int i=60;i<80;i++)
					image.writePixel(j,i,c2);
				for(int j=280;j<350;j++)
					for(int i=100;i<120;i++)
					image.writePixel(j,i,c2);
				
			//smaily
				
				for(int j=180;j<200;j++)
					for(int i=220;i<240;i++)
					image.writePixel(j,i,c2);
				
				for(int j=300;j<320;j++)
					for(int i=220;i<240;i++)
					image.writePixel(j,i,c2);
				
				for(int j=240;j<260;j++)
					for(int i=300;i<320;i++)
						image.writePixel(j,i,c2);

				for(int j=220;j<240;j++)
					for(int i=280;i<300;i++)
					image.writePixel(j,i,c2);
				
				//KISS
				//for(int j=220;j<240;j++)
					//for(int i=320;i<340;i++)
					//image.writePixel(j,i,c2);
				
				for(int j=260;j<280;j++)
					for(int i=280;i<300;i++)
					image.writePixel(j,i,c2);
				
				
					
			image.writeToimage();
			assertTrue(true);
	
		
	}
	
	@Test
	public void testCoolPicture4() //Smile face :)
	{
		ImageWriter image3 = new ImageWriter("coolPicture4",500,500,500,500 ); //500x500 picture size
		printGrid4(image3);
		Color c=new Color(246,246,12); //yellow color
		
		for(int i=230;i<280;i++) //all of yellow face
			for(int j=110;j<120;j++)
				image3.writePixel(i,j,c); 
		for(int i=200;i<310;i++)
			for(int j=120;j<130;j++)
				image3.writePixel(i,j,c); 
		for(int i=180;i<330;i++)
			for(int j=130;j<140;j++)
				image3.writePixel(i,j,c); 
		for(int i=160;i<350;i++)
			for(int j=140;j<150;j++)
				image3.writePixel(i,j,c); 
		for(int i=150;i<360;i++)
			for(int j=150;j<160;j++)
				image3.writePixel(i,j,c); 
		for(int i=140;i<170;i++)
			for(int j=160;j<170;j++)
				image3.writePixel(i,j,c); 
		for(int i=210;i<290;i++)
			for(int j=160;j<170;j++)
				image3.writePixel(i,j,c); 
		for(int i=340;i<370;i++)
			for(int j=160;j<170;j++)
				image3.writePixel(i,j,c); 
		for(int i=140;i<160;i++)
			for(int j=170;j<180;j++)
				image3.writePixel(i,j,c); 
		for(int i=220;i<280;i++)
			for(int j=170;j<180;j++)
				image3.writePixel(i,j,c); 
		for(int i=350;i<370;i++)
			for(int j=170;j<180;j++)
				image3.writePixel(i,j,c); 
		for(int i=130;i<150;i++)
			for(int j=180;j<190;j++)
				image3.writePixel(i,j,c); 
		for(int i=230;i<270;i++)
			for(int j=180;j<190;j++)
				image3.writePixel(i,j,c); 
		for(int i=360;i<380;i++)
			for(int j=180;j<190;j++)
				image3.writePixel(i,j,c);
		for(int i=130;i<150;i++)
			for(int j=190;j<200;j++)
				image3.writePixel(i,j,c); 
		for(int i=230;i<270;i++)
			for(int j=190;j<200;j++)
				image3.writePixel(i,j,c); 
		for(int i=360;i<380;i++)
			for(int j=190;j<200;j++)
				image3.writePixel(i,j,c); 
		for(int i=120;i<150;i++)
			for(int j=200;j<210;j++)
				image3.writePixel(i,j,c); 
		for(int i=230;i<270;i++)
			for(int j=200;j<210;j++)
				image3.writePixel(i,j,c); 
		for(int i=360;i<390;i++)
			for(int j=200;j<210;j++)
				image3.writePixel(i,j,c); 
		for(int i=120;i<140;i++)
			for(int j=210;j<220;j++)
				image3.writePixel(i,j,c); 
		for(int i=240;i<260;i++)
			for(int j=210;j<220;j++)
				image3.writePixel(i,j,c); 
		for(int i=370;i<390;i++)
			for(int j=210;j<220;j++)
				image3.writePixel(i,j,c); 
		for(int i=120;i<140;i++)
			for(int j=220;j<310;j++)
				image3.writePixel(i,j,c); 
		for(int i=110;i<120;i++)
			for(int j=230;j<280;j++)
				image3.writePixel(i,j,c); 
		for(int i=140;i<400;i++)
			for(int j=250;j<280;j++)
				image3.writePixel(i,j,c); 
		for(int i=240;i<260;i++)
			for(int j=220;j<250;j++)
				image3.writePixel(i,j,c); 
		for(int i=370;i<390;i++)
			for(int j=220;j<250;j++)
				image3.writePixel(i,j,c); 
		for(int i=390;i<400;i++)
			for(int j=230;j<250;j++)
				image3.writePixel(i,j,c); 
		for(int i=370;i<390;i++)
			for(int j=280;j<310;j++)
				image3.writePixel(i,j,c); 
		for(int i=130;i<150;i++)
			for(int j=310;j<330;j++)
				image3.writePixel(i,j,c); 
		for(int i=140;i<160;i++)
			for(int j=330;j<350;j++)
				image3.writePixel(i,j,c); 
		for(int i=360;i<380;i++)
			for(int j=310;j<330;j++)
				image3.writePixel(i,j,c); 
		for(int i=350;i<370;i++)
			for(int j=330;j<350;j++)
				image3.writePixel(i,j,c); 
		for(int i=230;i<280;i++)
			for(int j=380;j<400;j++)
				image3.writePixel(i,j,c); 
		for(int i=280;i<310;i++)
			for(int j=370;j<390;j++)
				image3.writePixel(i,j,c); 
		for(int i=200;i<230;i++)
			for(int j=370;j<390;j++)
				image3.writePixel(i,j,c); 
		for(int i=180;i<200;i++)
			for(int j=360;j<380;j++)
				image3.writePixel(i,j,c); 
		for(int i=160;i<180;i++)
			for(int j=350;j<370;j++)
				image3.writePixel(i,j,c); 
		for(int i=160;i<170;i++)
			for(int j=340;j<350;j++)
				image3.writePixel(i,j,c); 
		for(int i=150;i<160;i++)
			for(int j=350;j<360;j++)
				image3.writePixel(i,j,c); 
		for(int i=310;i<330;i++)
			for(int j=360;j<380;j++)
				image3.writePixel(i,j,c);
		for(int i=330;i<350;i++)
			for(int j=350;j<370;j++)
				image3.writePixel(i,j,c); 
		for(int i=340;i<350;i++)
			for(int j=340;j<350;j++)
				image3.writePixel(i,j,c); 
		for(int i=350;i<360;i++)
			for(int j=350;j<360;j++)
				image3.writePixel(i,j,c);
		
		for(int i=150;i<360;i++) //brown mouth
			for(int j=290;j<310;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=160;i<350;i++) //brown mouth
			for(int j=310;j<320;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=310;i<350;i++) //brown mouth
			for(int j=320;j<330;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=320;i<340;i++) //brown mouth
			for(int j=330;j<340;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=160;i<270;i++) //brown mouth
			for(int j=320;j<330;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=170;i<260;i++) //brown mouth
			for(int j=330;j<340;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=180;i<250;i++) //brown mouth
			for(int j=340;j<350;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=200;i<240;i++) //brown mouth
			for(int j=350;j<360;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		for(int i=230;i<240;i++) //brown mouth
			for(int j=360;j<370;j++)
				image3.writePixel(i,j,125,70,22); //brown color
		
		
		for(int i=270;i<310;i++) //tongue 
			for(int j=320;j<330;j++)
				image3.writePixel(i,j,253,173,103); //Pink bright color
		for(int i=260;i<320;i++) //tongue 
			for(int j=330;j<340;j++)
				image3.writePixel(i,j,253,173,103); //Pink bright color
		for(int i=250;i<330;i++) //tongue 
			for(int j=340;j<350;j++)
				image3.writePixel(i,j,253,173,103); //Pink bright color
		for(int i=240;i<310;i++) //tongue 
			for(int j=350;j<360;j++)
				image3.writePixel(i,j,253,173,103); //Pink bright color
		for(int i=240;i<280;i++) //tongue 
			for(int j=360;j<370;j++)
				image3.writePixel(i,j,253,173,103); //Pink bright color
		
		for(int i=140;i<370;i++) //black spots around mouth
			for(int j=280;j<290;j++)
				image3.writePixel(i,j,0,0,0); //black color
		for(int i=140;i<150;i++) 
			for(int j=290;j<310;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=360;i<370;i++) 
			for(int j=290;j<310;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=150;i<160;i++) 
			for(int j=310;j<330;j++)
				image3.writePixel(i,j,0,0,0);
		for(int i=350;i<360;i++) 
			for(int j=310;j<330;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=160;i<170;i++) 
			for(int j=330;j<340;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=340;i<350;i++) 
			for(int j=330;j<340;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=170;i<180;i++) 
			for(int j=340;j<350;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=330;i<340;i++) 
			for(int j=340;j<350;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=180;i<200;i++) 
			for(int j=350;j<360;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=310;i<330;i++) 
			for(int j=350;j<360;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=200;i<230;i++) 
			for(int j=360;j<370;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=280;i<310;i++) 
			for(int j=360;j<370;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=230;i<280;i++) 
			for(int j=370;j<380;j++)
				image3.writePixel(i,j,0,0,0); 
		
		for(int i=170;i<210;i++) //black left eye
			for(int j=160;j<170;j++)
				image3.writePixel(i,j,0,0,0); //black color
		for(int i=160;i<200;i++) 
			for(int j=170;j<180;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=150;i<200;i++) 
			for(int j=180;j<200;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=150;i<190;i++) 
			for(int j=200;j<210;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=210;i<220;i++) 
			for(int j=170;j<180;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=220;i<230;i++) 
			for(int j=180;j<210;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=140;i<150;i++) 
			for(int j=210;j<250;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=230;i<240;i++) 
			for(int j=210;j<250;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=140;i<240;i++) 
			for(int j=240;j<250;j++)
				image3.writePixel(i,j,0,0,0);
		
		for(int i=290;i<340;i++) //black right eye
			for(int j=160;j<170;j++)
				image3.writePixel(i,j,0,0,0); //black color
		for(int i=280;i<320;i++) 
			for(int j=170;j<180;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=270;i<320;i++) 
			for(int j=180;j<200;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=340;i<350;i++) 
			for(int j=170;j<180;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=270;i<310;i++) 
			for(int j=200;j<210;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=350;i<360;i++) 
			for(int j=180;j<210;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=260;i<270;i++) 
			for(int j=210;j<250;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=360;i<370;i++) 
			for(int j=210;j<250;j++)
				image3.writePixel(i,j,0,0,0); 
		for(int i=260;i<370;i++) 
			for(int j=240;j<250;j++)
				image3.writePixel(i,j,0,0,0); 
		
		image3.writeToimage();
		assertTrue(true);
		}
	
	public void printGrid4(ImageWriter image3)
	{
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
				if(i%10==0 || j%10==0)
					image3.writePixel(i, j, 0,0,0); //black color
				else
			image3.writePixel(i, j, 255,255,255); //white color
	}
	
	public void printGrid3(ImageWriter image) 
	{
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
				if(i%20==0 || j%20==0)
					image.writePixel(i, j, 0,0,0); //black color
				else
			image.writePixel(i, j, 255,102,255); //PINK
	}
}




