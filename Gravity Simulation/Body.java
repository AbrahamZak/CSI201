package solarSystemSim;

import edu.princeton.cs.introcs.StdDraw;

public class Body {
	public double mass;
	public double d;
	public double x;
	public double y;
	public double vx;
	public double vy;
	public double radius;
	public int r;
	public int g;
	public int b;
	
	public Body(double gMass, double distance, double Initialx, double Initialy, double Initialvx, double Initialvy, double initialRadius, int color1, int color2, int color3){
		mass = gMass;
		d = distance;
		x = Initialx;
		y = Initialy;
		vx = Initialvx;
		vy = Initialvy;
		r = color1;
		g = color2;
		b= color3;
		radius = initialRadius;
	}
	
	//method to draw a body
	public void draw(double cx, double cy, double pixelsPerMeter){
		StdDraw.setPenColor(r, g, b); //set color to the color of the body
		//draw the body at the x and y calculated
		StdDraw.filledCircle(cx + (x * pixelsPerMeter), cy + (y * pixelsPerMeter), radius);
	}
	
	//method to update the x and y with our velocities
	public void updatePosition(double timestep){
		x = x + vx * timestep;
	    y = y + vy * timestep;
	}
	
	//method to update our velocities by adding accelerations to them
	public void updateVelocity(double ax, double ay, double timestep){
		vx = vx + ax * timestep;
	    vy = vy + ay * timestep;
	}
	
}
