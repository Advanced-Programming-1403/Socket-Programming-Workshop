package GroupChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 5001;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected");
            // Thread to listen for messages from server
            Thread readThread = new Thread(() -> {
                try {
                    String serverMsg;
                    while (true) {
                        System.out.println(in.readUTF());
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            readThread.start();

            // Read input from user and send to server
            while (true) {
                String userInput = scanner.nextLine();
                out.writeUTF(userInput);
                if (userInput.equalsIgnoreCase("/quit")) {
                    System.out.println("You left the chat.");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Could not connect to server.");
        }
    }
}
