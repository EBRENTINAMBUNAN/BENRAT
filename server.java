import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Menunggu koneksi dari Android...");
            Socket client = serverSocket.accept();
            System.out.println("Client Android terhubung!");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Masukkan perintah: ");
                String command = consoleInput.readLine();
                out.println(command); // Kirim perintah ke client
                
                if (command.equalsIgnoreCase("exit")) break;
                
                if (command.startsWith("getfile")) {
                    receiveFile(client, command.split(" ")[1]); // Ambil file dari HP
                } else if (command.startsWith("sendfile")) {
                    sendFile(client, command.split(" ")[1]); // Kirim file ke HP
                } else {
                    String response = in.readLine(); // Terima respon dari client
                    System.out.println("Respon dari Android: " + response);
                }
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveFile(Socket client, String fileName) throws IOException {
        DataInputStream dis = new DataInputStream(client.getInputStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = dis.read(buffer)) > 0) {
            fos.write(buffer, 0, bytesRead);
        }
        
        fos.close();
        System.out.println("File " + fileName + " berhasil diterima!");
    }

    private static void sendFile(Socket client, String filePath) throws IOException {
        File file = new File(filePath);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        FileInputStream fis = new FileInputStream(file);
        
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) > 0) {
            dos.write(buffer, 0, bytesRead);
        }
        
        fis.close();
        System.out.println("File " + filePath + " berhasil dikirim ke Android!");
    }
}
