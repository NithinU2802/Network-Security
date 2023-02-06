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
    
    public static String encryp(String s,int k){
        String res="";
        for(int i=0;i<s.length();i++){
            int f=0;
            char a=s.charAt(i);
            if(Character.isUpperCase(a)) f=1;
            a=Character.toLowerCase(a);
            int p=(int)(a-'a');
            char c=(char)((p+k)%26);
            char ch='a';
            if(f==1) ch='A';
            res+=(char)(c+ch);
        }
        return res;
    }
    
    public static String Decrypt(String s,int k){
        String res="";
        for(int i=0;i<s.length();i++){
            int f=0;
            char a=s.charAt(i);
            if(Character.isUpperCase(a)) f=1;
            a=Character.toLowerCase(a);
            int p=(int)(a-'a');
            int c=((p-k)%26);
            if(c<0) c+=26;
            char ch='a';
            if(f==1) ch='A';
            res+=(char)(c+ch);
        }
        return res;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	System.out.print("Data: ");
	String s=x.nextLine();
	System.out.print("Key: ");
	int k=x.nextInt();
	String en=encryp(s,k);
	System.out.println("Encrypted: "+en);
	System.out.print("Decrypted: "+Decrypt(en,k));
	}
}
