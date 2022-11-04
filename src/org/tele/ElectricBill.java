package org.tele;

public class ElectricBill {

	public void noBill() {
		System.out.println("Your current Bill Amount =  0");

	}
	class Bill {
		public void billTwo(double units, double amount) {

			double Ebill = (units-100) * 1.20;
			System.out.println("Your current bill Amount= "+(Ebill+amount));
		}

		public void billThree(double units, double amount) {
			double bal=units-200;
			double Ebill = bal * 2.20;
			billTwo(units-bal, Ebill+amount);
		}

		public void billfour(double units, double amount) {
			double bal=units-300;
			double Ebill = bal * 3.20;
			billThree(units-bal, Ebill+amount);
			
		}

		public void billfive(double units, double amount) {
			double bal=units-400;
			double Ebill = bal * 4.20;
			billfour(units-bal, Ebill);
		}
	}

}
