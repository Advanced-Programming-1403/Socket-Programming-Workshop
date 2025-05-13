package BufferedVsUnbuffered;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Gen {
    public static void main(String[] args) {
        System.out.println("Generating...");
        String filename = "src/main/resources/file.dat";
        int sizeInMB = 10;
        int sizeInBytes = sizeInMB * 1024 * 1024;

        byte[] buffer = new byte[32 * 1024]; // 32 KB buffer
        Random random = new Random();

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            int written = 0;
            while (written < sizeInBytes) {
                random.nextBytes(buffer);
                int toWrite = Math.min(buffer.length, sizeInBytes - written);
                fos.write(buffer, 0, toWrite);
                written += toWrite;
            }
            System.out.println("File created: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
