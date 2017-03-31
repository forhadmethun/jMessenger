package chatmessenger;

import java.net.*;
import java.util.*;
import java.io.*;

public class ChatServer
{
    static Vector ClientSockets;
    static Vector LoginNames;
    ServerSocket soc;
	
    ChatServer() 
    {
        try 
        {
            soc=new ServerSocket(5217);
            ClientSockets=new Vector();
            LoginNames=new Vector();
        }
        catch(IOException e)
        {
            System.out.println("Could not listen on port 5217");
            System.exit(1);
        }

        while(true)
        {	
            try
            {
                Socket CSoc=soc.accept();		
                AcceptClient obClient=new AcceptClient(CSoc);
            }
            catch(IOException e)
            {
                System.out.println("Accept failed:5217");
                System.exit(1);
            }
        }
    }
    
    public static void main(String args[]) throws Exception
    {

            ChatServer ob=new ChatServer();
    }

    public static class AcceptClient extends Thread
    {
        Socket ClientSocket;
	DataInputStream din;
	DataOutputStream dout;
        
	AcceptClient (Socket CSoc) 
	{
            try
            {
		ClientSocket=CSoc;

		din=new DataInputStream(ClientSocket.getInputStream());
		dout=new DataOutputStream(ClientSocket.getOutputStream());
		
		String LoginName=din.readUTF();
                
		System.out.println("User Logged In :" + LoginName);
		LoginNames.add(LoginName);
		ClientSockets.add(ClientSocket);
                start();
                
                String msg="LIST server "+LoginNames.size()+" ";
                for(int iCount=0;iCount<LoginNames.size();iCount++)
                {
                    msg+=LoginNames.elementAt(iCount)+" ";
                }
                for(int iCount=0;iCount<ClientSockets.size();iCount++)
                {
                    Socket tSoc=(Socket)ClientSockets.elementAt(iCount);							
                    DataOutputStream tdout=new DataOutputStream(tSoc.getOutputStream());
                    tdout.writeUTF(msg);
                }
            }
            catch(Exception ex)
            {
            }
	}
     

        @Override
	public void run()
	{
            while(true)
            {
                try
                {
                    String msgFromClient=new String();
                    msgFromClient=din.readUTF();
                    StringTokenizer st=new StringTokenizer(msgFromClient);
                    String MsgType=st.nextToken();
                    String send_from=st.nextToken();
                    int iCount=0;

                    if(MsgType.equals("LOGOUT"))
                    {
                        for(iCount=0;iCount<LoginNames.size();iCount++)
                        {
                            if(LoginNames.elementAt(iCount).equals(send_from))
                            {
                                    LoginNames.removeElementAt(iCount);
                                    ClientSockets.removeElementAt(iCount);
                                    System.out.println("User " +send_from+" Logged Out ...");
                                    break;
                            }
                        }
                        
                        String msg="LIST "+send_from+" "+LoginNames.size();
                        
                        for(iCount=0;iCount<LoginNames.size();iCount++)
                        {
                            msg+=" "+(String)LoginNames.elementAt(iCount);
                        }
                        for(iCount=0;iCount<ClientSockets.size();iCount++)
                        {
                            Socket tSoc=(Socket)ClientSockets.elementAt(iCount);							
                            DataOutputStream tdout=new DataOutputStream(tSoc.getOutputStream());
                            tdout.writeUTF(msg);
                        }
                    }
                    
                    else if(MsgType.equals("DATA"))
                    {
                        
                        String msg="MESS "+send_from;
                        while(st.hasMoreTokens())
                        {
                                msg=msg+" " +st.nextToken();
                        }
                        for(iCount=0;iCount<LoginNames.size();iCount++)
                        {
                            if(LoginNames.elementAt(iCount).equals(send_from)==false)
                            {	
                                Socket tSoc=(Socket)ClientSockets.elementAt(iCount);							
                                DataOutputStream tdout=new DataOutputStream(tSoc.getOutputStream());
                                tdout.writeUTF(msg);							
                            }
                        }

                    }
                }
                catch(Exception ex)
                {
                }
            }		
	}
    }
}

 

