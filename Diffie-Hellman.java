/******************************************************************************

    To implement the Diffie-Hellman Key Exchange algorithm for a given
problem.

Aim: TO generate same type of key on both end...!

1. Need to consider same Prime Number on both end.
2. Select Primitive root which is nothing but a number g^n mod p is distinct,
Where the value of n=> 0 to p-1..!

Now Easy to solve the problem by generating public key and exchange the generate 
key easily....!

Public key:
   ASend = g^x MOD p
   BSend = g^y MOD p 
   
Secret Key:
   AComputes = BSend^x MOD p 
   BComputes = ASend^y MOD p 
   
if(AComputes==BComputes) then Secret keys has been exchanged Successfully...!
else something happens during key exchange..!
   

*******************************************************************************/
import java.util.*;

public class Main{
	public static void main(String[] args) {
	int p=23; // Prime Number 
	int g=2;  // Primitive root 
	int x=4;  // Private key of A 
	int y=3;  // Private Key of B
	
	// Generate to send temperory public key 
	double ASend=(Math.pow(g,x))%p;
	double BSend=(Math.pow(g,y))%p;
	
	// Generate Key for both end 
	double BComputes=(Math.pow(ASend,y))%p;
	double AComputes=(Math.pow(BSend,x))%p;
	
	if(BComputes==AComputes) 
	System.out.println("Key Exchange Happens Successfully....!");
	else 
	System.out.println("Sorry...! Key Exchange has problem..!");
	
	
	}
}
