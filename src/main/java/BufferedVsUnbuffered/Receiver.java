package BufferedVsUnbuffered;

import java.io.*;
import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        int port = 5001;
        String savePath = "C:\\Users\\amira\\OneDrive\\Desktop\\received_file.dat";

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
             FileOutputStream fos = new FileOutputStream(savePath);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            System.out.println("Client connected. Receiving file...");

            long fileSize = dis.readLong();
            byte[] buffer = new byte[4 * 8192];
            int read;
            long totalRead = 0;

            while (totalRead < fileSize && (read = dis.read(buffer, 0, (int)Math.min(buffer.length, fileSize - totalRead))) != -1) {
                bos.write(buffer, 0, read);
                totalRead += read;
            }

            System.out.println("File received successfully. Saved at: " + savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
