import java.io.*;
import java.util.*;

/*
3
fox box
dog cat
car bus
ans:
2
2
2
1
0
1
1
0
0
0
0
0
0
0
2
0
0
1
1
1
1
0
0
1
0
0 
*/

//USACO Bronze 2016 December Contest, problem: blocks

public class blocks {
	public static void main (String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter("blocks.out")));
		int x = Integer.parseInt(st.nextToken());
		int[] ret = new int[26];
		String first; String second; String temp; String letters; int ascii; char y;
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			first = st.nextToken();
			second = st.nextToken();
			temp = first + second;
			for (int j = 0; j < temp.length(); j++) {
				y = temp.charAt(j);
				ascii = (int) y;
				ret[ascii-97]++;
			}
			letters = commonLetters(first,second);
			for (int j = 0; j< letters.length(); j++) {
				y = letters.charAt(j);
				ascii = (int) y;
				ret[ascii-97]--;
			}
		}
		br.close();
		for (int i = 0; i < 26; i++) {
			pw.println(ret[i]);
		}
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
