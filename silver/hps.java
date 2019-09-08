import java.io.*;
import java.util.*;

//USACO Silver 2017 January Contest, problem: hps

/*
5
P
P
H
P
S
ans:
4
*/
public class hps {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader (new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		int n = Integer.parseInt(br.readLine());
		int [] b = new int [n];
		int[][]count = new int[3][2];
		int maxF = 0;
		int maxB = 0;
		int ret = 0;
		count[0][0] = 0;
		count[1][0] = 0;
		count[2][0] = 0;
		count[0][1] = 0;
		count[1][1] = 0;
		count[2][1] = 0;
		//	  F B
		//	H x x
		//	P x x
		//	S x x
		for (int i = 1; i <= n; i++) {
			String x = br.readLine();
			if (x.equals("H")) {
				count[0][0]++;
			}
			if (x.equals("P")) {
				count[1][0]++;
				b[n-i]= 1;
			}
			if (x.equals("S")) {
				count[2][0]++;
				b[n-i] = 2;
			}
		}
		br.close();
		
		for (int i = 0; i < n; i++) {
			maxF = Math.max(count[0][0], Math.max(count[1][0], count[2][0]));
			maxB = Math.max(count[0][1], Math.max(count[1][1], count[2][1]));
			ret = Math.max(ret, (maxF + maxB));
			count[b[i]][1] ++;
			count[b[i]][0] --;
		}
		maxF = Math.max(count[0][0], Math.max(count[1][0], count[2][0]));
		maxB = Math.max(count[0][1], Math.max(count[1][1], count[2][1]));
		ret = Math.max(ret, (maxF + maxB));
		pw.println(ret);
		pw.close();
	}
}
