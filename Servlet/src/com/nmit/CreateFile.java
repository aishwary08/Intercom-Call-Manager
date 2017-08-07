package com.nmit;

import java.io.*;

public class CreateFile{
   public void createuserfile(String intnum,long num1) throws IOException
   { 
	File f1= new File("C:\\Users\\LENOVO\\workspace\\Servlet\\log.txt");
	FileInputStream file =new FileInputStream(f1);
	if(f1.exists())
	{
	 BufferedReader br = new BufferedReader(new InputStreamReader((file)));
	 String line;
	 int temp=0;
	 File fi = new File("C:\\Users\\LENOVO\\workspace\\Servlet\\User's_File\\"+intnum+".txt");
	 PrintWriter bw = new PrintWriter(new FileWriter("C:\\Users\\LENOVO\\workspace\\Servlet\\User's_File\\"+intnum+".txt",true));
	 try
	 {
	  if(num1==0)
	   file.skip(num1);
	  else
	   file.skip(num1+2);	
	  while ((line = br.readLine()) != null) 
	  {
	   if(temp==0 && line.substring(17,38).contains(intnum) )
	   {	 
	    if(fi.length()==0)
	    {
	 	 bw.print(line);
         temp=1;
        }
        else
	    {
		 bw.printf("%n"+line);
		 temp=1;
	    }   	 
	   }
	   else if(temp==1 && line.substring(17,38).contains(intnum))	  
	   bw.printf("%n"+line);     		   
	  }
	 }finally{
	  br.close();
	  bw.close();
     }
	}
  }
}
