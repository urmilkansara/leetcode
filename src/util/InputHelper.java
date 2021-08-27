package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHelper
{
	public List<String> getData()
	{
		List<String> data = new ArrayList<>();
		try{
			File file = new File("input.txt");
			Scanner myReader = new Scanner(file);

			while(myReader.hasNext()){
				data.add(myReader.nextLine());
				System.out.println(data);
			}
			myReader.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return data;
	}

	public int getSingleInteger() {
		Scanner sc = new Scanner(System.in);
		 return Integer.parseInt(sc.next());
	}

	public String getSingleString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
}
