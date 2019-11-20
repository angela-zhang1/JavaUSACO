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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			
		}
		for (int i = 0; i < n; i++) {
			
		}
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
			if (o.s < this.s)
				return -1;
			return 0;
		}
	}
}
