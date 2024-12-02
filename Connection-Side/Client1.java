import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class Client1 {
    private static int port= 5080;
    private static String address= "127.0.0.1";

    private DatagramSocket s;

    public Client1() throws SocketException, UnknownHostException {
        s = new DatagramSocket(5081, InetAddress.getByName(address));
    }

    public void close(){
        s.close();
    }

    public void run() throws IOException{

        String msg = "123456789" ;
        byte[] buffer = new byte[2048];
        int bufferLenght = buffer.length;
        buffer = msg.getBytes();
        int i =0;
        while (i == 0) {
            DatagramPacket tosend = new DatagramPacket(buffer, bufferLenght, InetAddress.getByName(address), port);
            s.send(tosend);

            
            DatagramPacket torecive = new DatagramPacket(buffer, bufferLenght);
            s.receive(torecive);

            System.out.println(new String(torecive.getData()));
            i++;
        }
        





    }

    public static void main(String[] args) {
        
        try {
            Client1 c = new Client1();
            c.run();
            c.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // test if it works
        }

    }




    
}
