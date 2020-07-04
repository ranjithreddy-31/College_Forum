package client1;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ocf extends Remote
{
	void getQuestion(String z) throws RemoteException;
	void getAnswer(String a,String b) throws RemoteException;
	String getQuestionlist() throws RemoteException;
	String showAnswers(String fp) throws  RemoteException;
	Boolean setPassword(int j,String p) throws RemoteException;
	Boolean matchPassword(int i,String s) throws RemoteException;
	Boolean resetPassword(int r,String sx,String y) throws Exception;
	void getdate(String dt) throws Exception;
	Boolean deleteFile(String dq) throws Exception;
	Boolean blockUser(int bno) throws Exception;
}

			