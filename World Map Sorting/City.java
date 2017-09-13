package lab3WorldMap;

public class City {

//instance variables for each city
public String countryCode;
public String cityName;
public String region;
public int population;
public double latitude;
public double longitude;


public City (String code, String name, String reg, int pop, double lat, double lon){
	countryCode = code;
	cityName = name;
	region = reg;
	population = pop;
	latitude = lat;
	longitude = lon;
}
//method to convert the data of the object (specifically
//the name of the city, population, and coordinates,
//into a string and return the string
public String toString(){
	String Data = (cityName + "," + population + "," + latitude + "," + longitude);
	return Data;
}

//Methods to compare names, populations, and latitudes of cities
public int compareToName(City c){
	int result = this.cityName.toLowerCase().compareTo(c.cityName.toLowerCase());
	return result;
}
public int compareToPopulation(City c){
	int result = 0;
	if (this.population>c.population){
		result = 1;
	}
	else if (this.population<c.population){
		return -1;
	}
	return result;
}
public int compareToLatitude(City c){
	int result = 0;
	if (this.latitude>c.latitude){
		result = 1;
	}
	else if (this.latitude<c.latitude){
		return -1;
	}
	return result;
}
}
