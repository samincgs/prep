import org.apache.xmlrpc.WebServer;

public class P3 {

    // Method to calculate the multiplication of two numbers
    public Integer multiply(int x, int y) {
        System.out.println("Executing multiply operation with params: " + x + ", " + y);
        return x * y;
    }

    public static void main(String[] args) {
        try {
            // Start the XML-RPC server on port 90
            WebServer server = new WebServer(90);
            
            // Add a handler with the name "Service2" for handling multiply requests
            server.addHandler("Service2", new P3());
            
            // Start the server
            server.start();
            System.out.println("P3: Multiply server started and waiting for requests...");
        } catch (Exception e) {
            System.err.println("P3 Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
