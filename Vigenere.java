/******************************************************************************

Implementation of Vigenere Cipher...!

Input : Plaintext :   GEEKSFORGEEKS
             Keyword :  AYUSH
Output : Ciphertext :  GCYCZFMLYLEIM

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String plain=x.nextLine();
	String key=x.nextLine();
	String cipher="";
	int k=0;
	for(int i=0;i<plain.length();i++){
	if(Character.isUpperCase(plain.charAt(i)))
	cipher+=((char)('A'+((plain.charAt(i)+key.charAt(k))%26)));
	else 
	cipher+=((char)('a'+((plain.charAt(i)+key.charAt(k))%26)));
	k++;
	if(k==key.length()) k=0;
	}
	System.out.println(cipher);
	plain="";
	k=0;
	for(int i=0;i<cipher.length();i++){
	if(Character.isUpperCase(cipher.charAt(i)))
	plain+= (char) ('A' + (cipher.charAt(i) - 'A' - key.charAt(k) + 'A' + 26) % 26);
    else
    plain += (char) ('a' + (cipher.charAt(i) - 'a' - key.charAt(k) + 'A' + 26) % 26);
	k++;
	if(k==key.length()) k=0;
	}
	System.out.print(plain);
	}
}
