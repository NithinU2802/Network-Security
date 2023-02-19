/******************************************************************************

PlayFair Cipher to encrypt and decrypt the data.....

Input:
Enter Data: nithin
Key Text: monarchy

Output:
Encrypt: agpdga
Decrypt: nithin


Input:
Enter Data: balloon
Key Text: key 

Output:
Encrypt: kbnvmiio
Decrypt: balxloon

*******************************************************************************/
import java.util.*;

public class Main
{
    static char[][] g=new char[5][5];
    static int[] ap=new int[127];
    
    public static void create(String a){
        int k=0;
        char d='a';
        int f=0;
        for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
         if(k<a.length()){ 
         while(k<a.length()){ 
             if(ap[a.charAt(k)]==0) break;
             k++;
         }
         g[i][j]=a.charAt(k);
         if(a.charAt(k)=='j') f=1;
         ap[a.charAt(k++)]=1;
         }else{
             while(ap[d]==1 || (d=='j' && f==0) || (d=='i' && f==1) ){ 
                 if(d=='z') d='a';
                 else d++;
             }
         g[i][j]=d;
         ap[d]=1;
         }
        }
        }
    }
    
    public static String encrypt(String s){
        String r="";
        int i=0,j=0,i1=0,j1=0;
        for(int e=0;e<s.length();e+=2){
            char c1=s.charAt(e);
            char c2=s.charAt(e+1);
            int f=0;
            for(i=0;i<5;i++){
            for(j=0;j<5;j++)
            if((g[i][j])==c1){ f=1; break; }
            if(f==1) break;
            }
            f=0;
            for(i1=0;i1<5;i1++){
            for(j1=0;j1<5;j1++)
            if((g[i1][j1])==c2){ f=1; break; }
            if(f==1) break; 
            }
            if(i==i1){
                
                if(j+1>4) r+=g[i][0];
                else r+=g[i][j+1];
                if(j1+1>4) r+=g[i][0];
                else r+=g[i][j1+1];
                
            }else if(j==j1){
                
                if(i+1>4) r+=g[0][j];
                else r+=g[i+1][j];
                
                if(i1+1>4) r+=g[0][j];
                else r+=g[i1+1][j1];
                
            }else{
                r+=g[i][j1];
                r+=g[i1][j];
            }
        }
        return r;
    }
    
    public static String decrypt(String s){
        String r="";
        int i=0,j=0,i1=0,j1=0;
        for(int e=0;e<s.length();e+=2){
            char c1=s.charAt(e);
            char c2=s.charAt(e+1);
            int f=0;
            for(i=0;i<5;i++){
            for(j=0;j<5;j++)
            if((g[i][j])==c1){ f=1; break; }
            if(f==1) break;
            }
            f=0;
            for(i1=0;i1<5;i1++){
            for(j1=0;j1<5;j1++)
            if((g[i1][j1])==c2){ f=1; break; }
            if(f==1) break; 
            }
            if(i==i1){
                
                if(j-1<0) r+=g[i][4];
                else r+=g[i][j-1];
                if(j1-1<0) r+=g[i][4];
                else r+=g[i][j1-1];
                
            }else if(j==j1){
                
                if(i-1<0) r+=g[4][j];
                else r+=g[i-1][j];
                
                if(i1-1<0) r+=g[4][j];
                else r+=g[i1-1][j1];
                
            }else{
                r+=g[i][j1];
                r+=g[i1][j];
            }
        }
        return r;
    }
    
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	System.out.print("Enter Data: ");
	String d=x.next();
	System.out.print("Key Text: ");
	String a=x.next();
	String s="";
	s+=d.charAt(0);
	int c=1;
	for(int i=1;i<d.length();i++){
	    if(d.charAt(i)==d.charAt(i-1) && c==1){ s+='x'; s+=d.charAt(i); continue; }
	    if(c==2) c=0;
	    s+=d.charAt(i);
	    c++;
	}
	if(s.length()%2!=0) s+='x';
	create(a);
	String en=encrypt(s);
	System.out.println("Encrypt: "+en);
 	System.out.print("Decrypt: "+decrypt(en));
	}

}
