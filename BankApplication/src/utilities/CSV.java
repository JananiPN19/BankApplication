package utilities;

import java.io.*;
import java.util.*;

public class CSV {
	//A function to read the CSV file and return a list.
	public static List<String[]> read(String file)  {
		List<String[]> data = new LinkedList<String[]>();
		String dataRow;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((dataRow = br.readLine()) != null) {
				String[] dataRecords = dataRow.split(",");
				data.add(dataRecords);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Couldn't find file!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Couldn't read file!");
			e.printStackTrace();
		}
		return data;
	}

}
