package socket.examples;

//A Java program for a Client 
import java.net.*;
import java.util.Scanner;
import java.io.*; 

public class MyClient { 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	//private DataInputStream input = null; 
	private Scanner scanner = null;
	private DataOutputStream out	 = null; 

	// constructor to put ip address and port 
	public MyClient(String address, int port) { 
		// establish a connection 
		try { 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 

			// takes input from terminal 
			//input = new DataInputStream(System.in); 
			scanner = new Scanner(System.in);

			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) { 
			System.out.println(u); 
		} 
		catch(IOException i) { 
			System.out.println(i); 
		} 

		// string to read message from input 
		String line = ""; 

		// keep reading until "Over" is input 
		while (!line.equals("Over")) { 
			try { 
				//line = input.readLine(); 
				System.out.print("Type your input and then hit Return, or type the keyword \"Over\" and then hit return to exit: ");
				line = scanner.nextLine();
				out.writeUTF(line); 
			} 
			catch(IOException i) { 
				System.out.println(i); 
			} 
		} 

		// close the connection 
		try { 
			//input.close(); 
			scanner.close();
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) { 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) { 
		MyClient client = new MyClient("127.0.0.1", 5000); 
	} 
} 
