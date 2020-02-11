package br.com.hst.GitandJava;

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

public class GitTest {

	public static void main(String[] args)
	{
	    Scanner in = new Scanner(System.in);
	    String plainText;
	    
		System.out.println("Hello Git");
		System.out.println();		
		
		System.out.print("Digite algo: ");
		plainText = in.nextLine();
		
		System.out.println();
		System.out.println();
		
		byte[] cipherText = Crypto.encrypt(plainText);
		
		System.out.print("Texto cifrado: ");
		for(int i = 0; i < cipherText.length; i++)
			System.out.print(cipherText[i]);
		
		System.out.println();
		System.out.println("Texto plano/claro: " + Crypto.decrypt(cipherText));
		
		in.close();
	}

}


class Crypto
{
	static Cipher AES;
	static SecretKey key;
	static IvParameterSpec IV;
	
	public static byte[] encrypt(String plainText)
	{
		try 
		{
			AES = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			String InitIV = "1111111111111111";
			
			
			KeyGenerator sKey = KeyGenerator.getInstance("AES");
			
			sKey.init(256);	
			key = sKey.generateKey();
			
			IV = new IvParameterSpec(InitIV.getBytes());
			
			AES.init(Cipher.ENCRYPT_MODE, key, IV);
			
			return AES.doFinal(plainText.getBytes());
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
				BadPaddingException e) 
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
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