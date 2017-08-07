package com.nmit;


import java.io.*;
import java.util.Hashtable;

public class CreatePointerFile {
	public void PutNewPointer(int intnum) throws IOException
	{
	 RandomAccessFile raf;
	 long pos = 0;
	 try {
	      raf = new RandomAccessFile("C:\\Users\\LENOVO\\workspace\\Servlet\\log.txt", "r");
	 	  raf.seek(raf.length());
	 	  pos=raf.getFilePointer();
	 	  raf.close();
	 	 } catch (FileNotFoundException e) {
	 	       e.printStackTrace();
	     }	
	 Hashtable usertable = new Hashtable();
	 usertable.put(intnum,pos);	
	 File f2=new File("C:\\Users\\LENOVO\\workspace\\Servlet\\User's_Pointer_File\\P"+intnum+".txt");
	 try {
		  FileOutputStream fos=new FileOutputStream(f2);
		  ObjectOutputStream os = new ObjectOutputStream(fos);
		  os.writeObject(usertable);
	      fos.close();
	     }catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	 }
}
