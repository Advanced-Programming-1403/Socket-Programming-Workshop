package ObjectStream;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Person person = new Person("Daniel", 25);

        String host = "localhost";
        int port = 5001;

        // Try With Resources
        try (Socket socket = new Socket(host, port)) {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(person);
            System.out.println("Sent to server: " + person);

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
