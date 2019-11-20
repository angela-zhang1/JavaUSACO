import java.io.*;
import java.util.*;

/*
3
4 6
7 2
2 5
ans:
2
*/

public class mountains {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		state [] a = new state[n];
		state z; int x; int y;
		int large = -1;
		int ret = n;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = new state(x-y,x+y);
			a[i] = z;
		}
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			if (large >= a[i].e) {
				ret--;
			}
			else {
				large = a[i].e;
			}
		}
		System.out.println(ret);
	}
	static class state implements Comparable<state> {
		int s;
		int e;
		public state(int start, int end) {
			s = start;
			e = end;
		}
		public int compareTo (state o) { //if it is inside the other one
			if (o.s > this.s)
				return 1;
			else if (o.s < this.s)
				return -1;
			else if (o.e > this.e)
				return -1;
			else if (o.e < this.e)
				return 1;
			return 0;
		}
	}
}

