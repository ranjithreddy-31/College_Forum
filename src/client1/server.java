/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client1;


import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class server extends simple
{
	public server() throws Exception
	{
	}
	public static void main(String args[])
	{
		try
		{
			simple s=new simple();
			Registry reg=LocateRegistry.createRegistry(1072);
			reg.bind("ocf",s);
			System.err.println("server ready");
		}
		catch(Exception e)
		{
			System.err.println("server exception"+e.toString());
			
		}
	}
}
											