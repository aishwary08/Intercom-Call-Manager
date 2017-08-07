<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="java.text.DateFormatSymbols" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
</head>
<body>

<%! public String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}
%>
<% Object user=request.getAttribute("user"); 
 out.print("<h1 align='center'>"+user+"</h1>");
 int status=(int)request.getAttribute("intnum");
 if(status!=0)
 {
	 String line;
	 FileInputStream file = new FileInputStream("C:\\Users\\LENOVO\\workspace\\Servlet\\User's_File\\"+status+".txt");
	 BufferedReader br = new BufferedReader(new InputStreamReader((file)));
	 try
		{
		 
		 out.print(" <style> #logs { font-family: 'Trebuchet MS', Arial, Helvetica, sans-serif; border-collapse: collapse; width: 50%;} ");
		 out.print(" #logs td, #logs th { border: 1px solid #ddd; padding: 8px; } ");
		 out.print(" #logs tr:nth-child(odd){ background-color: #f2f2f2 } ");
	 	 out.print(" #logs tr:hover {background-color: #ddd;} ");
		 out.print(" #logs th { padding-top: 12px; padding-bottom: 12px; background-color: #4CAF50; color: white; }");
		 out.print("</style>");	 
		 out.print("<div align='center'>");
		 out.print("<table border='1' id='logs'>");
		 out.print("<tr>");
		 out.print("<th align='center' width='3%'>");
         out.println(" ");
         out.print("</th>");
		 out.print("<th align='center' width='12%'>");
         out.println("Date & Time");
         out.print("</th>");
         out.print("<th align='center' width='12%'>");
         out.println("Duration");
         out.print("</th>");
         out.print("<th align='center' width='12%'>");
         out.println("From");
         out.print("</th>");
         out.print("<th align='center' width='12%'>");
         out.println("To");
         out.print("</th>");
         out.print("</tr>");
         List<String> tmp = new ArrayList<String>();
         while((line = br.readLine())!=null)
        	 tmp.add(line);
         for(int i=tmp.size()-1;i>=0;i--)
		 {
	       String[] subData=tmp.get(i).split(" ");
	       String x="black";
	       String y=" ";
	       if(tmp.get(i).substring(17,28).contains(Integer.toString(status)))
	       {
	    	   x="green";
	    	   y="Images/Outgoing.png";
	       }
	       else if(tmp.get(i).substring(27,38).contains(Integer.toString(status)) && tmp.get(i).substring(10,15).contains("00000"))
	       {
	    	   x="red";
	    	   y="Images/Missed.jpg";
	       }
	       else if(tmp.get(i).substring(27,38).contains(Integer.toString(status)))
	       {
	    	   x="blue";
	    	   y="Images/Incoming.png" ;
	       }
		   subData[1]=getMonth(Integer.parseInt(subData[1].substring(0,2)))+" "+subData[1].substring(2,4)+" "+subData[1].substring(4,6)+":"+subData[1].substring(6);
	       out.print("<tr>");
	       out.print("<td>");
	       out.print("<img src="+y+" style= 'width:22px;height:20px;' alt='logs' >");
	       out.print("</td>");
	       out.print("<td>");
	       out.print("<font color="+x+">");
	       out.println(subData[1]);
	       out.print("</font>");
	       out.print("</td>");
	       out.print("<td>");
	       out.print("<font color="+x+">");
	       out.println(subData[2]);
	       out.print("</font>");
	       out.print("</td>");
	       out.print("<td>");
	       out.print("<font color="+x+">");
	       out.println(tmp.get(i).substring(17,28));
	       out.print("</td>");
	       out.print("</font>");
	       out.print("<td>");
	       out.print("<font color="+x+">");
	       out.println(tmp.get(i).substring(27,38));
	       out.print("</td>");
	       out.print("</font>");
	       out.print("</tr>");
	      }
	     out.print("</table>");
	     out.print("</div>");
		}finally{
		br.close();
		}
 }
 
%>
</body>
</html>