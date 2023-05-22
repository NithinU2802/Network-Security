/******************************************************************************

                Digital Signature Algorithm implementation 
       


Input:      
Enter Date: How are you?

output:
Digital Signature: 0=☻↔???-◄??$?#Q☻???¶^?(???I⌂?P◄☻∟z?‼??►#zFJ??Y????iU?♣4???T?
       

*******************************************************************************/
import java.util.*;
import java.security.*;

public class Main
{
	public static void main(String[] args) throws Exception{
	Scanner x=new Scanner(System.in);
	System.out.print("Enter Date: ");
	String s=x.nextLine();
	
	// make a object for KeyPairGenerator for DSA used to create keys
	KeyPairGenerator keyPairGen=KeyPairGenerator.getInstance("DSA");
	
	// initialize for generating required keys
	keyPairGen.initialize(2048);
	
	// generate pair the store on pair that can be represent with object name and address(which keys stored)
	KeyPair pair=keyPairGen.generateKeyPair(); 
	// System.out.print(pair); to get Keypair : java.security.KeyPair@12a3a380 represent address
	
	// get the generate privateKey 
	PrivateKey privateKey=pair.getPrivate();  
	System.out.println(privateKey);
	
	// Now get Signature in the format SHAwithDSA  form the Signature
	Signature sign=Signature.getInstance("SHA256withDSA"); 
	sign.initSign(privateKey);  // pass privateKey for generating signature
	
	
	byte[] bytes=s.getBytes(); // convert the text to bytes
	sign.update(bytes);  // now update byte to the signature 
	
	// Now get the signature from the sign by the method sign() return byte[]
	byte[] signature=sign.sign(); 
	
	// display signature in string format
	System.out.println("Digital Signature: "+new String(signature)); 
	
	}
}
