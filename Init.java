package br.com.hst.convert;


public class Init
{

	public static void main(String[] args) 
	{
		
		//Classe de opreaçoes XOR bit a bit
		XorBit arrayXor = new XorBit();
		
		//Referecnias para objetos de transformações
		Hexa hexa = new Hexa();
		Hexa hx = new Hexa();

		// Strings hexadecimais
		String notHex = "ABCD9FF8F9";
		String notHex2 = "BC9ADBF19C";

		// Envia os arrays de bytes
		byte[] hex = hexa.stringToByte(notHex);
		byte[] hex2 = hx.stringToByte(notHex2);

		// Apresentação em bytes do primeiro array
		System.out.print("Valor em bytes (Array 1): ");
		for (int i = 0; i < hex.length; i++)
			System.out.print(hex[i]);

		System.out.println();

		// A string original
		System.out.println("Valor em string: " + hexa.byteToString(hex));
		System.out.println();
		System.out.println();
        
		
		//Apresnetação em bytes do segundo array
		System.out.print("Valor em bytes (Array 2): ");
	       for(int i = 0; i < hex2.length; i++)
	    	   System.out.print(hex2[i]);  
	       
	       System.out.println();
	       System.out.println("Valor em string: " + hexa.byteToString(hex2));
	       System.out.println();
	       
	       System.out.println("ARRAY 1");
	       System.out.println("  X");
	       System.out.println("Array2");
	       System.out.println();
	       
	       //Envia o array criptografado
	       byte[] xArray = arrayXor.byteXor(hex, hex2);
	       System.out.println();
	       
	       //Apresneta o novo array criptografado em bytes
	       System.out.print("XOR: ");
	       for(int i = 0; i < xArray.length; i++)
	    	   System.out.printf("%3d",xArray[i]);
	       
	       System.out.println();
	       
	       //Reverte o XOR
	       byte[] xRevert = arrayXor.byteXorReverse(xArray);
	       
	       //Apresenta o array descriptografado (Array1)
	       System.out.print("Xor inverso: ");
	       for(int i = 0; i < xRevert.length; i++)
	    	   System.out.printf("%3d",xRevert[i]);	 
	       
	       System.out.println();
	       
	       //A string original
	       System.out.println("Valor em string (O primeiro): " + hx.byteToString(xRevert));
	       System.out.println();
	       System.out.println();
       
       
	}

}
