import java.io.IOException;
import java.net.*;

public class Server  {
    private static int port= 5080;
    private static String address= "127.0.0.1";
    private DatagramSocket s;


    // Creazione dello socket
    public Server() throws SocketException, UnknownHostException {
        
        s = new DatagramSocket(port, InetAddress.getByName(address));
    }

    // Chiude il Socket
    public void close(){
        System.out.println("Chiudo Socket");
        s.close();
    }

    public void serverRun(){
        byte[] buffer = new byte[2048];

        
        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);

            try {
                s.receive(request);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("Error!! Recive");
            }

            buffer = request.getData();
            String data = new String(buffer);

            if (data.equals("quit")){
                // TO BE CONTINUED
                // how can i close game match? i need to kick out both parties?
                close();
            }

            // Test per vedere se i dati vengo inviati
            System.out.println(data+"\n");


            // test se manda quacosa
            String msg = "Sent by Server 0";
            buffer = null;
            buffer = msg.getBytes();
            DatagramPacket answer = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
            
            try {
                s.send(answer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("Error!!! Send");
            }

        }

    }

    


    public static void main(String[] args) {
        try {

            Server s = new Server();
            s.serverRun();


            
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

