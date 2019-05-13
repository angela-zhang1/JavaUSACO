import java.io.*;
import java.util.*;
/*
3 8
AATCCCAT
GATTGCAA
GGTCGCAA
ACTCCCAG
ACTCGCAT
ACTTCCAT
ans:
1 
*/

public class cownomics {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		int x; int y; String z; String w; String c = ""; String d = ""; int ret = 0;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		String[] a = new String[x];
		String[] b = new String[x];
		for (int i = 0; i < x*2; i++) {
			st = new StringTokenizer(br.readLine());
			w = st.nextToken();
			if (i<x) {
				a[i] = w;
			}
			else {
				b[i-x] = w;
			}
		}
		br.close();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				c+= a[j].charAt(i);
				d+= b[j].charAt(i);
			}
			z = commonLetters(c,d);
			if (z == null || z == "") {
				ret++;
			}
			c = "";d = "";
		}
		pw.println(ret);
		pw.close();
	}
	public static String commonLetters (String one, String two) {
		String temp; String ret = ""; char x;
		if (one.length() > two.length()) {
			temp = one;
			one = two;
			two = temp;
		}
		for (int i = 0; i <one.length(); i++) {
			x = one.charAt(i);
			for (int j = 0; j < two.length(); j++) {
				if (two.charAt(j) == x) {
					two = two.substring(0, j) + two.substring(j+1, two.length());
					one = one.substring(0, i) + one.substring(i+1, one.length());
					ret += x;
					i--;j--;
					break;
				}
			}
		}
		return ret;
	}
}
