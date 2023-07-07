/******************************************************************************

Experiment 1 a)

Perform encryption, decryption using Ceaser cipher

Input: Data: zap
       Key : 3
Output: Crypted: cds
        Decrypt: zap
        
Input: Data: Nithin
       Key : 40
Output: Crypted: Bwhvwb
        Decrypt: Nithin

formula: 

Encryp:  (p+k)%26 p-> alphabetic order index (a-0,b-1.....)
                  k-> key value
                  
Decrypt: (p-k)%26 p-> alphabetic order index (a-0,b-1.....)
                  k-> key value
                  
*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	String s=x.nextLine();
	int n=x.nextInt();
	String r="";
	char d;
	for(int i=0;i<s.length();i++){
	    if(Character.isUpperCase(s.charAt(i))){
	    d=(char)(((s.charAt(i)-64)+n)%26);
	    r+=(char)(d+64);
	    }else{
	    d=(char)(((s.charAt(i)-96)+n)%26);
	    r+=(char)(d+96);
	    }
	}
	System.out.println(r);
	}
}
