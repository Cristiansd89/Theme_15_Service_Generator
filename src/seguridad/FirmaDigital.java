package seguridad;
import java.security.*;
public class FirmaDigital {
    public static void main(String[] args) {
    	try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
			//SE INICIALIZA EL GENERADOR DE CLAVES
			SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
			keyGen.initialize (1024, numero);
			
			//SE CREA EL PAR DE CLAVES
			KeyPair par = keyGen.generateKeyPair();
			PrivateKey clavepriv = par.getPrivate();
			PublicKey clavepub = par.getPublic();
			
			//OBJETO Signature,FIRMA CON CLAVE PRIVADA EL MENSAJE
			Signature dsa = Signature.getInstance("SHA1withDSA");
			dsa.initSign (clavepriv);
			String mensaje = "Este mensaje va a ser firmado";
			dsa.update(mensaje.getBytes());
			
			byte [] firma= dsa.sign(); //mensaje firmado
			
			//EL RECEPTOR DEL MENSAJE
			//VERIFICA CON LA CLAVE PUBLICA EL MENSAJE FIRMADO
			Signature verificadsa = Signature.getInstance("SHA1withDSA");
			verificadsa.initVerify(clavepub);			
			verificadsa.update(mensaje.getBytes());
			boolean check = verificadsa.verify(firma);			
			if(check)
				System.out.println("FIRMA VERIFICADA CON CLAVE PRIVADA");
			else System.out.println("FIRMA NO VERIFICADA");		
      
    	} catch (NoSuchAlgorithmException e1) {			
			e1.printStackTrace();
		} catch (InvalidKeyException e) {			
			e.printStackTrace();
		} catch (SignatureException e) {			
			e.printStackTrace();
		} 
    }//main
}//..Ejemplo7
