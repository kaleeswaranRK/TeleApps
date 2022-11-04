package org.tele;

import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Current Units ");
		int units=s.nextInt();
		ElectricBill e=new ElectricBill();
		ElectricBill.Bill b=e.new Bill();
		if (units<=100) {
			e.noBill();
		}
		else {
			switch (units/100) {
			case 1:
				b.billTwo(units, 0);
				break;
			case 2:
				b.billThree(units, 0);
				break;
			case 3:
				b.billfour(units, 0);
				break;
			default:
				b.billfive(units, 0);
				break;
			}
		}
	}

}
