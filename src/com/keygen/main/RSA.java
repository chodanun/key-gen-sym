package com.keygen.main;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class RSA {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyGen.genKeyPair().getPrivate();
        PublicKey publicKey = keyGen.genKeyPair().getPublic();
        
    	String data = "TEST";
    	byte[] en = encrypt(data,publicKey);
    	System.out.println("data encryption : "+en);
    	
    	String de = decrypt(en,privateKey);
    	System.out.println("data decryption : "+de);
    	
    
    }
	public static byte[] encrypt(String text, PublicKey key) {
	    byte[] cipherText = null;
	    try {
	      final Cipher cipher = Cipher.getInstance("RSA");
	      cipher.init(Cipher.ENCRYPT_MODE, key);
	      cipherText = cipher.doFinal(text.getBytes());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return cipherText;
	  }
	
	public static String decrypt(byte[] text, PrivateKey key) {
	    byte[] dectyptedText = null;
	    try {
	      final Cipher cipher = Cipher.getInstance("RSA");
	      cipher.init(Cipher.DECRYPT_MODE, key);
	      dectyptedText = cipher.doFinal(text);

	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }

	    return new String(dectyptedText);
	  }
}
