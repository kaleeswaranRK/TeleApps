package org.tele;

import java.util.Scanner;

public class ProductClass {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rem, sum = 0, count = 0, n;
		System.out.println("Enter a number ");
		int num = s.nextInt();
		n = num;
		while (num > 0) {
			num /= 10;
			count++;
		}
		num = n;
		while (num > 0) {
			rem = num % 10;
			sum = sum + (int) Math.pow(rem, count);
			num /= 10;
			count--;
		}
		System.out.println(sum);
		n=0;
		while (String.valueOf(sum).length() > 1) {

			while (sum > 0) {
				n += sum % 10;
				sum/=10;
			}
		}

		System.out.println("Sum= " + n);

	}

}
