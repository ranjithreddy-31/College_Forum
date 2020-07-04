import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
			Registry reg=LocateRegistry.createRegistry(1080);
			reg.bind("ocf",s);
			System.err.println("server ready");
		}
		catch(Exception e)
		{
			System.err.println("server exception"+e.toString());
			
		}
	}
}
											