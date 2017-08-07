package com.nmit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Authenticate {

	public Users check(Users u) throws IOException, ClassNotFoundException
	{
		Users u2 = null;
		List<Users> l=new ArrayList<Users>();
		File f1=new File("C:\\Users\\LENOVO\\workspace\\Servlet\\users.txt");
		if(f1.exists())
		{
			 FileInputStream fis=new FileInputStream(f1);
			 ObjectInputStream is = new ObjectInputStream(fis);
			 l=(List<Users>)is.readObject();
			 for(int i=0;i<l.size();i++)
			 {
				 Users u1=new Users();
				 u1=l.get(i);
				 if(u1.getIntcom().equals(u.getIntcom()) && u1.getPassword().equals(u.getPassword()))
				  return u1;
				 fis.close();
			 }
		}
		 return u2;
	}
}