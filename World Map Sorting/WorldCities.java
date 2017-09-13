package lab3WorldMap;

public class WorldCities {
	
	public static void main(String[] args) {
		//create our CityList object and import the text file
		CityList worldCities = new CityList(47913);
		worldCities.importFile("world_cities.txt");
		//Sort alphabetically and export the file
		QuickSort.quickSort(worldCities.CityList, 0, worldCities.CityList.length-1, "name");
		worldCities.ExportFile("cities_alpha.txt");
		//Sort by latitude and export the file
		QuickSort.quickSort(worldCities.CityList, 0, worldCities.CityList.length-1, "latitude");
		worldCities.ExportFile("cities_latitude.txt");
		//Sort by population and export the file
		QuickSort.quickSort(worldCities.CityList, 0, worldCities.CityList.length-1, "population");
		worldCities.ExportFile("cities_population.txt");
		//Display the 50 most populated cities on the map
		worldCities.WorldMap(50, 300);
	}

}
