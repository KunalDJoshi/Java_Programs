/**
 *CaesarServer class implements CaesarConstants.
 *CaesarServer class has execute method. 
 *This class will either encrypt or decrypt text received from client using the Caesar cipher.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-11-26
 */
package Joshi_HW11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CaesarServer implements CaesarConstants{

    /**
    This is the main method which calls execute() method.It accepts key value from command line.
    If user does not enter key value, then default shift value gets assigned to key.
    * @param args.
    * @return Nothing.
    */	
	public static void main(String args[])
	{
		int key;
		System.out.println("Enter the shift value:");
		if(args.length==0) {
			key=DEFAULT_SHIFT;
		}
		else {
		 key=Integer.parseInt(args[0]);
		}
		CaesarServer cs = new CaesarServer();
		cs.execute(key);
		
	}

	
    /**
	This method is for making connection with client through socket. 
	@param int key.
   @return Nothing
	*/
	public void execute(int key)
	{
		
		try {
			System.out.println("Accepting connection");
			ServerSocket ss = new ServerSocket(PORT_NUMBER);
			while(true){
			Socket soc= ss.accept();
			InnerClass ic = new InnerClass(soc,key);
			ic.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
    /**
     *InnerClass class is inner class of CaesarServer class which extends Thread class.
     *InnerClass class has InnerClass constructor. 
     *This class has run() method.
     */	
	public class InnerClass extends Thread{
		Socket s;
		int keyval;
		char alphabet;
		String plaintext;
		String encrypted_Message;
		String ciphertext;
		String decrypted_Message;
		BufferedReader in = null;
		PrintWriter out = null;
		

    /**
    This is constructor of InnerClass class. 
    * @param Socket _s, int key.
    */		
		public InnerClass(Socket _s, int key)
		{
			 s= _s;
			 keyval=key;
		}
		
	    /**
		This method is to encrypt or decrypt the message received from client. 
		@param Nothing.
	   @return Nothing
		*/		
		public void run()
		{
			try {
				System.out.println("Server Started");
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				out = new PrintWriter(s.getOutputStream());
				while(true) {
				String data=in.readLine();
				if(data==null)
					continue;
				System.out.println("Message received from client is: "+data);
				if(data.equals("ENCRYPT"))
				{
					out.println("OK");
					out.flush();
					
					encrypted_Message="";
					plaintext=in.readLine();
					for(int i = 0; i < plaintext.length(); i++){
					      alphabet = plaintext.charAt(i);
					      
					      if(alphabet >= 'a' && alphabet <= 'z'){
					              alphabet = (char)(alphabet + keyval);
					              
					              if(alphabet > 'z'){
					                  alphabet = (char)(alphabet - 'z' + 'a' - 1);
					              }
					              
					              encrypted_Message += alphabet;
					          }
					          else if(alphabet >= 'A' && alphabet <= 'Z'){
					              alphabet = (char)(alphabet + keyval);
					              
					              if(alphabet > 'Z')
					        {
					                  alphabet = (char)(alphabet - 'Z' + 'A' - 1);
					              }
					              
					              encrypted_Message += alphabet;
					          }
					          else {
					          	encrypted_Message += alphabet;
					          }
					    }
					out.println(encrypted_Message);
					out.flush();
					
				}
				else if(data.equals("DECRYPT"))
				{					
					out.println("OK");
					out.flush();
					
					decrypted_Message="";
					ciphertext=in.readLine();
					 for(int i = 0; i < ciphertext .length(); ++i){
					      alphabet = ciphertext .charAt(i);
					      
					      if(alphabet >= 'a' && alphabet <= 'z'){
					              alphabet = (char)(alphabet - keyval);
					              
					              if(alphabet < 'a'){
					                  alphabet = (char)(alphabet + 'z' - 'a' + 1);
					              }
					              
					              decrypted_Message += alphabet;
					          }
					          else if(alphabet >= 'A' && alphabet <= 'Z'){
					              alphabet = (char)(alphabet - keyval);
					              
					              if(alphabet < 'A'){
					                  alphabet = (char)(alphabet + 'Z' - 'A' + 1);
					              }
					               
					              decrypted_Message += alphabet;
					          }
					          else {
					          	decrypted_Message += alphabet;
					          }
					    } 
						out.println(decrypted_Message);
						out.flush();
				}
				else
				{
					System.out.println("Error in command sent by client");
					out.println("Error in command sent by client");
					out.flush();
				}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
