package ftp1_ftp2;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.Configurable;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

public class ClienteFTP1 extends FTP implements Configurable {

	
	
	
	public static void main(String[] args) throws SocketException, IOException {
		
		FTPClient ftp = new FTPClient();
		FTPClientConfig config = new FTPClientConfig();
		
		String server = "ftp.rediris.es";
		
		System.out.println("nos conectamos a "+server);
		ftp.connect(server);
		
		System.out.println(ftp.getReplyString());
		
		int respuesta = ftp.getReplyCode();
		
		if(!FTPReply.isPositiveCompletion(respuesta)) {
			ftp.disconnect();
			System.out.println("conexion rechazada");
			System.exit(0);
			
		}
		ftp.disconnect();
		System.out.println("conexion finalizada");
		

	}
	@Override
	public void configure(FTPClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}




