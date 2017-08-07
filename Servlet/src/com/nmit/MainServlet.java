package com.nmit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("login");
		int yz=0;
		if(s1 != null)
		{
		 String user = request.getParameter("u");
		 String pass = request.getParameter("p");
		 Users u1=new Users();
		 Users u2= new Users();
		 u1.setIntcom(user);
		 u1.setPassword(pass);
		 Authenticate ob = new Authenticate();
		try {
			u2 = ob.check(u1); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	     CreateFile f = new CreateFile();
		 CreatePointerFile lf=new CreatePointerFile();
		 Services s=new Services();
		
	     if(u2 != null)
		 {
	    	yz=Integer.parseInt(u2.Intcom);
	    	long ppos=s.ReadPointer(yz);
			f.createuserfile(u2.Intcom,ppos);
			lf.PutNewPointer(yz);
			request.setAttribute("user", "Hello "+u2.Name);
			request.setAttribute("intnum",yz);
			
		 }
		 else
		 {
			request.setAttribute("user", "Login Unsuccesful");
		    request.setAttribute("intnum",yz);
	     }
	     request.getRequestDispatcher("welcome_try.jsp").forward(request,response);	
	    }
		else
		{
			String user = request.getParameter("u");
			String pass = request.getParameter("p");
			String intercom = request.getParameter("icn");
			user = user.substring(0, 1).toUpperCase() + user.substring(1);
			Users u1= new Users();
			u1.setName(user);
			u1.setPassword(pass);
			u1.setIntcom(intercom);
			Registration r=new Registration();
			try {
				r.signup(u1);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.setAttribute("user", "Congrats! Sign Up Successfull!");
			request.setAttribute("intnum",yz);
			request.getRequestDispatcher("welcome.jsp").forward(request,response);	
		}
			
	}
}
