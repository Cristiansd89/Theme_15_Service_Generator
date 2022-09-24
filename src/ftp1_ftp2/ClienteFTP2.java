package ftp1_ftp2;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;

public class ClienteFTP2 {

	public static void main(String[] args) throws SocketException, IOException {
		
		FTPClient ftp = new FTPClient();
		FTPClientConfig config = new FTPClientConfig();
		
		String server = "ftp.rediris.es";
		
		System.out.println("nos conectamos a "+server);
		ftp.connect(server);
		int respuesta = ftp.getReplyCode();
		

		
		String user = "anonymous";
		String password = "";
		
		ftp.login(user,password);
		
		
		
		
		if(ftp.login(user, password)) {
			System.out.println("el login exitoso");
			System.out.println("directorio actual "+ftp.printWorkingDirectory() );
			
			
			FTPFile[]files=ftp.listFiles();
			System.out.println("ficheros en el direct acutal "+files.length);
			
			String tipos[] = {"ficheros","directorio","enlace simb"};
			for(int i = 0; i<files.length; i++) {
				System.out.println("/n"+files[i].getName()+"  "+tipos[files[i].getType()]+files[i].getType());
			}
			
			
			
			
		}
		else if(!ftp.login(user, password)) {
			System.out.println("el login no se ha realizado con exito");
			ftp.logout();
			ftp.disconnect();
			System.exit(0);			
		}	
		
		if(!FTPReply.isPositiveCompletion(respuesta)) {
			ftp.disconnect();
			System.out.println("conexion rechazada");
			System.exit(0);
			
		}
		ftp.disconnect();
		System.out.println("conexion finalizada");
		
		
		
		System.out.println(ftp.getReplyString());
		


	}

}
