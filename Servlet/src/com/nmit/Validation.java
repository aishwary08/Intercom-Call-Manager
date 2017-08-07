package com.nmit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* Function to validate intercom number while new Sign Up */
			
		String icn=request.getParameter("q");
		
		List<Users> l=new ArrayList<Users>();
		File f1 = new File("C:\\Users\\LENOVO\\workspace\\Servlet\\users.txt");
		if(f1.exists() && !f1.isDirectory())
		{
			FileInputStream fis=new FileInputStream(f1);
			ObjectInputStream is = new ObjectInputStream(fis);
		 try {
		     l=(List<Users>)is.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			 PrintWriter out = response.getWriter();
			 for(int i=0;i<l.size();i++)
			 {
				 Users u1=new Users();
				 u1=l.get(i);				 
				 if(u1.getIntcom().equals(icn))
				 {
					 out.print("Number already exists!");					 
					 break;
				 } 
			 }
			 fis.close();
		}
	}

}
