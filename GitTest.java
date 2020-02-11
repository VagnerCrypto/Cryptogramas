package br.com.hst.GitandJava;

//Importações criptográficas
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * Classe principal
 * @author vagner_lima
 *
 */
public class GitTest
{

	public static void main(String[] args)
	{
	    //Abre o fluxo de leitura
	    Scanner in = new Scanner(System.in);
	    
	    String plainText;
	    
		System.out.println("Hello Git");
		System.out.println();		
		
		System.out.print("Digite algo: ");
		plainText = in.nextLine();
		
		System.out.println();
		System.out.println();
		
		//Atribui o texto cifrado ao Array de bytes
		byte[] cipherText = Crypto.encrypt(plainText);
		
		//Apresenta caractere por caractere do texto cifrado
		System.out.print("Texto cifrado: ");
		for(int i = 0; i < cipherText.length; i++)
			System.out.print(cipherText[i]);
		
		//Apresenta o texto plano
		System.out.println();
		System.out.println("Texto plano/claro: " + Crypto.decrypt(cipherText));
		System.out.printl("Teste de pull");
		//Finaliza o fluxo de leitura
		in.close();
	}

}

/**
 * Classe criptográfica (AES)
 * @author vagner_lima
 *
 */
class Crypto
{
	
//	Atributos:
//	AES - Criptografia simétrica AES
//	key - Chave privada de criptografia
//	IV - Vetor de inicialização do AES
	static Cipher AES;
	static SecretKey key;
	static IvParameterSpec IV;
	
	/**
	 * Encripta o texto plano com AES
	 * @param plainText - O texto claro a ser criptografado
	 * @return - retorna o texto cifrado
	 */
	public static byte[] encrypt(String plainText)
	{
		try 
		{
			
			//AES com modo CBC e protocolo PKCS5
			AES = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			String InitIV = "1111111111111111";	
			
			KeyGenerator sKey = KeyGenerator.getInstance("AES");
			
			//Tamanho da chave em bits
			sKey.init(256);	
			
			key = sKey.generateKey();
			
			IV = new IvParameterSpec(InitIV.getBytes());
			
			//Inicia a criptografia
			AES.init(Cipher.ENCRYPT_MODE, key, IV);
			
			
			//Retorna a informação criptografada
			return AES.doFinal(plainText.getBytes());
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
				BadPaddingException e) 
		{
			e.printStackTrace();
		}
		
		//Caso aconteça alguma excessão, retorna o valor nulo ao método chamador
		return null;
		
	}
	
	/**
	 * Decripta os dados usando a mesma chave do AES
	 * @param cipherText - O texto cifrado a ser descriptografado
	 * @return - Retorna o texto plano
	 */
	public static String decrypt(byte[] cipherText)
	{
		try
		{
			AES.init(Cipher.DECRYPT_MODE, key, IV);
		
			return new String(AES.doFinal(cipherText));
		}
		catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
				BadPaddingException e) 
		{
			e.printStackTrace();
		}
		
		return "ERRO!";
	}
}
