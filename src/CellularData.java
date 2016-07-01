public class CellularData {
	
	private Object [][] table;
	private final int startingYear;
	//private double sum = 0;
    //private int countryNum = 0;
	
    public CellularData(int rows, int columns, int year) {
        table = new Object[rows + 1][columns + 1];
        table[0][0] = "Country";
        this.startingYear = year;
        for (int i = 1; i <= columns; i++) {
            table[0][i] = year++;
        }
     //   countryNum = 1;
    }
	
    public void addCountry(String string, double[] country) {
		System.out.print(string + " ");
		for(int i = 0; i<= country.length - 1; i++) {
			
			System.out.print(country[i] + " ");
		}
		System.out.println(" ");
	}
	
	public double getNumSubscriptionsInCountryForPeriod(String country, int sYear, int eYear) {
		System.out.println("Country is " + "\"" + country +"\"," + " subscriptions from " + sYear + " to " + eYear);
		System.out.println("the output is:");
		double sum = 0;
		 
	    for (int i = 1; i < table.length; i++) {
	    	
	        if (country.equalsIgnoreCase((String) table[i][0])) {
	            int start = 1 + sYear - startingYear;
	            int end = start + (eYear - sYear);
	            
	           
	            if (start >= 0 && end <= table[i].length) {

	                for (int k = start; k < end; k++) {
	                    System.out.println(">> " + country + " adding " + table[i][k]);
	                    sum += (Double) table[i][k];
	                    
	                }
	                
	            }
	            else return -1;
	           
	        }
	        
	    }
	    return sum;
	}


}
