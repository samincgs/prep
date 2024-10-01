import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * P1 (Client):
    Connects to both P2 (on port 5000) and P3 (on port 5001) using socket connections.
    Sends the same message to both servers.
    Waits for the responses from both servers and prints them.
 */

public class P1 {
    public static void main(String[] args) {
        try {
            // Connect to P2 on port 5000 and P3 on port 5001
            Socket socketP2 = new Socket("localhost", 5000);
            Socket socketP3 = new Socket("localhost", 5001);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message: ");
            String message = scanner.nextLine();

            // Send message to P2
            DataOutputStream outP2 = new DataOutputStream(socketP2.getOutputStream());
            outP2.writeUTF(message);

            // Send message to P3
            DataOutputStream outP3 = new DataOutputStream(socketP3.getOutputStream());
            outP3.writeUTF(message);

            System.out.println("I have sent \"" + message + "\" to P2 and P3");

            // Receive response from P2
            DataInputStream inP2 = new DataInputStream(socketP2.getInputStream());
            String responseP2 = inP2.readUTF();
            System.out.println("I received as a response from P2: " + responseP2);

            // Receive response from P3
            DataInputStream inP3 = new DataInputStream(socketP3.getInputStream());
            String responseP3 = inP3.readUTF();
            System.out.println("I received as a response from P3: " + responseP3);

            // Close connections
            socketP2.close();
            socketP3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
