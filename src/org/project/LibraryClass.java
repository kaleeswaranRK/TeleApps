package org.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class LibraryClass {
	static Scanner s = new Scanner(System.in);
	static UserAccess u = new UserAccess();
	static String rent;
	static String give;

	public static void main(String[] args) {
		try {
			u.getM().put("PrathapaMudaliarCharithram", "MayavaramVedanayagamPillai");
			u.getM().put("Periyapuranam", "Sekkilar");
			u.getM().put("SilaNerangalilSilaManithargal", "D.Jayakanthan");
			u.getM().put("VishnupuramandVenmurasu", "Jeymohan");
			u.getM().put("Manimekalai", "Sattanar");
			u.getM().put("Ramavatharam", "Kamban");
			u.getM().put("Athichoodi", "Auvaiyar");
			u.getM().put("Mooturai", "Auvaiyar");
			u.getM().put("Kalingattuparani", "Jayamkondar");
			System.err.println("_________________________________________________________");
			System.err.println("*****************Welcome to K-Library******************");
			System.err.println("_________________________________________________________");
			Thread.sleep(2000);
			System.out.println("Enter Your Username : ");
			u.setName(s.nextLine());
			userVerification(u.getName());
			System.err.println("________________________________________________________");
			System.err.println("********************Thank You*************************");
			System.err.println("________________________________________________________");
			s.close();
		} catch (Exception e) {
			
		}
	}

	public static void userVerification(String name) {
		try {
			if (u.getUserNames().contains(name)) {
				System.out.println("Enter Your Password : ");
				PasswordVerification(name);
			} else {
				System.err.println("_____________________________________________________");
				System.err.println("******************Invalid Username******************");
				System.err.println("_____________________________________________________");
				Thread.sleep(1000);
				System.out.println("Enter valid Username : ");
				u.setUser(s.nextLine());
				userVerification(u.getUser());
			}
		} catch (Exception e) {

		}
	}

	public static void bookMenu() {
		try {
			System.out.println("_____________________________________________________");
			System.out.println("******************Select Book by*********************");
			System.out.println("_____________________________________________________\n1.Author Name\n2.Book Name");
			u.setChoice(s.nextInt());
			s.skip("\\R?");
			if (u.getChoice() == 1) {
				authorBook();
			} else if (u.getChoice() == 2) {
				System.out.println("Available Books : ");
				System.out.println(u.getM().keySet());
				bookSelection();
			} else {
				System.out.println("_____________________________________________________");
				System.out.println("*************Enter Valid Option**************");
				System.out.println("_____________________________________________________");
				bookMenu();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void authorBook() throws ClassNotFoundException, SQLException {
		try {
			System.out.println("_____________________________________________________");
			System.out.println("*****************Available Authors*******************");
			System.out.println("_____________________________________________________");
			System.out.println(u.getM().values());
			Thread.sleep(1000);
			System.out.println("Enter Author Name : ");
			u.setAuthor(s.nextLine());
			if (u.getM().containsValue(u.getAuthor())) {
				System.out.println("Processing....");
				Thread.sleep(3000);
				System.out.println("_____________________________________________________");
				System.out.println("**********Books Availabe For Your Selection********");
				System.out.println("_____________________________________________________");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "kaleesmech");
				Statement stat = con.createStatement();
				ResultSet exe = stat
						.executeQuery("Select Book_name from Library where Author_name='" + u.getAuthor() + "'");
				int num = 1;
				while (exe.next()) {
					System.out.println(num + "." + exe.getString(1));
					num++;
				}
				bookSelection();
			} else {
				System.err.println("___________________________________________________________");
				System.err.println("********************Invalid Author Name*******************");
				System.err.println("___________________________________________________________");
				Thread.sleep(1000);
				authorBook();
			}

		}

		catch (Exception e) {

		}

	}

	public static void bookSelection() throws SQLException, ClassNotFoundException {

		try {
			Thread.sleep(1000);
			System.out.println("Enter Book Name You Want : ");
			u.setBook(s.next());
			System.out.println("Processing...");
			if (u.getM().containsKey(u.getBook())) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "kaleesmech");
			Statement stat = con.createStatement();
			ResultSet exe = stat.executeQuery("Select * from Library where book_name='" + u.getBook() + "'");
			System.out.println("_____________________________________________________");
			System.out.println("*******************Book Details*********************");
			System.out.println("_____________________________________________________");
			while (exe.next()) {
				System.out.println("Book Name       :\t " + exe.getString(2) + "\nAuthor Name     :\t "
						+ exe.getString(3) + "\nNumber of Page  : \t" + exe.getString(4) + "\nAvailable Count : \t"
						+ exe.getString(5) + "\nBook Rate       : \tRs." + exe.getString(6));
			}
			Thread.sleep(1000);
			endClass();
			}
			else {
				System.err.println("___________________________________________________________");
				System.err.println("********************Invalid Book Name*******************");
				System.err.println("___________________________________________________________");
				Thread.sleep(1000);
				bookSelection();
			}
		}

		catch (Exception e) {

		}
	}

	public static void endClass() {
		try {
			System.out.println("_____________________________________________________");
			System.out.println("***********If you want to Rent Book*************");
			System.out.println("_____________________________________________________\nPress 1 for Yes\nPress any other key for No");
			u.setContinue(s.nextInt());
			if (u.getContinue() == 1) {
				System.out.println("Processing....");
				SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
				rent = d.format(new Date());
				LocalDate loc = LocalDate.parse(rent);
				give = loc.plusMonths(1).toString();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "kaleesmech");
				Statement stat = con.createStatement();
				stat.executeQuery(
						"update K_users set Book_Name='" + u.getBook() + "' where User_Name='" + u.getName() + "'");
				change1();
				change2();
				Thread.sleep(2000);
				System.out.println("_____________________________________________________");
				System.out.println("**************Book is Rented*********************");
				Thread.sleep(1000);
				System.out.println("_____________________________________________________");
				System.out.println("If you want to continue \n1.Yes \n2.No");
				u.setContinue(s.nextInt());
				if (u.getContinue() == 1) {
					bookMenu();
				}
			} else {
				System.out.println("If you want to continue \n1.Yes \nPress Any other key for No");
				u.setContinue(s.nextInt());
				if (u.getContinue() == 1) {
					bookMenu();
				}
			}
		} catch (Exception e) {

		}

	}

	private static void change1() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "kaleesmech");
			Statement stat = con.createStatement();
			stat.executeQuery("update K_users set RENT_DATE='" + rent + "' where User_Name='" + u.getName() + "'");
		} catch (ClassNotFoundException e) {

		}

	}

	private static void change2() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "kaleesmech");
			Statement stat = con.createStatement();
			stat.executeQuery("update K_users set RETURN_DATE='" + give + "' where User_Name='" + u.getName() + "'");
		} catch (ClassNotFoundException e) {

		}
	}

	public static void PasswordVerification(String name) throws InterruptedException {
		try {
			try {
			u.setPass(s.nextInt());
			}
			catch (Exception e) {
				s.nextLine();
			}
			FileInputStream fin = new FileInputStream(new File(
					"C:\\Users\\kalees\\eclipse-workspace\\TeleAppsClass\\DataFiles\\UserPassword.properties"));
			Properties p = new Properties();
			p.load(fin);
			u.setPassword(Integer.parseInt(p.getProperty(name)));
			if (u.getPassword() == u.getPass()) {
				bookMenu();
			} 
			else {
				System.err.println("_____________________________________________________");
				System.err.println("*****************Invalid password********************");
				System.err.println("_____________________________________________________");
				Thread.sleep(1000);
				System.out.println("Enter Valid Password : ");
				PasswordVerification(name);
			}

		} catch (Exception e) {

		}
		
	}
}
