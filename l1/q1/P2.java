import java.net.*;
import java.io.*;

/**
 * P2 and P3 (Servers):
 * Both servers listen on different ports (P2 on port 5000 and P3 on port 5001).
 * Each server accepts a connection from P1, receives the message, modifies it by appending a specific string ("-I am P2" or "-I am P3"), 
 * and sends the modified message back to P1.
 */

public class P2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("P2 is waiting for a connection...");

            // Accept the connection
            Socket socket = serverSocket.accept();
            System.out.println("P2: Connection accepted");

            // Read the message from P1
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();
            System.out.println("I received from P1: " + message);

            // Append "-I am P2" to the message
            String modifiedMessage = message + "-I am P2";

            // Send the modified message back to P1
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(modifiedMessage);

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
