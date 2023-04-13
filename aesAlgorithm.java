/******************************************************************************

Implementation of AES algorithm..
Advanced Encryption Standard

Input:
mykey
Nithin

Output:
Encrypted: IFenD7MeBCljBz05Speg3g==
Decrypted: Nithin

*******************************************************************************/

import java.io.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Main{
    
    public static SecretKeySpec sk;
    public static byte[] key;
    
    public static void setKey(String s){
        MessageDigest sha=null;
        try{
            key=s.getBytes("UTF-8");
            sha=MessageDigest.getInstance("SHA-1");
            key=sha.digest(key);
            key=Arrays.copyOf(key,16);
            sk=new SecretKeySpec(key,"AES");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static String encrypt(String p,String k){
        try{
            setKey(k);
            Cipher c=Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(c.ENCRYPT_MODE,sk);
            return Base64.getEncoder().encodeToString(c.doFinal(p.getBytes("UTF-8")));
            //return Base64.getEncoder().encodeToString(c.doFinal(strToEncrypt.getBytes("UTF -8")));
        }catch(Exception e){
            return e.toString();
        }
    }
    
    public static String decrypt(String s,String k){
        try{
         setKey(k);
         Cipher c=Cipher.getInstance("AES/ECB/PKCS5padding");
         c.init(c.DECRYPT_MODE,sk);
         return new String(c.doFinal(Base64.getDecoder().decode(s)));
        }catch(Exception e){
            return e.toString();
        }
    }
    
    public static void main(String[] a){
    Scanner x=new Scanner(System.in);
    String k=x.nextLine();
    String p=x.nextLine();
    String en=encrypt(p,k);
    System.out.println("Encrypted: "+en);
    System.out.println("Decrypted: "+decrypt(en,k));
    }
}
