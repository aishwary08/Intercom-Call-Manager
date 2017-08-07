package com.nmit;


import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Log {
	public static void main(String args[])
	{  
	   int temp1=0;
	   for(;;)
	   { 
		DateFormat Mf=new SimpleDateFormat("MM");
		Date M=new Date();
		String M1=(String)Mf.format(M);
		DateFormat df=new SimpleDateFormat("dd");
		Date d=new Date();
	    String d1=(String)df.format(d);
		DateFormat hf=new SimpleDateFormat("HH");
		Date h=new Date();
		String h1=(String)hf.format(h);
		DateFormat mf=new SimpleDateFormat("mm");
		Date m=new Date();
		String m1=(String)mf.format(m);
		String Fst=" "+M1+d1+h1+m1;
		
		char buf[]={'0','1','2','3','4','5','6','7','8','9'};
		char c;
		StringBuilder sb= new StringBuilder();
		Random random=new Random();
		for(int i=0;i<5;i++)
		{
			if(i<3)
			{
			  c=buf[random.nextInt(2)];
			  sb.append(c);
			}
			else
			{
				c=buf[random.nextInt(10)];
				sb.append(c);
			}		
		}
		String output=sb.toString();
	
	    String a[]={"7259040895","9964603589","9980297723","67178873","22932311","42067773","2810","2556","2790","2556"};
	    String b[]={"2580","2973","2913","2716","9902247460","9448287706","7760349764","23566105","99022478","22192317"};
	    String c1=" ",c2=" ";
		Random ran=new Random();
	    c1=a[ran.nextInt(10)];
		c2=b[ran.nextInt(10)];
		while((c2.length()==10 && c1.length()==10) || ((c2.length()==8 && c1.length()==8)) || ((c2.length()==8 && c1.length()==10)) || ((c2.length()==10 && c1.length()==8)))
		{
		 c1=a[ran.nextInt(10)];
		 c2=b[ran.nextInt(10)];
		}
	    char[] c3={' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	    char[] c4={' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	    for(int j=0,k=10-c1.length();k<10;k++,j++)
	    {
	    	c3[k]=c1.charAt(j);
	    }
	    for(int j=0;j<c2.length();j++)
	    {
	    	c4[j]=c2.charAt(j);
	    }
	    String c5= new String(c3);
	    String c6= new String(c4);
		String line=Fst+" "+output+" "+" "+c5+" "+c6;
		
		PrintWriter bw;
		File fin=new File("log.txt");
		try {
			bw = new PrintWriter(new FileWriter("log.txt",true));
			 if(temp1==0 && fin.length()==0)
		     {	 
				 System.out.println(line);
				 bw.print(line);
		     	 temp1=1;
		     }			 
		     else 	
		     {
		    	 System.out.println(line); 
		    	 bw.printf("%n"+line);
		     }
			 bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		      
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }
	}
}

