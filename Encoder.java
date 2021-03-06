import java.util.*;
import java.io.*;
public class Encoder{
	private static String fileName;
	
	public void Encode (String inputString) throws IOException {

		HashMap<String, Integer> table = new HashMap<String, Integer>();
		int max=500; //maximum hashmap size
		int tableSize=255;
		for (int i = 0; i < 255 ; i++){
			table.put("" + (char) i, i); //pre-fills the hashmap with ascii characters
		}

		String temp = ""; //will be used to cycle through inputString
		ArrayList<Integer> encodedValues = new ArrayList<Integer>(); //key of encoded characters

		for (char start : inputString.toCharArray()) { //converts the input into a array of chars and cycles through it
			String symbol = temp + start;
			if (table.containsKey(symbol)){ //checks to see if the symbol is already in the table
				temp = symbol;
			}else{
				encodedValues.add(table.get(temp)); //if the symbol isn't in the table it is added
				if (tableSize<max){
					table.put(symbol,tableSize++);
				}
				temp = "" + start;
			}
		}

		if (!temp.equals("")&&!table.containsKey(temp)) //making sure the last symbol doesn't get skipped
			encodedValues.add(table.get(temp));
		
		
	}
}