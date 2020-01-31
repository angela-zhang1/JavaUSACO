import java.io.*;
import java.util.*;

/*
3
1 8
2 5
1 2
ans:
10
*/

//2017 US open silver

public class pairup {
	public static void main (String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		StringTokenizer st;
		
		int m = 0;
		int n = Integer.parseInt(br.readLine());
		state[] a = new state[n];
		state z; int x; int y;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = new state(x, y);
			a[i] = z;
		}
		
		Arrays.sort(a);
	}
	static class state implements Comparable<state> {
		public int x; //value
		public int n; //number of cows
		public state(int number, int value) {
			x = value;
			n = number;
		}
		public int compareTo(state o) {
			if (x < o.x)
				return -1;
			if (x > o.x)
				return 1;
			return 0;
		}
	}
}
