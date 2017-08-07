package com.nmit;


import java.io.*;
import java.util.Hashtable;

public class Services {
	public long ReadPointer(int intcn)
	{ 
		 long num = 0;
		 File f1 = null;
		 try {
			  try
			    {
				 f1=new File("C:\\Users\\LENOVO\\workspace\\Servlet\\User's_Pointer_File\\P"+intcn+".txt");
				 if(!f1.exists())
				 throw new PointerException();
				}
				catch(PointerException e)
				{
				 System.out.println(e.toString());
			     return num;
				}
				FileInputStream fis=new FileInputStream(f1);
			    ObjectInputStream oi=new ObjectInputStream(fis);
			    Hashtable usertable1= (Hashtable) oi.readObject();
			    num=(long) usertable1.get(intcn);
				oi.close();				
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		 return num;
	}
}