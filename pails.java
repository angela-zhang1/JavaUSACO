/*
17 25 77
ans:
76 
*/

import java.io.*;
import java.util.*;

public class pails {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		//String str = new String (br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		
		int ret = 0;
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int temp = Math.min(x, y); int temp2 = Math.max(x, y);
		x = temp; y = temp2;
		int c; int d;
		
		if ((x*y-x-y) > m) {
			for (int i = 0; i <= (m / x); i++) {
				c = i * x;
				d = (m -c) - (m-c) % y;
				if ((c+d) > ret) {
					ret = c+d;
				}
			}
		}
		else {
			ret = m;
		}
		
		br.close();
		pw.println(ret);
		pw.close();
		//
	}
}
