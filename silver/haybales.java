import java.io.*;
import java.util.*;

/*
4 6
3 2 7 5
2 3
2 4
2 5
2 7
4 6
8 10
ans:
2
2
3
4
1
0
*/

//USACO Silver 2016 December contest, problem: haybales

public class haybales {
	static int []a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		int n = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pw.println(bsearch(y) - bsearch(x-1));
		}
		pw.close();
	}
	static int bsearch(int val) {
		if (a[0] > val)
			return 0;
		int lo = 0, hi = a.length-1;
		while (lo!= hi) {
			int mid = (lo+hi+1)/2;
			if (a[mid] <= val)
				lo = mid;
			else 
				hi = mid-1;
		}
		return lo+1;
	}
}
