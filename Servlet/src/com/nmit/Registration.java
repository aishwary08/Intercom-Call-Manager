package com.nmit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Registration implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void signup(Users u) throws IOException, ClassNotFoundException
	{
	 List<Users> l=new ArrayList<Users>();
	 File f1=new File("C:\\Users\\LENOVO\\workspace\\Servlet\\users.txt");
	 if(f1.exists())
     {
	  FileInputStream fis=new FileInputStream(f1);
	  ObjectInputStream is = new ObjectInputStream(fis);
	  l=(List<Users>) is.readObject();
	  is.close();
	 }
	 File f2=new File("C:\\Users\\LENOVO\\workspace\\Servlet\\users.txt");
	 FileOutputStream fos=new FileOutputStream(f2);
	 ObjectOutputStream os = new ObjectOutputStream(fos);
     l.add(u);
	 os.writeObject(l);
	 fos.close();
	}
}
