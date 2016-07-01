public class CellularData {
	
	private Object [][] table;
	public CellularData(int numRows, int numColumns, int startingYear) {
		table = new Object[numRows + 1][numColumns + 1]; // <- +1 for the heading line and the country name column

	    // write head line to array
	    table[0][0] = "Country";
	    for (int i = 1; i <= numColumns; i++) {
	      table[0][i] = startingYear++;
	    } 	
	}

	
	public void addCountry(String string, double[] country) {
		System.out.print(string + " ");
		for(int i = 0; i<= country.length - 1; i++) {
			
			System.out.print(country[i] + " ");
		}
		System.out.println(" ");
	}
	
	public double getNumSubscriptionsInCountryForPeriod(String countrylabel, int startYear,
			int endYear) {
		//table[0][0] = countrylabel;
		System.out.println("Country is " + countrylabel + " ,subscriptions from " + startYear + " to " + endYear);
		System.out.println("the output is:");
		int startingYearIndex = 0;
		for (int index = 0; index < table.length ; index++) {
			int value = (Integer) table[0][index];
			if (value == startYear) {
				return startingYearIndex;
			}			
		}
		int endingYearIndex = 0; 
		for(int index2 = 0; index2 < table.length; index2++) {
			int value = (Integer) table[0][index2];
			if(value == endYear){
				return endingYearIndex;			 
			}
		
		}
		
		double subscriptions = 0.0;
		for(int i = startingYearIndex + 1; i<= endingYearIndex - 1 ; i++) { 
			double valueOf = (Double) table[0][i]; 
			subscriptions = subscriptions + valueOf ;
			System.out.println(subscriptions);
		}
		
		return subscriptions;
		}

}
