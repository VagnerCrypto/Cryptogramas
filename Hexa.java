package br.com.hst.convert;

public class Hexa
{
	// Converte a string em bytes
	public byte[] stringToByte(String str)
	{
		String strUp = str.toUpperCase();

		byte[] output = new byte[strUp.length() / 2];

		char ch = 0;
		byte b1 = 0;
		byte b2 = 0;

		for (int i = 0; i < output.length; i++) 
		{
			// Pega um caractere da string
			ch = strUp.charAt(i * 2);

			// O limite é a notação hexa de A a F
			if ((ch >= 'A') && (ch <= 'F')) 
			{
				/*
				 * Notação ASCII No índice 0, ch vale A, e A na ASCII é 65 65 - 65 = 0, depois
				 * some de volta com A = 65, que na ASCII é A Transforma em bits com o AND bit a
				 * bit no limite de 255 bits em bits será 0100 0001, que é 41 em hexa, 65 em
				 * decimal e A em ASCII :)
				 */
				b1 = (byte) (((ch - 'A') + 0x0A) & 0x0F);
			} 
			else
			{
				b1 = (byte) ((ch - '0') & 0x0F);
			}

			ch = strUp.charAt((i * 2) + 1);

			if ((ch >= 'A') && (ch <= 'F')) 
				b2 = (byte) (((ch - 'A') + 0x0A) & 0x0F);
			 else 
				b2 = (byte) ((ch - '0') & 0x0F);
			

			// Desloca 4 bits a esquerda, realiza um OR bit a bit e um AND bit a bit com o
			// 255(0xFF)
			output[i] = (byte) (((b1 << 4) | b2) & 0xFF);
		}

		// Retorna a string em bytes
		return output;

	}

	// Converte o array de bytes em String
	public String byteToString(byte[] input)
	{
		String output = "";

		char ch = 0;
		byte b1 = 0;
		byte b2 = 0;

		for (int i = 0; i < input.length; i++) 
		{
			// Desloca os bits a direita e realiza um AND bit a bit com 255(0xFF)
			b1 = (byte) ((input[i] >> 4) & 0x0F);

			if (b1 > 9) 
				ch = (char) ('A' + (b1 - 10));
			else 
				ch = (char) ('0' + b1);
			

			output += ch;

			b2 = (byte) (input[i] & 0x0F);

			if (b2 > 9) 
				ch = (char) ('A' + (b2 - 10));
			else 
				ch = (char) ('0' + b2);
			

			output += ch;
		}

		return output;
	}

	// Método para quebrar a string Hexa (Não foi tulizado, porém ele ira separar de
	// dois em dois caracteres a string
	public String oneByteString(byte input)
	{
		String output = "";

		char ch = 0;
		byte b1 = 0;
		byte b2 = 0;

		b1 = (byte) ((input >> 4) & 0x0F);

		if (b1 > 9) 
			ch = (char) ('A' + (b1 - 10));
		else 
			ch = (char) ('0' + b1);
		

		output += ch;

		b2 = (byte) (input & 0x0F);

		if (b2 > 9) 
			ch = (char) ('A' + (b2 - 10));
		else 
			ch = (char) ('0' + b2);
		

		output += ch;

		return output;
	}

}
