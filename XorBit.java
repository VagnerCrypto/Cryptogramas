package br.com.hst.convert;

public class XorBit 
{
	private byte[] byteArray;
	private byte[] byteArrayKey;
	
	//XOR byte a byte
    public byte[] byteXor(byte[] byteArray, byte[] byteArrayKey)
    {
    	this.byteArray = byteArray;
    	this.byteArrayKey = byteArrayKey;
    	
    	byte[] xorCipherArray = new byte[byteArray.length];
    	
    	for(int i = 0; i < xorCipherArray.length; i++)
    	{
    		xorCipherArray[i] = (byte) ((byteArrayKey[i]) ^ byteArray[i]);
    	}
    	
    	return xorCipherArray;
    }
    
    //Xor inverso byte a byte
    public byte[] byteXorReverse(byte[] cipherArray)
    {
    	byte[] xorArray = new byte[cipherArray.length];    	
    	
    	for(int i = 0; i < cipherArray.length; i++) 	
    		xorArray[i] = (byte) ((byteArrayKey[i]) ^ cipherArray[i]);
    	
    	
    	return xorArray;
    }
}
