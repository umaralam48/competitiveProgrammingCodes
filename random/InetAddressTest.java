import java.net.*;

class InetAddressTest{
    public static void main(String[] args)throws UnknownHostException{
        InetAddress address=InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
    }
}