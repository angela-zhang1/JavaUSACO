import java.io.*;
import java.util.*;

/*
7 2
20
25
18
8
10
3
1
ans:
5
*/

//USACO Silver 2016 January contest, problem: angry

public class angry {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		int lo = 0;
		int hi = a[a.length-1];
		while (lo < hi) {
			int mid = (lo + hi)/2;
			int g = 0;
			int p = 0;
			while (p < n) {
				g++;
				int c = p+1;
				while (c<n && (a[c]-a[p] <= 2*mid))
					c++;
				p = c;
			}
			if (g<=k)	hi = mid;
			else		lo = mid + 1;
		}
		pw.println(lo);
		pw.close();
	}
}
