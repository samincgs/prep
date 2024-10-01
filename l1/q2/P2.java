import org.apache.xmlrpc.WebServer;

public class P2 {

    // Method to calculate the difference between two numbers
    public Integer diff(int x, int y) {
        System.out.println("Executing diff operation with params: " + x + ", " + y);
        return x - y;
    }

    public static void main(String[] args) {
        try {
            // Start the XML-RPC server on port 80
            WebServer server = new WebServer(80);
            
            // Add a handler with the name "Service1" for handling diff requests
            server.addHandler("Service1", new P2());
            
            // Start the server
            server.start();
            System.out.println("P2: Diff server started and waiting for requests...");
        } catch (Exception e) {
            System.err.println("P2 Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
