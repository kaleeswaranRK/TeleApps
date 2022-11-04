package org.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Stack;

public class SearchEngine {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome To A-Search-Engine");
		Scanner sc = new Scanner(System.in);
		FileOutputStream fin = new FileOutputStream(
				"C:\\Users\\kalees\\eclipse-workspace\\TeleAppsClass\\DataFiles\\searchproperty.properties");
		Properties p = new Properties();
		String s1="";
		LinkedHashSet hm = new LinkedHashSet();
		Stack a = new Stack();
		boolean y = true;
		while (y) {
			System.out.println("searching 1.yes 2.No");
			String s = sc.next();
			if (s.equalsIgnoreCase("yes")) {
				s1 = sc.next();
				// String s2=sc.next();
				a.push(s1);
				hm.add(s1);
			} else {
				System.out.println("thank you");
				y = false;
			}
			System.out.println(a);
			System.out.println(hm);
			p.setProperty(s1, s1);
			p.store(fin, "");

		}
	}
}
