package lab3WorldMap;

//Class to Quicksort our array of Cities
public class QuickSort {
	
	//Method to compare the population/latitude/name of our cities
	//After comparing it will either call to swap the two or continue
	public static int partition(City[] cityList, int p, int r, String category){
		int x=0;
		if (category=="population"){
		 x = cityList[r].population;
		}
		if (category=="latitude"){
		 x = (int)cityList[r].latitude;
			}
		
		int i = p - 1;
		
		if (category=="population"){
		for (int j = p; j < r; j ++)
		{
			
			if (cityList[j].population >= x)
			{ 
				i ++;
				swap(cityList, i, j);
			}
			}
		}
		
		if (category=="latitude"){
			for (int j = p; j < r; j ++)
			{
				
				if (cityList[j].latitude <= x)
				{ 
					i ++;
					swap(cityList, i, j);
				}
				}
			}
		
		if (category=="name"){
			for (int j = p; j < r; j ++)
			{
				
				if (cityList[j].compareToName(cityList[r]) <= 0)
				{ 
					i ++;
					swap(cityList, i, j);
				}
				}
			}
		
	    swap(cityList, i+1, r);
		return i + 1;
	}
	
	//Method to begin our sorting process, calls itself recursively
	public static void quickSort(City[] cityList, int p, int r, String category) {
		if (p < r)
		{
			int q = partition(cityList, p, r,category);
			quickSort(cityList, p, q - 1,category);
			quickSort(cityList, q + 1, r,category);
		}
	}
	
	//Method to swap the two cities that we compared
	public static void swap(City[] cityList, int i, int j)
	{
		City temp = cityList[i];
		cityList[i] = cityList[j];
		cityList[j] = temp;
	}
		
}

