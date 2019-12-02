import java.io.IOException;
import java.net.*;

public class QuoteModel {
    private String hostname;
    private int port;
    private String quote;

    public QuoteModel(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getRandomQuote(){
        try{
            InetAddress address = InetAddress.getByName(this.hostname);
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(3000);

            DatagramPacket request = new DatagramPacket(new byte[1], 1, address, this.port);
            socket.send(request);

            byte[] buffer = new byte[512];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);

            this.quote = new String(buffer,0,response.getLength());

        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
            System.exit(-1);
        }catch (SocketException e){
            System.out.println("Socket exception " + e.getMessage());
            System.exit(-1);
        }catch (SocketTimeoutException e){
            System.out.println("Socket Timeout exception " + e.getMessage());
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("I/O exception "+e.getMessage());
            System.exit(-1);
        }
        return quote;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getQuote() {
        return quote;
    }
}
