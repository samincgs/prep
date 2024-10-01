import org.apache.xmlrpc.XmlRpcClient;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;

public class P1 {

    public static void main(String[] args) {
        try {
            // Create XML-RPC clients for both servers
            XmlRpcClient clientP2 = new XmlRpcClient(new URL("http://localhost:80/RPC2"));
            XmlRpcClient clientP3 = new XmlRpcClient(new URL("http://localhost:90/RPC2"));

            Scanner scanner = new Scanner(System.in);
            Vector<Integer> params = new Vector<>();

            // Get user input
            System.out.print("Enter first number: ");
            int x = scanner.nextInt();
            System.out.print("Enter second number: ");
            int y = scanner.nextInt();

            // Add the parameters to the vector
            params.add(x);
            params.add(y);

            // Call the diff method on P2 and print the result
            Object resultDiff = clientP2.execute("Service1.diff", params);
            System.out.println("The result of diff operation is: " + resultDiff);

            // Call the multiply method on P3 and print the result
            Object resultMultiply = clientP3.execute("Service2.multiply", params);
            System.out.println("The result of multiply operation is: " + resultMultiply);

        } catch (Exception e) {
            System.err.println("P1 Client Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
