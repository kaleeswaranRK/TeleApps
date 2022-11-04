package org.tele;

import java.util.ArrayList;
import java.util.List;

public class OccuranceClass {
	public static void main(String[] args) {
		String s="",s1="";
		int a[]= {1,10,3,2,4,4,6,2,10,1,2,2,4,5,6,6,11};
		for (int i : a) {
			if (s.contains("key = "+i+" count = ")) {
				int num=s.indexOf("key = "+i+" count = ")+16;
				if (i%10!=0||i==10) {
					num=num+1;
				}
				int val=s.charAt(num)-'0';
				String e="key = "+i+" count = "+val;
				String e2="key = "+i+" count = "+(val+1);
				s1 = s.replaceAll(e,e2);
				s=s1;
			}
			else {
				s=s+"key = "+i+" count = "+1+"--";
			}
		}
		System.out.println(s);
		String[] split = s.split("--");
		for (String string : split) {
			System.out.println(string);
		}

	}

}
