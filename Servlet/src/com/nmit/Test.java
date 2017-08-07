package com.nmit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Test {
	public static void main(String args[]) throws IOException, InterruptedException
	{
		 String line = null;
		 FileInputStream file = new FileInputStream("COM5port.txt");
		 BufferedReader br = new BufferedReader(new InputStreamReader((file)));
		 for(int j=0;j<34;j++){
			 line = br.readLine();
		 line = line.trim();
		 System.out.println(line);
		 String cols[] = line.split("\\s+(?![^0-9])");
		 java.util.List<String> col1 = new LinkedList<String>(Arrays.asList(cols));
		 
		 //System.out.println(cols.length);
		 
		 for(int i=0;i<col1.size();i++)
		 {
			 String word = col1.get(i);
			 //System.out.println(word.split("\\s+")[0]);

			 if(word.equals("0"))
			 {
				 String obj = col1.remove(i);
				 //System.out.print("hello"+obj);
			 }
			 if(i>=0 && i<=3)
				 System.out.println(col1.get(i).split("\\s+")[0]);
		 }
		 System.out.println("Array list: "+col1.size());
		 Thread.sleep(1000);
		 }
		 br.close();
		 file.close();
	}
}
