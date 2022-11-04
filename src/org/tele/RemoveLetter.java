package org.tele;

public class RemoveLetter {
public static void main(String[] args) {
	String s="abccbdabbc";
	String rem="",ca="";int i;
	for ( i = 1; i < s.length();) {
		
			if (s.charAt(i)==s.charAt(i-1)) {
				i+=2;
				continue;
			}
			rem=rem+s.charAt(i-1);
			i++;
		}
	rem=rem+s.charAt(i-1);
	for ( i = 1; i < rem.length();) {
		
		if (rem.charAt(i)==rem.charAt(i-1)) {
			i+=2;
			continue;
		}
		ca=ca+rem.charAt(i-1);
		i++;
	}
	ca=ca+rem.charAt(i-1);
	System.out.println(ca);
}	
}

