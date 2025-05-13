package BufferedVsUnbuffered;

import java.io.*;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5001;
        String filePath = "C:\\Users\\amira\\OneDrive\\Desktop\\file.dat";

        File file = new File(filePath);

        try (Socket socket = new Socket(host, port);
             FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()))) {

            System.out.println("Sending file: " + file.getName());

            long fileSize = file.length();
            dos.writeLong(fileSize); // send file size first

            byte[] buffer = new byte[4 * 8192];
            int read;
            while ((read = bis.read(buffer)) != -1) {
                dos.write(buffer, 0, read);
            }

            dos.flush();
            System.out.println("File sent successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
