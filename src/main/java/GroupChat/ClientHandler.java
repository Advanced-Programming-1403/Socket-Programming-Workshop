package GroupChat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private String name;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Enter your name: ");
            name = in.readUTF();
            System.out.println(name + " has joined.");

            Server.broadcast(name + " has joined the chat!", this);

            String msg;
            while (true) {
                msg = in.readUTF();
                if (msg.equalsIgnoreCase("/quit")) {
                    break;
                }
                String fullMsg = name + ": " + msg;
                System.out.println(fullMsg);
                Server.broadcast(fullMsg, this);
            }
        } catch (IOException e) {
            System.out.println("Connection error with client: " + name);
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
            Server.removeClient(this);
            try {
                Server.broadcast(name + " has left the chat.", this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " disconnected.");
        }
    }

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }
}
