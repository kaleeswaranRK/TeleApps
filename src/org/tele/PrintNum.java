package org.tele;

import java.util.Scanner;

public class PrintNum {
	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		String a[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Tweleve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String b[] = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		if (num < 20 && num >= 0) {
			System.out.println(a[num]);
		} else if (num >= 20 && num < 100) {
			int val = num / 10;
			int rem = num % 10;
			if (rem == 0) {
				System.out.println(b[val]);
			} else {
				System.out.println(b[val] + " " + a[rem]);
			}
		} else if (num >= 100) {
			int val = num / 100;
			int hun = num % 100;
			int rem = num % 10;
			System.out.println(a[val] + " Hundred and " + b[hun / 10] + " " + a[rem]);
		}
	}

}
