//The distance between Earth and Moon 3.844 × 10^8 meters
//So we will have 1 pixel = 3.844*10^6
//Earth will be 10 pixels in radius, so the moon is (.27)(10), or 2.7 pixels in radius

package solarSystemSim;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class EarthMoon {
	
	public static double pixelsPerMeter = (1/3.844E6);  //pixels per meter constant
	public static double timestep = 3333.33;  //timestep value
	public static double G = 6.67384E-11;  //Constant G
	
	//center x and center y coordinates
	public static double cx = 200;
	public static double cy = 200;
	
	public static void main(String[] args) {
		
		//set the scale and background color to black
		StdDraw.setXscale(0, 400);
		StdDraw.setYscale(0, 400);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.enableDoubleBuffering();
		
		//Mass, Distance, Initial x, Initial y, Initial vx, Initial vy, Radius (in pixels), r, g, b
		Body Earth = new Body(5.9736E24,0,0,0,0,0,10,0,0,255);
		Body Moon = new Body(7.3477E22,(3.844E8),(3.844E8),0,0,(1022),2.7,255,255,255);
		
		//Create an array list of all bodies
		ArrayList<Body> bodyList = new ArrayList<Body>();
		
		//add our bodies to the arraylist
		bodyList.add(Earth);
		bodyList.add(Moon);
		
		//create a new solar system
		System EarthMoon = new System (bodyList);
		
		//constant loop redrawing our system while updating the locations
		while (true){
			StdDraw.clear(StdDraw.BLACK);
			EarthMoon.draw(cx, cy, pixelsPerMeter);
			EarthMoon.update(timestep);
			StdDraw.show();
		}
	}
}
