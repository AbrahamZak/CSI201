package solarSystemSim;

	import java.util.ArrayList;

	import edu.princeton.cs.introcs.StdDraw;

public class SolarSystem {
	
		public static double pixelsPerMeter = (1/11E8);  //pixels per meter constant
		public static double timestep = 3333.33;  //timestep value
		public static double G = 6.67384E-11;  //constant G
		
		//center x and y coordinates
		public static double cx = 250;  
		public static double cy = 250; 
		
		public static double AU = 1.49E11;  //Astronomical unit
		public static double EarthMass = 5.972E24;  //1 Earth Mass
		
		public static void main(String[] args) {
			
			//set the scale and background color to black
			StdDraw.setXscale(0, 500);  
			StdDraw.setYscale(0, 500);
			StdDraw.clear(StdDraw.BLACK);
			StdDraw.enableDoubleBuffering();
			
			//Mass, distance, Initial x, Initial y, Initial vx, Initial vy, Radius (in pixels), r, g, b
			Body Sun = new Body(1.989E30,0,0,0,0,0,30,255,255,0);
			Body Mercury = new Body(0.055*EarthMass,(0.3871 * AU),(0.3871 * AU),0,0,47870,2.9,211,211,211);
			Body Venus = new Body(0.81*EarthMass,(0.7233 * AU),(0.7233 * AU),0,0,(35000),6.9,165,42,42);
			Body Earth = new Body(EarthMass,(AU),(AU),0,0,29785,7,0,0,255);
			Body Mars = new Body(0.108*EarthMass,(1.524 * AU),(1.524 * AU),0,0,(24140),3.5,255,0,0);
			
			//Create an array list of all bodies
			ArrayList<Body> bodyList = new ArrayList<Body>();
			
			//add our bodies to the arraylist
			bodyList.add(Sun);
			bodyList.add(Mercury);
			bodyList.add(Venus);
			bodyList.add(Earth);
			bodyList.add(Mars);
			
			//create a new solar system
			System SolarSystem = new System (bodyList);
			
			//constant loop redrawing our system while updating the locations
			while (true){
				StdDraw.clear(StdDraw.BLACK);
				SolarSystem.draw(cx, cy, pixelsPerMeter);
				SolarSystem.update(timestep);
				StdDraw.show();
			}
		}
	}


