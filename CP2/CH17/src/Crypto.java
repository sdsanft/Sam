import java.io.*;
import java.util.*;

public class Crypto {
	//v/V = “ag’,r”,
	//m/M = “ssad”,
	//g/G = “jeb..w”
	//b/B = “dug>?/”
	
	public String encrypt (String s) {
		s = s.replace("v", "ag',r");
		s = s.replace("V", "ag',r");
		s = s.replace("m", "ssad");
		s = s.replace("M", "ssad");
		s = s.replace("g", "jeb..w");
		s = s.replace("G", "jeb..w");
		s = s.replace("b", "dug>?/");
		s = s.replace("B", "dug>?/");
		return(s);
	}
	
	public String encrypt2 (String s, int k) {
		//48 - 122
		int l = s.length();
		int[] str = new int[l];
		for (int i = 0; i < l; i++) {
			str[i] = s.charAt(i);
			//System.out.print(str[i]);
		}
		for (int i = 0; i < l; i++) {
			if (str[i] >= 48 && str[i] <= 122) {
				str[i] += (k + (i % 26));
				str[i] -= 48;
				str[i] %= (122 - 48);
				str[i] += 48;
			}
		}
		
		s = "";
		for (int i = 0; i < l; i ++) {
			//System.out.print(str[i]);
			s += Character.toString((char)str[i]);
		}
		
		return(s);
	}
	
	public String decrypt2 (String s, int k) {
		//48 - 122
		int l = s.length();
		int[] str = new int[l];
		for (int i = 0; i < l; i++) {
			str[i] = s.charAt(i);
			//System.out.print(str[i]);
		}
		for (int i = 0; i < l; i++) {
			if (str[i] >= 48 && str[i] <= 122) {
				str[i] -= (k + (i % 26));
				while (str[i] < 48) {
					str[i] += (122-48);
				}
			}
		}
		
		s = "";
		for (int i = 0; i < l; i ++) {
			//System.out.print(str[i]);
			s += Character.toString((char)str[i]);
		}
		
		return (s);
	}
	
	public String decrypt (String s) {
		s = s.replace("dug>?/", "b");
		s = s.replace("jeb..w", "g");
		s = s.replace("ssad", "m");
		s = s.replace("ag',r", "v");
		return(s);
	}
}
