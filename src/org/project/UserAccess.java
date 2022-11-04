package org.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAccess {
	private String name;
	private String user;
	private List<String> userNames = new ArrayList(Arrays.asList("kaleeswaran", "ashwin", "suseendran", "selva",
			"rahul", "anish", "arun", "tharun", "ilakiya", "gokul"));
	private Map<String, String> m = new HashMap<>();
	private int choice;
	private String author;
	private String book;
	private int Continue;
	private int pass;
	private int password;
	private String rent;
	private String give;

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getGive() {
		return give;
	}

	public void setGive(String give) {
		this.give = give;
	}

	public Map<String, String> getM() {
		return m;
	}

	public void setM(Map<String, String> m) {

		this.m = m;
	}

	public List<String> getUserNames() {
		return userNames;
	}

	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getContinue() {
		return Continue;
	}

	public void setContinue(int continue1) {
		Continue = continue1;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

}
