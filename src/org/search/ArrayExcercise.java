package org.search;

public class ArrayExcercise {
public static void main(String[] args) {
	int a[][]= {{3,3,3},{3,3,3},{3,3,3}};
	int b[]=new int[a.length];
	int k=0;
	if (a[k][k]==a[k+1][k+1]&&a[k+2][k+2]==a[k][k]) {
		System.out.println("Diagnal same");
	}
	if (a[k][k+2]==a[k+2][k]&&a[k+1][k+1]==a[k+2][k]) {
		System.out.println("Diagnal same");
	}
	for (int i = 0; i < a.length; i++) {
		int j=0;
			if (a[i][j]==a[i][j+1]&&a[i][j+2]==a[i][j]) {
				System.out.println("same");
			}
			if (a[j][i]==a[j+1][i]&&a[j+2][i]==a[i][j]) {
				System.out.println("same");
			}	
	}
	
//	if (b[0]==b[1]&&b[0]==b[2]) {
//		System.out.println("Diagnal are same");
//	}
//	else {
//		System.out.println("Diagnal are not same");
//	}
}
}
