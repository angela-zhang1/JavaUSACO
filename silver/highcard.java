import java.io.*;
import java.util.*;

/*
3
1
6
4
ans:
2
*/

//2015 December Silver

public class highcard {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		int n = Integer.parseInt(br.readLine());
		boolean[] a = new boolean[2*n]; //store which cards are Bessie's vs Elsie's
		Arrays.fill(a, false);
		int x = 0;
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());
			a[x-1] = true; //true: elsie, false: bessie
		}
		br.close();
		int ret = 0;
		int greatnumbers = 0;
		//if we run out of greatnumbers... add 1 to ret.
		for (int i = n *2-1; i >= 0; i--) {
			if (!a[i]) { //elsie
				if (greatnumbers > 0) {
					greatnumbers--;
				}
				else {
					ret++;
				}
			}
			else { //bessie
				greatnumbers++;
			}
		}
		pw.println(n-ret);
		pw.close();
	}
}
