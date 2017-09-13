package solarSystemSim;

import java.util.ArrayList;

public class System {
	
	ArrayList<Body> bodies = new ArrayList<Body>();
	
	public System(ArrayList<Body> bodyList){
		//creates the arraylist "bodies" containing all of our bodies
		//for use in the System class
		bodies = bodyList;
	}
	
	//method to update our x and y values for each body
	public void update(double timestep){

		
		for (int i = 1; i < bodies.size(); i++){
			//compute acceleration of body at index "i"
			double a = computeAcceleration(i);
			//use that acceleration to compute acceleration in the x direction
			double ax = computeAx(a, i);
			//compute acceleration in the y direction
			double ay = computeAy(a, i);
			//apply that acceleration to update that bodies' velocity
			bodies.get(i).updateVelocity(ax, ay, timestep);
			//update the bodies' position
			bodies.get(i).updatePosition(timestep);
		}
	}
	
	//method to draw each of our bodies
	public void draw(double cx, double cy, double pixelsPerMeter){
		for (int i = 0; i < bodies.size(); i++){
			bodies.get(i).draw(cx, cy, pixelsPerMeter); 
		}
	}
	
	//method to compute the acceleration of body i
	 public double computeAcceleration(int i) {
		 double a;
		 //compute acceleration using a=GM(of sun)/(distance^2)
		 a = (SolarSystem.G * bodies.get(0).mass)/((bodies.get(i).d)*(bodies.get(i).d));
		 return a;
	  }
	   
	//method to compute the acceleration of body i in the x direction
	  public double computeAx(double a, int i) {
		//compute x acceleration using ax=a(Xsun-Xbody)/(distance of body)
		double ax = (a * ((bodies.get(0).x)-(bodies.get(i).x)))/(bodies.get(i).d);
		return ax;
	  }
	   
	//method to compute the acceleration of body i in the y direction
	  public double computeAy(double a, int i) {
		//compute x acceleration using ax=a(Ysun-Ybody)/(distance of body)
			 double ay = (a * ((bodies.get(0).y)-(bodies.get(i).y)))/((bodies.get(i).d));
			  return ay;
		  }
	
	  
	  }



