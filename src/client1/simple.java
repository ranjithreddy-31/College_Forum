package client1;
import java.io.*;
import java.rmi.server.UnicastRemoteObject;
public class simple extends UnicastRemoteObject implements ocf  
{ static int x=0;
	String date;
	String []a;
	public simple() throws Exception
	{
		a=new String[100000000];
	}
@Override
	public void getdate(String dt)
	{
		date=dt;
	}
	public Boolean setPassword(int rollno,String pw)
	{
		try
		{
			
			File spf=new File("password.txt");
			FileWriter pfw=new FileWriter(spf,true);
			if(a[rollno]==null)
			{
			a[rollno]=pw;
			pfw.write(a[rollno]);
			pfw.close();
			return true;
			}
			else
			{
				pfw.close();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in creating password file");
			return false;
		}
	}
	public Boolean matchPassword(int rollno,String pw)
	{
		try
		{
			x=rollno;
			//sd=date;
			File mpf=new File("password.txt");
			FileReader mpr=new FileReader(mpf);
			if(a[rollno].equals(pw))
			{
			mpr.close();
			return true;
			}
			else
			{
			mpr.close();
			return false;
			}
			
		}
		catch(Exception e)
		{
			//System.out.println("exception in matching password");
			return false;
		}
	}
	public Boolean resetPassword(int rollno,String pw,String npw)
	{
		try
		{
			File prf=new File("password.txt");
			FileReader pr=new FileReader(prf);
			if(a[rollno].equals(pw))
			{	pr.close();
				try
				{
				File wf=new File("password.txt");
				FileWriter pwr=new FileWriter(wf,true);
				a[rollno]=npw;
				pwr.write(a[rollno]);
				pwr.close();
				}
				catch(Exception e)
				{
					System.out.println("Exception");
				}
				return true;
			}
			else
			{
				pr.close();
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
			
		}
	}
						
	public void getQuestion(String stra)
	{     	
		String str=stra;
		try
			{
				File qf = new File(str+".txt");
				if(qf.createNewFile())
				{

						try{
			                      		 FileWriter no =  new FileWriter("questions.txt",true);
							BufferedWriter p  = new BufferedWriter(no);
							p.write(str);
							p.write(" (posted by roll no "+x+" on "+date+")");
							p.newLine();
                                             		    p.close();
                                                 try{
							FileWriter sp =  new FileWriter(str+".txt",true);
                                               		 BufferedWriter sps = new BufferedWriter(sp);
							sps.write(str);
							sps.newLine();
							sps.close();
						}
                                    		 catch(Exception e)
						{
                                   			System.out.println(e);
                          			     }
						}
						catch(Exception e)
						{
                                 		  System.out.println(e);
                               			}	
				}
        			else
				{
					 System.out.println ("Error, file already exists.");
				}
			}
		catch(Exception e)
			{
				System.out.println("exception in creating file ");
			}		
	}
	public String getQuestionlist()
	{
			String result= "";
			try
			{
			File file=new File("questions.txt");
			FileInputStream fis = new FileInputStream(file);
 			 BufferedInputStream bis = new BufferedInputStream(fis);
  			DataInputStream	dis = new DataInputStream(bis);
			 while (dis.available() != 0) {

   			 result += dis.readLine() + "\n";
			  }
				fis.close();
  				bis.close();
 				 dis.close();
			
			}
			catch(FileNotFoundException e)
			{
				System.out.println("exception in getQuestionlist function");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return result;
				
	}
	public void getAnswer(String s1,String s2)
	{   
	
			String que=s1;
			String ans=s2;
			try
			{
				FileWriter fa=new FileWriter(que+".txt",true);
				BufferedWriter bws=new BufferedWriter(fa);
				bws.write(ans);
				bws.write(" (posted by roll no "+x+" on "+date+")");
				bws.newLine();
				bws.close();
			}
			catch(IOException ioe)
			{
				System.out.println("exception in wrinting answer into file");
			}			
	}			
		public String showAnswers(String sans)
		{
			String r= "";
			try
			{
			File file=new File(sans+".txt");
			FileInputStream fis = new FileInputStream(file);
 			 BufferedInputStream bis = new BufferedInputStream(fis);
  			DataInputStream	dis = new DataInputStream(bis);
			 while (dis.available() != 0) {

   			 r+= dis.readLine() + "\n";
			  }
				fis.close();
  				bis.close();
 				 dis.close();
			
			}
			catch(FileNotFoundException e)
			{
				System.out.println("file not found");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return r;
		}
	public Boolean deleteFile(String dq)
	{
			try
			{
				File df=new File(dq+".txt");
				if(df.delete())
				return true;
				else 
				return false;
			}
			catch(Exception e)
			{
				
				System.out.println("exception in deleting file");
				return false;
			}
	}
	public Boolean blockUser(int bno)
	{
			try
			{
				File bf=new File("password.txt");
				FileWriter bff=new FileWriter(bf);
				a[bno]="qwerty";
				bff.write(a[bno]);
				bff.close();
				return true;
			}
			catch(IOException e)
			{
				return false;
			}
	}
}		