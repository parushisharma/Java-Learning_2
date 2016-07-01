public class CellularData {

	private Object [][]table; // private to the client
	private int startingYear;
	
	// This method initializes the datatable/ header that contains the year. 
	public CellularData(int numRows, int numColumns, int year) {
		// create object with header. 
		table = new Object[numRows+1][numColumns+1];
		// Create header for country 
		table[0][0] = "Country";
		this.startingYear = year;
		for(int i=1;i<=numColumns;i++) {
			table[0][i] = year++;   //increments the year in the 0th row.
		}
	}
	
	// this method adds the single array of data given by the user in the 
	// test file into the double array created in the method above. 
	public void addCountry(String country, double []num) {
		for(int i = 0; i<table.length;i++) { // read through the table    
			if(table[i][0] == null) {    // create check to see if the first row is empty
				addCountry(country, num, i);  //inserts the data by using helper method 
				break;
			}
		}
	}
	
	// This is a helper method that is private to the client. 
	// It inserts the data into the table
	private void addCountry(String country, double []num, int row) {
		table[row][0] = country; // the country name given should be in the 0th row. 
		for(int j = 1;j < table[row].length;j++) { // read through the row 
			table[row][j] = num[j-1]; 
		}
	}
	
	// This method 
	public double getNumSubscriptionsInCountryForPeriod(String country, int sYear, int eYear) {
		double sum = 0;

		for (int i = 1; i < table.length; i++) {

            if (country.equalsIgnoreCase((String) table[i][0])) { //matches with the parameters passed ignoring CAPS
                int start = 1 + sYear - startingYear;   //first index position of the year
                int end = start + (eYear - sYear);  //end position of the year

                if (start >= 0 && end < table[i].length) {   //checks to see if index position is out of bounds

                    for (int k = start; k <= end; k++) {
                        sum += (Double) table[i][k];   //sum of the stats
                    }
                }
                else {
                    //returns Error messgae and -1
                    System.out.println("ERROR : requested year "+sYear+" from "+ country+" is less than starting year "+this.startingYear);
                    sum = -1;
                    }
            }
		}
		return sum;
    }

	public String toString() { //prints the array.
		for(Object []a: table) {
			for(Object k:a) {
				System.out.print(k + "\t");
			}
			System.out.println();
		}
		return " ";
    }

 }