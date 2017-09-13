package lab3WorldMap;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdDraw;

public class CityList {

//instance variables is an array of City and the number of cities
public int numberOfCities;
public City[] CityList;

public CityList(int cities){
	numberOfCities = cities;
	CityList = new City[numberOfCities];
}

//Method to import our file,
//we read each line of the text file and split the data,
//then create a city object from that data and add it
//to our CityList
public void importFile(String FileName){
	
	//open the text file world_cities.txt
	In input = new In("file:"+FileName);
	
	//loop until we've processed every line
			int i = 0;
			while (i<numberOfCities) {
				//create a string "line" from the current line
				String line = input.readLine();
				//split the string at every comma and insert into an array
				String[] split = line.split(",");
				//make a variable from each category from the array
				String countryCode = split [0];
				String cityName = split [1];
				String region = split [2];
				int population = Integer.parseInt(split [3]);
				double latitude = Double.parseDouble(split[4]);
				double longitude = Double.parseDouble(split[5]);
				//create the object using the variables we created
				CityList[i] = new City(countryCode,cityName,region,population,latitude,longitude);
				i++;
			}
				//close the file
				input.close();
			
}
//Method to export our file at any time in the current order
public void ExportFile(String FileName){
	//Now we will create an output file with our data
			Out ExportFile = new Out(FileName);
			//while loop that will write a new line for each of our objects
			int i=0;
			while (i<numberOfCities){
				ExportFile.println(CityList[i].toString());
				i++;
			}
			//close the file
			ExportFile.close();
}
//draw cities on the world map
public void WorldMap(int topCities, int pauseTime){
	//set the window dimensions, the scale, and import the picture
	int WINDOW_WIDTH = 720;
	int WINDOW_HEIGHT = 360;
	StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	StdDraw.setXscale(0, WINDOW_WIDTH);
	StdDraw.setYscale(0, WINDOW_HEIGHT);
	StdDraw.picture(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, "file:world.png");
	//change pen color to red
	StdDraw.setPenColor(StdDraw.RED);
	//draw the first 50 City objects onto the map (at this point they are sorted by population)
	for (int i=0; i<topCities; i++){
		StdDraw.filledRectangle( 2*(180 + CityList[i].longitude),  2*(90 + CityList[i].latitude), 3, 3);
		StdDraw.pause(pauseTime);
	}
}
}
