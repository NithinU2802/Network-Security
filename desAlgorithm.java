/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.security.*;
import javax.crypto.*;

public class Main
{
    
    private static byte[] encrypt(String s,SecretKey sk){
    try{
	Cipher des=Cipher.getInstance("DES/ECB/PKCS5Padding");
	des.init(Cipher.ENCRYPT_MODE,sk);
	byte[] t=s.getBytes();
	byte[] en=des.doFinal(t);
	return en;
    }catch(Exception e){
        return e.toString().getBytes();
    }
    }
    
    private static String decrypt(byte[] s,SecretKey sk){
    try{
	Cipher des=Cipher.getInstance("DES/ECB/PKCS5Padding");
	des.init(Cipher.DECRYPT_MODE,sk);
	byte[] de=des.doFinal(s);
	return new String(de);
    }catch(Exception e){
        return e.toString();
    }
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	try{
	KeyGenerator kg=KeyGenerator.getInstance("DES");
	SecretKey sk=kg.generateKey();
	byte[] en=encrypt(s,sk);
	System.out.println("Encrypted: "+en.toString());
	System.out.println("Decrypted: "+decrypt(en,sk));
	}catch(Exception e){
	    System.out.println(e);
	}
	}
}
