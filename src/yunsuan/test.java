package yunsuan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class test 
{
	    public static void main(String[] args) 
	    {
	    	int i=0;
           
            Random r= new Random();
            String[] operate=new String[]{"+","-","*","/"};
            String[] operate1=new String[]{"+","-","*"};
	        ScriptEngineManager manager = new ScriptEngineManager();
	        ScriptEngine se = manager.getEngineByName("js");
	        Scanner scan = new Scanner(System.in);
	        System.out.println("请输入题目的数量：");
	        int num = scan.nextInt();
	        ArrayList<String> Expression=new ArrayList<String>();
	        ArrayList<String> Expressions=new ArrayList<String>();
	        for(i=0;i<num;i++)
	        {
	        	int a=(int)(Math.random()*100);
	            int b=(int)(Math.random()*100);
	            int c=(int)(Math.random()*100);
	            int d=(int)(Math.random()*100);
	            String cz=operate[r.nextInt(4)];
	            String cz1=operate1[r.nextInt(3)];
	            String cz2=operate1[r.nextInt(3)];
		        String as=new String();
		        int s= (int)(Math.random()*3);
		        if(cz.equals("/"))
		        	b=div(a,b);
		        try
		        { 
		        	if(s==0)
		        	{
		        		System.out.print(a+cz+b+"=");
		        		se.eval("var a="+a+";var b="+b+";print((a"+cz+"b));");
				        as=String.valueOf(a)+String.valueOf(cz)+String.valueOf(b);
				       	Expression.add(as);
				 	}
		        	if(s==1)
		        	{
		        		System.out.print(a+cz+b+cz1+c+"="); 
				       	se.eval("var a="+a+";var b="+b+";var c="+c+";print((a"+cz+"b"+cz1+"c));");
				       	as=String.valueOf(a)+String.valueOf(cz)+String.valueOf(b)+String.valueOf(cz1)+String.valueOf(c);
				       	Expression.add(as);
		        	}
		        	if(s==2)
		        	{
		        		System.out.print(a+cz+b+cz1+c+cz2+d+"="); 
				       	se.eval("var a="+a+";var b="+b+";var c="+c+";var d="+d+";print((a"+cz+"b"+cz1+"c"+cz2+"d));");
				       	as=String.valueOf(a)+String.valueOf(cz)+String.valueOf(b)+String.valueOf(cz1)+String.valueOf(c)+String.valueOf(cz2)+String.valueOf(d);
				       	Expression.add(as);
		        	}
		        	 
		        		
		        }catch(ScriptException e)
		        {
		        	e.printStackTrace();
		        }
		        
		        
		       
	        }
	        
	      //将表达式存储到Expression，便于输出到TXT文档中
	        for(String w:Expression)
	        {
	        	try {
    				w=w+"="+se.eval(w);
    				Expressions.add(w);
    			} catch (ScriptException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
	        }
	        
	        
	       
	        
	    try {
	       		File f = new File("result.txt"); 
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(" 201571030126");
				pw.println();
			    for(String con:Expressions)
				 {
		                pw.println(con);  
		                
		         }
				
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	     
	        
	    }
	    
	    
	    private static int div(int x,int y)
		{
			//Random random=new Random();
			if(x%y!=0)
			{
				y=(int)(Math.random()*100)+1;
				return div(x,y);
			}
			else{
				return y; 
			}
		}
	    
	    
	
}
