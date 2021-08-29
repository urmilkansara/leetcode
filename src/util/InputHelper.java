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

			}
			myReader.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println(data);
		return data;
	}

	public int getSingleInteger() {
		Scanner sc = new Scanner(System.in);
		 return Integer.parseInt(sc.next());
	}

	public String getSingleString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public int[] getListofIntegers(){
		String[] s = this.getSingleString().split(" ");

		int[] nums = new int[s.length];

		for(int i = 0; i< s.length; i++){
			nums[i] = Integer.parseInt(s[i]);
		}
		return nums;
	}

}
